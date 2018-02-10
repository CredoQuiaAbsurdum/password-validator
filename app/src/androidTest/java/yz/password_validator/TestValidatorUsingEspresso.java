package yz.password_validator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;


public class TestValidatorUsingEspresso {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //Test Weak passwords: Strength = 1 to 2

    @Test //Strength = 1
    public void case1(){
        onView(withId(R.id.editText)).perform(typeText("1234"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Weak")));
    }


    @Test //Strength = 2
    public void case2(){
        onView(withId(R.id.editText)).perform(typeText("password"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Weak")));
    }


    //Test Strong passwords: Strength = 3 to 4
    @Test //Strength = 3
    public void case3(){
        onView(withId(R.id.editText)).perform(typeText("Asdf#"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Strong")));
    }

    @Test
    public void case4(){
        onView(withId(R.id.editText)).perform(typeText("Asdf#23"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Strong")));
    }

    //Test Very Strong passwords: Strength = 5
    @Test //Strength = 5
    public void case5(){
        onView(withId(R.id.editText)).perform(typeText("edaEc#1233"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Very Strong")));
    }
}