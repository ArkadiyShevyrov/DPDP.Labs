package ru.bmstu.iu9.dpdp_lab_2.model;

import ru.bmstu.iu9.dpdp_lab_2.util.Utils;

public class MinimalResiduals implements SolveSystem {
    private static final double epsilon = 0.00001;

    @Override
    public double[] f(double[][] a, double[] x, double[] b) {
        double[] y = Utils.subtract(
                Utils.multiply(a, x),
                b);
        double d1 = Utils.dotProduct(
                y,
                Utils.multiply(a, y));
        double d2 = Utils.dotProduct(
                Utils.multiply(
                        a,
                        y),
                Utils.multiply(
                        a,
                        y));
        double eta = d1 / d2;
        return Utils.subtract(
                x,
                Utils.multiply(
                        y,
                        eta));
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
