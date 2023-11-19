package ru.bmstu.iu9.dpdp_lab_2.model;

import ru.bmstu.iu9.dpdp_lab_2.util.Utils;

public class SimpleIteration implements SolveSystem {
    private static final double epsilon = 0.00001;

    @Override
    public double[] f(double[][] a, double[] x, double[] b) {
        double tau = 0.1 / a.length;
        return Utils.subtract(
                x,
                Utils.multiply(
                        Utils.subtract(
                                Utils.multiply(
                                        a,
                                        x),
                                b),
                        tau));
    }

    @Override
    public boolean g(double[][] a, double[] x, double[] b) {
        double v1 = Utils.calculateNorm(
                Utils.subtract(
                        Utils.multiply(a, x),
                        b));
        double v2 = Utils.calculateNorm(b);
        return v1 / v2 > epsilon;
    }
}
