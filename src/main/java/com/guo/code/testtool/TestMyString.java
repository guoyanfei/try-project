package com.guo.code.testtool;

import java.text.DecimalFormat;

/**
 * Created by gyf .
 * 16/9/1 .
 */
public class TestMyString {

    public static void main(String[] args) {
        TestMyString test = new TestMyString();
        double[] aaa = new double[2];
        aaa[0] = 0.0;
        aaa[1] = 0.0;

        System.out.println(1 - aaa[1] / aaa[0]);
        if (1 - aaa[1] / aaa[0] < 30 / 100) {
            System.out.println("你真帅");
        }
        System.out.println(test.convertPercentsToString(test.buildFlucDescPers(aaa)));
    }
    protected DecimalFormat m_df = new DecimalFormat("0.###");


    private double[] buildFlucDescPers(double[] values) {
        int length = values.length;
        double[] descPers = new double[length - 1];
        double baseVal = values[length - 1];

        for (int i = 0; i <= length - 2; i++) {
            descPers[i] = (1 - baseVal / values[i]) * 100;
        }

        return descPers;
    }

    protected String convertPercentsToString(double[] values) {
        StringBuilder builder = new StringBuilder();

        for (double value : values) {
            builder.append(m_df.format(value)).append("% ");
        }

        return builder.toString();
    }
}
