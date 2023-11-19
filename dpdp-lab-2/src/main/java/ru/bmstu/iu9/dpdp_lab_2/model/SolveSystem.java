package ru.bmstu.iu9.dpdp_lab_2.model;

public interface SolveSystem {
    double[] f(double[][] a, double[] x, double[] b);
    boolean g(double[][] a, double[] x, double[] b);
}
