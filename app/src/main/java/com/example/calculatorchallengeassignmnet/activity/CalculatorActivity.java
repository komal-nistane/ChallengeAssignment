package com.example.calculatorchallengeassignmnet.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.calculatorchallengeassignmnet.R;
import com.example.calculatorchallengeassignmnet.adapter.CalculatorPagerAdapter;
import com.example.calculatorchallengeassignmnet.fragment.BasicFragment;
import com.example.calculatorchallengeassignmnet.fragment.ScientificFragment;

public class CalculatorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = CalculatorActivity.class.getSimpleName();
    /**
     * Holds tab layout view instance
     */
    TabLayout mTabLayoutView;
    /**
     * Holds view pager view instance
     */
    ViewPager mViewPager;
    /**
     * Holds red color button view instance
     */
    ImageButton mRedButton;
    /**
     * Holds green color button view instance
     */
    ImageButton mGreenButton;
    /**
     * Holds cyan color button view instance
     */
    ImageButton mCyanButton;
    /**
     * Holds fragment transaction instance
     */
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initNavigationButton(navigationView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setTabLayout();
        setViewPager();
    }

    private void setViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager_calculator);
        CalculatorPagerAdapter pagerAdapter = new CalculatorPagerAdapter(getSupportFragmentManager(), mTabLayoutView.getTabCount());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayoutView));
        mTabLayoutView.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setTabLayout() {
        mTabLayoutView = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayoutView.addTab(mTabLayoutView.newTab().setText(getResources().getString(R.string.basic)));
        mTabLayoutView.addTab(mTabLayoutView.newTab().setText(getResources().getString(R.string.sci)));
        mTabLayoutView.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void initNavigationButton(NavigationView navigationView) {
        mRedButton = navigationView.findViewById(R.id.button_red);
        mGreenButton = navigationView.findViewById(R.id.button_green);
        mCyanButton = navigationView.findViewById(R.id.button_cyan);

        mRedButton.setOnClickListener(listener);
        mGreenButton.setOnClickListener(listener);
        mCyanButton.setOnClickListener(listener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        Log.i(TAG, "In basic Calculator tab" + item.getItemId());
        switch (item.getItemId()) {
            case R.id.nav_basic_calculator:
                Log.i(TAG, "In basic Calculator tab");
                mTabLayoutView.getTabAt(0).select();
                mFragmentTransaction.replace(R.id.home_screen, new BasicFragment(), "basicFragement");
                mFragmentTransaction.commit();
                break;
            case R.id.nav_scientific_calculator:
                Log.i(TAG, "In scientific_calculator tab");
                mTabLayoutView.getTabAt(1).select();
                mFragmentTransaction.replace(R.id.home_screen, new ScientificFragment(), "scientificFragement");
                mFragmentTransaction.commit();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment page = getSupportFragmentManager().findFragmentById(R.id.view_pager_calculator);
           RelativeLayout mRelativeBackgroundBasic = page.getActivity().findViewById(R.id.basic_calculator_background);
           RelativeLayout mRelativeBackgroundSci = page.getActivity().findViewById(R.id.scientific_calculator_background);
           Log.i("page object ::" , String.valueOf(page));
            if (page != null) {
                switch (view.getId()) {
                    case R.id.button_cyan:

                        mRelativeBackgroundBasic.setBackgroundColor(Color.CYAN);
                        mRelativeBackgroundSci.setBackgroundColor(Color.CYAN);
                        break;
                    case R.id.button_green:
                        mRelativeBackgroundBasic.setBackgroundColor(Color.GREEN);
                        mRelativeBackgroundSci.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.button_red:
                        mRelativeBackgroundBasic.setBackgroundColor(Color.RED);
                        mRelativeBackgroundSci.setBackgroundColor(Color.RED);
                        break;
                }
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    };
}
