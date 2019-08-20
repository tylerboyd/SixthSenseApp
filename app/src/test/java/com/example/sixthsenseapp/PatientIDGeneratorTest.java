package com.example.sixthsenseapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PatientIDGeneratorTest
{
    PatientIDGenerator patientIDGenerator;


    @Before
    public void setUp() throws Exception
    {
        patientIDGenerator = new PatientIDGenerator();

    }

    @After
    public void tearDown() throws Exception
    {
        patientIDGenerator = null;
    }
    @Test
    public void isInRange()
    {
        int idNumber = patientIDGenerator.IDno + patientIDGenerator.charOne + patientIDGenerator.charTwo;
        assertTrue(idNumber >= 1 && idNumber <= 999999999);

    }

    @Test
    public void isUnique()
    {
        int n = 1000000000;
        for (int i = 0; i < n; i++)
        {
            int idNumber = patientIDGenerator.IDno + patientIDGenerator.charOne + patientIDGenerator.charTwo;
            assertTrue(n != idNumber);
        }
    }

}