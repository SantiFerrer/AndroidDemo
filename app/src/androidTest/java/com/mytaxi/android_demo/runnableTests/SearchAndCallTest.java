package com.mytaxi.android_demo.runnableTests;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.TemplateTest;
import com.mytaxi.android_demo.pages.MainPage;
import com.mytaxi.android_demo.models.User;
import com.mytaxi.android_demo.utils.IdlingResources;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.InstrumentationRegistry.getInstrumentation;


@RunWith(AndroidJUnit4.class)
public class SearchAndCallTest extends TemplateTest {

    @Before
    //Setup override to have a user logged in instead of reset
    public void setUp() {
        //Have the user already logged in
        SharedPrefStorage sharedPrefStorage = new SharedPrefStorage(getInstrumentation().getTargetContext());
        String user = "crazydog335";
        String salt = "wp3zuBv7";
        String sha256 = "9726ae7ce314e547ac606efc5afb1070439097903333de7c5050753d5435d72f";
        sharedPrefStorage.saveUser(new User(user,salt,sha256));
        //Idling Resources - Register
        IdlingRegistry.getInstance().register(IdlingResources.countingIdlingResource);
        //Launch the activity
        mActivityRule.launchActivity(null);
    }

    @Test
    public void testSearchAndCall() {
        MainPage mainPage = new MainPage(mActivityRule);

        mainPage
                .setTextSearch("sa")
                .selectFromDropdownMenu("Sarah Scott")
                .verifyDriverProfile("Sarah Scott")
                .pressCallButton()
                .verifyDialNumber("413-868-2228")
        ;
    }
}
