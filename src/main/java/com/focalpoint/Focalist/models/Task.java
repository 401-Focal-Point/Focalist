package com.focalpoint.Focalist.models;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String note;
    Date time;
    int offsetHours;
    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public Task(String title, String note, Date time, int offsetHours, ApplicationUser applicationUser) {
        this.title = title;
        this.note = note;
        this.time = time;
        this.offsetHours = offsetHours;
        this.applicationUser = applicationUser;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public Date getTime() {
        return time;
    }

    public int getOffset() {
        return this.offsetHours;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    @Override
    public String toString() {
        int seconds = this.offsetHours * 60 * 60;
        Instant instant = this.time.toInstant().minusSeconds(seconds);
        String time = instant.atZone(ZoneOffset.UTC).toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"));
        return String.format("(%s) %s", time, this.title);
    }
}
