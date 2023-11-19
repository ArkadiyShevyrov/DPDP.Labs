package ru.bmstu.iu9.dpdp_lab_2.service;


import ru.bmstu.iu9.dpdp_lab_2.model.SolveSystem;

public class Service {


    public double[] solveSystem(double[][] a, double[] x, double[] b, SolveSystem solveSystem) {
        double[] currentX = x;
        while (solveSystem.g(a, currentX, b)) {
            currentX = solveSystem.f(a, currentX, b);
        }
        return currentX;
    }
}
