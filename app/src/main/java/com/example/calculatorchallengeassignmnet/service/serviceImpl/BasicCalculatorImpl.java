package com.example.calculatorchallengeassignmnet.service.serviceImpl;

import android.util.Log;

import com.example.calculatorchallengeassignmnet.service.BasicCalculatorInterface;

public class BasicCalculatorImpl implements BasicCalculatorInterface {

    private static final String TAG = BasicCalculatorImpl.class.getSimpleName();
    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double addition(double num1, double num2) {
        /* Log.d(TAG, "First Number: "+String.valueOf(num1));
        Log.d(TAG, "Second Number: "+String.valueOf(num2));*/

        double result = 0;
        try {
            result = num1 + num2;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        // Log.d(TAG,"Addition : "+ String.valueOf(result));
        return result;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double subtraction(double num1, double num2) {
          /*  Log.d(TAG, "First Number: "+String.valueOf(num1));
        Log.d(TAG, "Second Number: "+String.valueOf(num2));*/

        double result = 0;
        try {
            result = num1 - num2;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        //    Log.d(TAG,"Subtraction : "+ String.valueOf(result));
        return result;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double multiplication(double num1, double num2) {
         /*  Log.d(TAG, "First Number: "+String.valueOf(num1));
        Log.d(TAG, "Second Number: "+String.valueOf(num2));*/

        double result = 0;
        try {
            result = num1 * num2;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        // Log.d(TAG,"Multiplication : "+ String.valueOf(result));
        return result;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double division(double num1, double num2) {
         /* Log.d(TAG, "First Number: "+String.valueOf(num1));
        Log.d(TAG, "Second Number: "+String.valueOf(num2));
*/
        double result = 0;
        try {
            result = num1 / num2;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        //Log.d(TAG,"Division : "+ String.valueOf(result));
        return result;
    }
}
