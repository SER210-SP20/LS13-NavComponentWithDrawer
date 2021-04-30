package edu.quinnipiac.ser210.navigationcompexample;

import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Test
    public void navigationTest() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        //Click on the add ingredient image
        onView(withId(R.id.send_money_btn)).perform(click());

        //Check that the fragment being displayed is chooseRecipient
      // onView(withText(R.id.input_recipient)).check(matches(isDisplayed()));

        //input Tom in recipient name
        String recipient = "Tom";
        onView(withId(R.id.input_recipient)).perform(typeText(recipient), closeSoftKeyboard());

        //hit next
        onView(withId(R.id.next_btn)).perform(click());

        //check that the specifyAmountFragment is displayed
      //  onView(withId(R.id.specifyAmountFragment)).check(matches(isDisplayed()));

        //input amount
        String money = "100.0";
        onView(withId(R.id.input_amount)).perform(typeText(money), closeSoftKeyboard());

        //hit the send button
        onView(withId(R.id.send_btn)).perform(click());

        //check that the confirmationFragment is displayed
        //onView(withId(R.id.confirmationFragment)).check(matches(isDisplayed()));


        String expected = "You sent " + money + " to " + recipient;;
        onView(withId(R.id.confirmation_message)).check(matches(withText(expected)));



    }

}