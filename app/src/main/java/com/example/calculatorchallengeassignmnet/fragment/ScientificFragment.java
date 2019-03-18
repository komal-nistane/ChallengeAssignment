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
import com.example.calculatorchallengeassignmnet.service.serviceImpl.ScientificCalculatorImpl;

import java.text.DecimalFormat;

public class ScientificFragment extends Fragment {

    private static final String TAG = ScientificFragment.class.getSimpleName();
    /**
     * holds result text view instance
     */
    TextView mResultView;
    /**
     * holds num1 edit view instance
     */
    EditText mNum1View;

    /**
     * holds log Base N button view instance
     */
    Button mLogBaseNButtonView;
    /**
     * holds log Base E button view instance
     */
    Button mLogBaseEButtonView;

    /**
     * Holds ScientificCalculatorImpl instance
     */
    ScientificCalculatorImpl mScientificCalculator ;
    public ScientificFragment() {
        // Required empty public constructor
        mScientificCalculator = new ScientificCalculatorImpl();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG , "In ScientificFragment ");
        View view = inflater.inflate(R.layout.fragment_scientific, container, false);
        initComponent(view);

        return view;
    }

    /**
     * @param view
     */
    private void initComponent(View view) {
        if (view != null) {
            mResultView = (TextView) view.findViewById(R.id.log_output_text_view);
            mNum1View = (EditText) view.findViewById(R.id.num_edit_text);
            mLogBaseEButtonView = (Button) view.findViewById(R.id.log_button);
            mLogBaseNButtonView = (Button) view.findViewById(R.id.logn_button);
            mLogBaseEButtonView.setOnClickListener(listener);
            mLogBaseNButtonView.setOnClickListener(listener);
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.log_button:
                    calculateLogBaseE();
                    break;
                case R.id.logn_button:
                    calculateLogBaseN();
                    break;

            }
        }
    };

    private void calculateLogBaseE() {
        String num1 = mNum1View.getText().toString();
        if (viewValidation(num1)) {
            DecimalFormat format = new DecimalFormat("##.##");
            Double logRes = mScientificCalculator.calculateLogE(Double.parseDouble(num1));
            mResultView.setText(format.format(logRes));
        }

    }

    private void calculateLogBaseN() {
        String num1 = mNum1View.getText().toString();
        if (viewValidation(num1)) {
            DecimalFormat format = new DecimalFormat("##.##");
            Double logBaseToN = mScientificCalculator.calculateLogN(Double.parseDouble(num1));
            mResultView.setText(format.format(logBaseToN));
        }
    }

    /**
     * @param num1
     * @return
     */
    private boolean viewValidation(String num1) {
        if (TextUtils.isEmpty(num1)) {
            mNum1View.setError("Please Enter number ");
            mNum1View.requestFocus();
            return false;
        }
        return true;
    }
}
