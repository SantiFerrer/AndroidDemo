package com.mytaxi.android_demo.pages;

import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

public class DriverProfilePage {
    private int textViewDriverName = R.id.textViewDriverName;
    private int imageViewAvatar = R.id.imageViewDriverAvatar;
    private int textViewLocation = R.id.textViewDriverLocation;
    private int textViewDate = R.id.textViewDriverDate;
    private int buttonCall = R.id.fab;
    private ActivityTestRule<?> mActivityRule;

    public DriverProfilePage(ActivityTestRule<?> rule){
        mActivityRule = rule;
        getTextViewDriverName().check(matches(notNullValue())).check(matches(isDisplayed()));
        getImageViewAvatar().check(matches(notNullValue())).check(matches(isDisplayed()));
        getTextViewLocation().check(matches(notNullValue())).check(matches(isDisplayed()));
        getTextViewDate().check(matches(notNullValue())).check(matches(isDisplayed()));
        getButtonCall().check(matches(notNullValue())).check(matches(isDisplayed()));
    }

    private ViewInteraction getTextViewDriverName () {
        return onView(withId(textViewDriverName));
    }
    private ViewInteraction getImageViewAvatar () {
        return onView(withId(imageViewAvatar));
    }
    private ViewInteraction getTextViewLocation () {
        return onView(withId(textViewLocation));
    }
    private ViewInteraction getTextViewDate () {
        return onView(withId(textViewDate));
    }
    private ViewInteraction getButtonCall() {
        return onView(withId(buttonCall));
    }

    public DriverProfilePage verifyDriverProfile (String text) {
        getTextViewDriverName().check(matches(withText(text)));
        return this;
    }
    public DriverProfilePage pressCallButton () {
        getButtonCall().perform(click());
        return this;
    }
    public DriverProfilePage verifyDialNumber (String phoneNum) {
        intended(allOf(hasAction(Intent.ACTION_DIAL),hasData(Uri.parse("tel:" + phoneNum))));
        return this;
    }
}
