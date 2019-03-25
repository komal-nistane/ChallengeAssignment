package com.example.calculatorchallengeassignmnet;

import com.example.calculatorchallengeassignmnet.service.serviceImpl.ScientificCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ScientificCalculatorUnitTest {

    ScientificCalculatorImpl scientificCalculator ;

    @Before
    public void setup() throws Exception {
        scientificCalculator = new ScientificCalculatorImpl();
    }

    @Test
    public void lnIsPass() {
      assertEquals(Double.parseDouble("1.0791812460476249"), Double.parseDouble(scientificCalculator.calculateLogN(12)+""),0.0);
    }

    @Test
    public void logIsPass() {
        assertEquals(Double.parseDouble("2.4849066497880004"), Double.parseDouble(scientificCalculator.calculateLogE(12)+""),0.0);
    }
}