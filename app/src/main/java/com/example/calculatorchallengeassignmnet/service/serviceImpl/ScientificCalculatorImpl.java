package com.example.calculatorchallengeassignmnet.service.serviceImpl;

import android.util.Log;

import com.example.calculatorchallengeassignmnet.service.ScientificCalculatorInterface;

public class ScientificCalculatorImpl  implements ScientificCalculatorInterface {

    private static final String TAG = ScientificCalculatorImpl.class.getSimpleName();
    /**
     *
     * @param num
     * @return
     */
    @Override
    public double calculateLogN(double num) {
        // Log.d(TAG, "Number: "+String.valueOf(num));

        double result = 0;
        try {
            result = Math.log10(num);
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        // Log.d(TAG,"Log base e  : "+ String.valueOf(result));
        return result;
    }

    /**
     *
     * @param num
     * @return
     */
    @Override
    public double calculateLogE(double num) {
        //    Log.d(TAG, "Number: "+String.valueOf(num));

        double result = 0;
        try {
            result = Math.log(num);
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        //  Log.d(TAG,"Log base e  : "+ String.valueOf(result));
        return result;
    }
}
