package com.example.calculatorchallengeassignmnet.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.calculatorchallengeassignmnet.fragment.BasicFragment;
import com.example.calculatorchallengeassignmnet.fragment.ScientificFragment;

public class CalculatorPagerAdapter extends FragmentStatePagerAdapter {

    /**
     * Holds no of tabs present in the application
     */
    private int mNoOfTabs;

    /**
     *
     * @param fm
     * @param mNoOfTabs
     */
    public CalculatorPagerAdapter(FragmentManager fm, int mNoOfTabs) {
        super(fm);
        this.mNoOfTabs = mNoOfTabs;
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BasicFragment basicFragment = new BasicFragment();
                return  basicFragment ;
            case 1:
                ScientificFragment scientificFragment = new ScientificFragment();
                return  scientificFragment;

            default:
                return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
