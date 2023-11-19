package ru.bmstu.iu9.dpdp_lab_2.model;

import ru.bmstu.iu9.dpdp_lab_2.util.Utils;

public class ConjugateGradient implements SolveSystem {
    private static final double epsilon = 0.00001;

    double[] r;
    double[] z;

    @Override
    public double[] f(double[][] a, double[] x, double[] b) {
        if (r == null) {
            r = Utils.subtract(
                    b,
                    Utils.multiply(
                            a,
                            x));
            z = r;
        }
        double d1 = Utils.dotProduct(r, r);
        double d2 = Utils.dotProduct(
                Utils.multiply(
                        a,
                        z),
                z);
        double alpha = d1 / d2;
        double[] xN1 = Utils.addition(x,
                Utils.multiply(
                        z,
                        alpha));
        double[] rN1 = Utils.subtract(
                r,
                Utils.multiply(
                        Utils.multiply(
                                a,
                                z),
                        alpha)
        );
        double d3 = Utils.dotProduct(rN1, rN1);
        double d4 = Utils.dotProduct(r, r);
        double betta = d3/d4;
        double[] zN1 = Utils.addition(
                rN1,
                Utils.multiply(z, betta));
        r = rN1;
        z = zN1;
        return xN1;
    }

    @Override
    public boolean g(double[][] a, double[] x, double[] b) {
        if (r == null) {
            return true;
        }
        double v1 = Utils.calculateNorm(r);
        double v2 = Utils.calculateNorm(b);
        return v1 / v2 > epsilon;
    }
}
