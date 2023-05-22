package org.example;

import umontreal.ssj.functions.MathFunction;

public class MyFunction implements MathFunction {
    @Override
    public double evaluate(double x) {
        return (x*x);
    }
}
