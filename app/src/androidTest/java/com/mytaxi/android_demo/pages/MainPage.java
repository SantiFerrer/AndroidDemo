package com.mytaxi.android_demo.pages;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;

public class MainPage {
    private int textSearch = R.id.textSearch;
    private int drawer = R.id.drawer_layout;
    private int toolbar = R.id.toolbar;
    private int map = R.id.map;
    private ActivityTestRule<?> mActivityRule;

    public MainPage(ActivityTestRule<?> rule){
        mActivityRule = rule;
        getTextSearch().check(matches(notNullValue())).check(matches(isDisplayed()));
        getDrawer().check(matches(notNullValue())).check(matches(isDisplayed()));
        getToolbar().check(matches(notNullValue())).check(matches(isDisplayed()));
        getMap().check(matches(notNullValue())).check(matches(isDisplayed()));
    }

    private ViewInteraction getTextSearch () {
        return onView(withId(textSearch));
    }
    private ViewInteraction getDrawer () {
        return onView(withId(drawer));
    }
    private ViewInteraction getToolbar () {
        return onView(withId(toolbar));
    }
    private ViewInteraction getMap () {
        return onView(withId(map));
    }

    public MainPage setTextSearch (String text) {
        getTextSearch().perform(typeText(text));
        return this;
    }
    public DriverProfilePage selectFromDropdownMenu (String text) {
        onView(withText(text)).inRoot(RootMatchers.withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).perform(click());
        return new DriverProfilePage(mActivityRule);
    }
}
