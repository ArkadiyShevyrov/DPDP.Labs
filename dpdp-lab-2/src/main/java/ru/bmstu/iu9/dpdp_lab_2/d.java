package ru.bmstu.iu9.dpdp_lab_2;

import mpi.MPI;
import ru.bmstu.iu9.dpdp_lab_2.model.*;
import ru.bmstu.iu9.dpdp_lab_2.service.Service;
import java.util.Arrays;

public class d {
    public static void main(String[] args) {
        MPI.Init(args);

        // Get the rank and size of the MPI process
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        double[][] a = {
                {2.0, 1.0, 1.0},
                {1.0, 2.0, 1.0},
                {1.0, 1.0, 2.0}
        };
        double[] x = {0.0, 0.0, 0.0};
        double[] b = {4.0, 4.0, 4.0};
        double[] res1 = Service.solveParallelSystem(a, x, b, new ConjugateGradient(), rank, size);
        double[] res2 = Service.solveParallelSystem(a, x, b, new MinimalResiduals(), rank, size);
        double[] res3 = Service.solveParallelSystem(a, x, b, new SimpleIteration(), rank, size);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}
