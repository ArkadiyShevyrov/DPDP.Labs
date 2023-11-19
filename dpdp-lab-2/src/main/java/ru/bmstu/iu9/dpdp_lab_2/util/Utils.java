package ru.bmstu.iu9.dpdp_lab_2.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {
    public double calculateNorm(double[] x) {
        double norm = 0;
        for (double value : x) {
            norm += Math.pow(value, 2);
        }
        return Math.sqrt(norm);
    }

    public double[] addition(double[] a, double[] b) {
        int n = a.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public double[] subtract(double[] a, double[] b) {
        int n = a.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] =  a[i] - b[i];
        }
        return result;
    }

    public double[] multiply(double[][] a, double[] x) {
        int n = a.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            result[i] =  sum;
        }
        return result;
    }

    public double[] multiply(double[] x, double d) {
        int n = x.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] =  x[i] * d;
        }
        return result;
    }

    public double[] divide(double[] x, double d) {
        int n = x.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = x[i] / d;
        }
        return result;
    }

    public double dotProduct(double[] a, double[] b) {
        int n = a.length;
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}
