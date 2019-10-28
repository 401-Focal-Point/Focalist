package com.focalpoint.Focalist.models;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

// some testing inspired from:
// https://stackoverflow.com/questions/21354311/junit-test-of-setters-and-getters-of-instance-variables

public class ApplicationUserTest {

    // test getFirstName()
    @Test
    public void getFirstName() throws IllegalAccessException, NoSuchFieldException {
        final ApplicationUser testUser = new ApplicationUser();
        final Field field = testUser.getClass().getDeclaredField("firstName");
        // Interesting... for this all I needed you to do was call the setter and getter on firstName,
        // or to pass a firstName into the constructor and assert that it was saved successfully!
        // This stuff with Field is cool, but not the most useful sort of test.
        field.setAccessible(true);
        field.set(testUser, "Peter Piper");

        final String result = testUser.getFirstName();

        assertEquals("field wasn't retrieved properly", result, "Peter Piper");
    }

    // test getPhoneNumber()
    @Test
    public void getPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        final ApplicationUser testUser = new ApplicationUser();
        final Field field = testUser.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(testUser, "4258889999");

        final String result = testUser.getPhoneNumber();

        assertEquals("field wasn't retrieved properly", result, "4258889999");
    }


    // missing some tests here, as well as tests on the Twilio configuration.
//    @Test
//    public void getTasks() {
//
//    }
}