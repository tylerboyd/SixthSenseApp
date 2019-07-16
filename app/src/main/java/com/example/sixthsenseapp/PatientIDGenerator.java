package com.example.sixthsenseapp;

import android.util.Log;

import java.util.Random;

public class PatientIDGenerator {

    Random rand = new Random();

    int charOneLower = 65;
    int charOneUpper = 90;

    int charTwoLower = 97;
    int charTwoUpper = 122;

    int IDno = rand.nextInt(999999999);
    int charOne = rand.nextInt((charOneUpper - charOneLower) + 1) + charOneLower;
    int charTwo = rand.nextInt((charTwoUpper - charTwoLower) + 1) + charTwoLower;

    char charOneLetter = (char)charOne;
    char charTwoLetter = (char)charTwo;

    String patID = String.valueOf(charOneLetter) + String.valueOf(charTwoLetter) + String.valueOf(IDno);

    String createPatID()
    {
        return patID;
    }

}
