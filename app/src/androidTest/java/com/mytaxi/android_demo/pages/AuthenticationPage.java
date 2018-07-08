package com.mytaxi.android_demo.pages;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;

public class AuthenticationPage {
    private int textUsername = R.id.edt_username;
    private int textPassword = R.id.edt_password;
    private int buttonLogin = R.id.btn_login;
    private ActivityTestRule<?> mActivityRule;

    public AuthenticationPage(ActivityTestRule<?> rule){
        mActivityRule = rule;
        getTextUsername().check(matches(notNullValue())).check(matches(isDisplayed()));
        getTextPassword().check(matches(notNullValue())).check(matches(isDisplayed()));
        getButtonLogin().check(matches(notNullValue())).check(matches(isDisplayed()));
    }

    private ViewInteraction getTextUsername () {
        return onView(withId(textUsername));
    }
    private ViewInteraction getTextPassword () {
        return onView(withId(textPassword));
    }
    private ViewInteraction getButtonLogin () {
        return onView(withId(buttonLogin));
    }

    public AuthenticationPage setTextUsername (String text) {
        getTextUsername().perform(typeText(text));
        return this;
    }
    public AuthenticationPage setTextPassword (String text) {
        getTextPassword().perform(typeText(text));
        return this;
    }
    public MainPage pressLoginButton () {
        getButtonLogin().perform(click());
        return new MainPage(mActivityRule);
    }
}
