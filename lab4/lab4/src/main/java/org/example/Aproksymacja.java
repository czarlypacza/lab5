package org.example;

import Jama.Matrix;

public class Aproksymacja {
    int xy[][]={{-2,0},{1,2},{2,3}};
    int n = 2;
    double[][] tab = new double[4][xy.length*4];

    public String fun() {
        int N = xy.length;

        double[] x = new double[N];
        double[] y = new double[N];

        for (int i = 0; i < N; i++) {
            x[i] = xy[i][0];
            y[i] = xy[i][1];
        }

        double[][] A = new double[n+1][n+1];
        double[] B = new double[n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                A[i][j] = 0.0;
                for (int k = 0; k < N; k++) {
                    A[i][j] += Math.pow(x[k], i+j);
                }
            }

            B[i] = 0.0;
            for (int k = 0; k < N; k++) {
                B[i] += Math.pow(x[k], i) * y[k];
            }
        }

        Matrix AMatrix = new Matrix(A);
        Matrix BMatrix = new Matrix(B, n+1);

        Matrix result = AMatrix.solve(BMatrix);

        StringBuilder resultEquation = new StringBuilder();
        resultEquation.append(result.get(2, 0) + "x^2");
        if(result.get(1, 0) >= 0) {
            resultEquation.append(" + " + result.get(1, 0) + "x");
        } else {
            resultEquation.append(" - " + Math.abs(result.get(1, 0)) + "x");
        }
        if(result.get(0, 0) >= 0) {
            resultEquation.append(" + " + result.get(0, 0));
        } else {
            resultEquation.append(" - " + Math.abs(result.get(0, 0)));
        }

        return resultEquation.toString();
    }

}
