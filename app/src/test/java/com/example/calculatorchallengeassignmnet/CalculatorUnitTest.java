package com.example.calculatorchallengeassignmnet;

import android.util.Log;

import com.example.calculatorchallengeassignmnet.service.serviceImpl.BasicCalculatorImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class CalculatorUnitTest {

    private static final double DELTA = 1e-15;

    BasicCalculatorImpl basicCalculator = new BasicCalculatorImpl();

    @Test
    public void additionIsPass() {

        Assert.assertEquals(Double.doubleToLongBits(12), Double.doubleToLongBits(basicCalculator.addition(10,2)));
    }
    @Test
    public void subtractIsPass() {

        Assert.assertEquals(Double.doubleToLongBits(8), Double.doubleToLongBits(basicCalculator.subtraction(10,2)));
    }
    @Test
    public void multiplyIsPass() {

        Assert.assertEquals(Double.doubleToLongBits(20), Double.doubleToLongBits(basicCalculator.multiplication(10,2)));
    }
    @Test
    public void divisionIsPass() {

        Assert.assertEquals(Double.doubleToLongBits(5), Double.doubleToLongBits(basicCalculator.division(10,2)));
    }
    /*@Test
    public void logNIsPass() {
        NaturalLog naturalLog = new NaturalLog();

        Assert.assertEquals(Double.doubleToLongBits(2.48), Double.doubleToLongBits(naturalLog.calculateLog(12)));
    }
    @Test
    public void lnIsPass() {
        LogBaseE logBaseE = new LogBaseE();

        Assert.assertEquals(Double.doubleToLongBits(1.08), Double.doubleToLongBits(logBaseE.calculateLog(12)));
    }*/
}