package com.example.sixthsenseapp;

import org.junit.Before;
import org.junit.Test;

public class SetupBloodSugarTest
{
    SetupBloodSugar setupBloodSugar;


    @Before
    public void setUp() throws Exception
    {
        setupBloodSugar = new SetupBloodSugar();

    }

    @Test
    public void goingHigh() throws Exception
    {
        float testingLimit = SetupBloodSugar.getUpperLimit() + 1;
        for (int i = 0; i < testingLimit; i++)
        {
           //setupBloodSugar.setAddLowerLimit().performClick();
        }
    }

    /*@Test
    public void goingLow() throws Exception
    {

    }

    @Test
    public void goingLow() throws Exception
    {

    }*/

}