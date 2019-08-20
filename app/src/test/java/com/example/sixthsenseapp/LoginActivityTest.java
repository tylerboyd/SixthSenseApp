package com.example.sixthsenseapp;


import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest
{
    private static final String SUCCESSFUL = "Successfully Logged in.";


    @Mock
    Context context;

    //Context context = mock(Context.class);

    @Test
    public void readStringFromContext_LocalizedString()
    {
        LoginActivity loginActivity = new LoginActivity(context);
        String result = loginActivity.validateData("testemail@test.com","12345678");
        assertThat(result, is(SUCCESSFUL));
    }

}