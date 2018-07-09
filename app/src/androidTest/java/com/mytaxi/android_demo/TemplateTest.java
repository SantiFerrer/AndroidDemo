package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.utils.IdlingResources;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TemplateTest {

    @Rule
    public IntentsTestRule<?> mActivityRule = new IntentsTestRule<>(MainActivity.class,true,false);

    @Rule
    //Location permissions already granted when launching the app
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Before
    public void setUp() {
        //Reset the user before starting a new test
        SharedPrefStorage sharedPrefStorage = new SharedPrefStorage(getInstrumentation().getTargetContext());
        sharedPrefStorage.resetUser();
        //Idling Resources - Register
        IdlingRegistry.getInstance().register(IdlingResources.countingIdlingResource);
        //Launch the activity
        mActivityRule.launchActivity(null);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());
    }

    @After
    public void tearDown() {
        //Finish the activity
        mActivityRule.finishActivity();
        //Idling Resources - Unregister
        IdlingRegistry.getInstance().unregister(IdlingResources.countingIdlingResource);
    }
}
