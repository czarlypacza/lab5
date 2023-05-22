package org.example;

public class InterpolacjaL {

    private double[] tabX = {-1,0,1,2};
    private double[] tabY = {3,1,2,-6};

    private int n = 3;

    public double oblicz(double x) {
        double wynik = 0;
        for(int i = 0; i <= n; i++) {
            double term = tabY[i];
            for(int j = 0; j <= n; j++) {
                if (j != i) {
                    term = term * (x - tabX[j]) / (tabX[i] - tabX[j]);
                }
            }
            wynik += term;
        }
        return wynik;
    }

    public String generujWzor() {
        StringBuilder wynik = new StringBuilder();

        for(int i = 0; i <= n; i++) {
            StringBuilder term = new StringBuilder();

            for(int j = 0; j <= n; j++) {
                if (j != i) {
                    double denominator = tabX[i] - tabX[j];
                    if (denominator == 1) {
                        term.append("(x - ").append(tabX[j]).append(")");
                    } else if (denominator != 0) {
                        term.append("(x - ").append(tabX[j]).append(") / ").append(denominator);
                    }
                    if (j != n-1) {
                        term.append(" * ");
                    }
                }
            }
            if (tabY[i] != 1) {
                term.insert(0, tabY[i] + " * ");
            }

            wynik.append(term);
            if (i != n) {
                wynik.append(" + ");
            }
        }
        return wynik.toString();
    }


}
