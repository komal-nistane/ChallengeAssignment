package com.example.calculatorchallengeassignmnet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculatorchallengeassignmnet.R;
import com.example.calculatorchallengeassignmnet.service.serviceImpl.BasicCalculatorImpl;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicFragment extends Fragment {
    private static final String TAG = BasicFragment.class.getSimpleName();

    /**
     * holds result text view instance
     */
    TextView mResultView;
    /**
     * holds num1 edit view instance
     */
    EditText mNum1View;
    /**
     * holds num2 edit view instance
     */
    EditText mNum2View;
    /**
     * holds addition button view instance
     */
    Button mAddButtonView;
    /**
     * holds subtraction button view instance
     */
    Button mSubtractButtonView;
    /**
     * holds multiplication button view instance
     */
    Button mMultiplyButtonView;
    /**
     * holds division button view instance
     */
    Button mDivideButtonView;
    /**
     * Holds BasicCalculatorImpl instance
     */
    BasicCalculatorImpl mBasicCalculator;
    public BasicFragment() {
        // Required empty public constructor
        mBasicCalculator = new BasicCalculatorImpl();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "In fragment_basic ");
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        initComponent(view);
        return view;
    }

    /**
     * @param view
     */
    private void initComponent(View view) {
        if (view != null) {
            mResultView = (TextView) view.findViewById(R.id.output_text_view);
            mNum1View = (EditText) view.findViewById(R.id.num1_edit_text);
            mNum2View = (EditText) view.findViewById(R.id.num2_edit_text);
            mAddButtonView = (Button) view.findViewById(R.id.add_button);
            mSubtractButtonView = (Button) view.findViewById(R.id.sub_button);
            mMultiplyButtonView = (Button) view.findViewById(R.id.mul_button);
            mDivideButtonView = (Button) view.findViewById(R.id.div_button);
            mAddButtonView.setOnClickListener(listener);
            mSubtractButtonView.setOnClickListener(listener);
            mMultiplyButtonView.setOnClickListener(listener);
            mDivideButtonView.setOnClickListener(listener);

        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add_button:
                    calculateAddition();
                    break;
                case R.id.sub_button:
                    calculateSubtraction();
                    break;
                case R.id.mul_button:
                    calculateMultiplication();
                    break;
                case R.id.div_button:
                    calculatDivision();
                    break;
            }
        }
    };

    private void calculateSubtraction() {
        String num1 = mNum1View.getText().toString();
        String num2 = mNum2View.getText().toString();
        if (viewValidation(num1, num2)) {
            DecimalFormat format = new DecimalFormat("##.##");

            Double subtraction = mBasicCalculator.subtraction(Double.parseDouble(num1), Double.parseDouble(num2));
            mResultView.setText(format.format(subtraction));
        }

    }

    private void calculateAddition() {
        String num1 = mNum1View.getText().toString();
        String num2 = mNum2View.getText().toString();
        if (viewValidation(num1, num2)) {
            DecimalFormat format = new DecimalFormat("##.##");
            Double subtraction = mBasicCalculator.addition(Double.parseDouble(num1), Double.parseDouble(num2));
            mResultView.setText(format.format(subtraction));
        }
    }

    private void calculateMultiplication() {
        String num1 = mNum1View.getText().toString();
        String num2 = mNum2View.getText().toString();
        if (viewValidation(num1, num2)) {
            DecimalFormat format = new DecimalFormat("##.##");
            Double multiplyResult = mBasicCalculator.multiplication(Double.parseDouble(num1), Double.parseDouble(num2));
            mResultView.setText(format.format(multiplyResult));
        }
    }

    private void calculatDivision() {
        String num1 = mNum1View.getText().toString();
        String num2 = mNum2View.getText().toString();
        if (viewValidation(num1, num2)) {
            DecimalFormat format = new DecimalFormat("##.##");
            Double division = mBasicCalculator.division(Double.parseDouble(num1), Double.parseDouble(num2));
            mResultView.setText(format.format(division));
        }
    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    private boolean viewValidation(String num1, String num2) {
        if (TextUtils.isEmpty(num1)) {
            mNum1View.setError("Please Enter number 1");
            mNum1View.requestFocus();
            mResultView.setText("");
            return false;
        }
        if (TextUtils.isEmpty(num2)) {
            mNum2View.setError("Please Enter number 2");
            mNum2View.requestFocus();
            mResultView.setText("");
            return false;
        }
        return true;
    }
}
