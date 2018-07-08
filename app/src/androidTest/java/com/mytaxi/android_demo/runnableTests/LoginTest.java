package com.mytaxi.android_demo.runnableTests;

import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.TemplateTest;
import com.mytaxi.android_demo.pages.AuthenticationPage;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginTest extends TemplateTest {

    @Test
    public void testLogin() {
        AuthenticationPage authenticationPage = new AuthenticationPage(mActivityRule);

        authenticationPage
                .setTextUsername("crazydog335")
                .setTextPassword("venture")
                .pressLoginButton()
        ;
    }
}
