package com.focalpoint.Focalist.models;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class TaskTest {

    Task newTask;
    Date currentUTCTime;
    Date currentLocalTime;
    ApplicationUser currentUser;
    @Before
    public void setUp() throws Exception {
        currentUTCTime = new DateTime().toDateTime(DateTimeZone.UTC).toDate();
        currentLocalTime = DateTime.now().toDate();
        currentUser = new ApplicationUser("firstname", "lastname", "1234567890", "password", "someone@gmail.com");
        newTask = new Task("test", "testing unit test", currentUTCTime, currentLocalTime, currentUser);
    }

    // test if we can set completed from false (default) to true
    @Test
    public void isCompleted() {
        newTask.setCompleted(true);
        assertTrue(newTask.completed);
    }

    // test if we can get the id of the task (if not saved in database, id is 0 by default)
    @Test
    public void getId() {
        assertEquals(0, newTask.getId());
    }

    @Test
    public void getTitle() {
        assertEquals("test", newTask.getTitle());
    }

    @Test
    public void getNote() {
        assertEquals("testing unit test", newTask.getNote());
    }

    @Test
    public void getUtcTime() {
        assertEquals(currentUTCTime, newTask.getUtcTime());
    }

    @Test
    public void getLocalTime() {
        assertEquals(currentLocalTime, newTask.getLocalTime());
    }

    @Test
    public void getApplicationUser() {
        assertEquals(currentUser, newTask.getApplicationUser());
    }

    @Test
    public void timeFormat() {
        String testTimeFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm a").format(currentLocalTime);
        assertEquals(testTimeFormat, newTask.timeFormat());
    }
}