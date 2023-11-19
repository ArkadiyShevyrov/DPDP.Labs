package ru.bmstu.iu9.dpdp_lab_2;

import ru.bmstu.iu9.dpdp_lab_2.model.*;
import ru.bmstu.iu9.dpdp_lab_2.service.Service;
import java.util.Arrays;

public class d {
    public static void main(String[] args) {
        Service service = new Service();
        double[][] a = {
                {2.0, 1.0, 1.0},
                {1.0, 2.0, 1.0},
                {1.0, 1.0, 2.0}
        };
        double[] x = {0.0, 0.0, 0.0};
        double[] b = {4.0, 4.0, 4.0};
        double[] res1 = service.solveSystem(a, x, b, new ConjugateGradient());
        double[] res2 = service.solveSystem(a, x, b, new MinimalResiduals());
        double[] res3 = service.solveSystem(a, x, b, new SimpleIteration());
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}
