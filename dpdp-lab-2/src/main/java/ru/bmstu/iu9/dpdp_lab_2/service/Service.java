package ru.bmstu.iu9.dpdp_lab_2.service;


import mpi.MPI;
import mpi.MPIException;
import ru.bmstu.iu9.dpdp_lab_2.model.SolveSystem;

public class Service {


    public static double[] solveParallelSystem(double[][] A, double[] x, double[] b, SolveSystem solveSystem, int rank, int size) throws MPIException {
        int N = b.length;

        // Broadcast the size of the system to all processes
        MPI.COMM_WORLD.Bcast(new int[]{N}, 0, 1, MPI.INT, 0);

        // Scatter the matrix A among processes
        double[][] localA = new double[N / size][N];
        MPI.COMM_WORLD.Scatter(A, 0, N / size, MPI.OBJECT, localA, 0, N / size, MPI.OBJECT, 0);

        // Broadcast vectors x and b to all processes
        MPI.COMM_WORLD.Bcast(x, 0, N, MPI.DOUBLE, 0);
        MPI.COMM_WORLD.Bcast(b, 0, N, MPI.DOUBLE, 0);

        // Perform parallel solution
        double[] currentX = x;
        while (solveSystem.g(localA, currentX, b)) {
            currentX = solveSystem.f(localA, currentX, b);
            // Gather updated currentX to the root process
            MPI.COMM_WORLD.Gather(currentX, 0, N, MPI.DOUBLE, x, 0, N, MPI.DOUBLE, 0);
        }

        // Gather the final result to the root process
        MPI.COMM_WORLD.Gather(currentX, 0, N, MPI.DOUBLE, x, 0, N, MPI.DOUBLE, 0);

        // Print the result on the root process
        if (rank == 0) {
            System.out.println("Solution:");
            for (int i = 0; i < N; i++) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
        }

        return x;
    }
}
