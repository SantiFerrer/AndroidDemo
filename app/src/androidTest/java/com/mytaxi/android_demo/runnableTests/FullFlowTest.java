package com.mytaxi.android_demo.runnableTests;

import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.TemplateTest;
import com.mytaxi.android_demo.pages.AuthenticationPage;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class FullFlowTest extends TemplateTest {

    @Test
    public void testFullFlow() {
        AuthenticationPage authenticationPage = new AuthenticationPage(mActivityRule);

        authenticationPage
                .setTextUsername("crazydog335")
                .setTextPassword("venture")
                .pressLoginButton()
                .setTextSearch("sa")
                .selectFromDropdownMenu("Sarah Scott")
                .verifyDriverProfile("Sarah Scott")
                .pressCallButton()
                .verifyDialNumber("413-868-2228")
        ;
    }
}
