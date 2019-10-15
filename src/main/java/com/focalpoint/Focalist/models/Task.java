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
    Date utcTime;
    Date localTime;
//    int offsetHours;
    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public Task(String title, String note, Date UtcTime, Date localTime, ApplicationUser applicationUser) {
        this.title = title;
        this.note = note;
        this.utcTime = UtcTime;
        this.localTime = localTime;
//        this.offsetHours = offsetHours;
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

    public Date getUtcTime() {
        return utcTime;
    }

    public Date getLocalTime() {
        return this.localTime;
    }

//    public int getOffset() {
//        return this.offsetHours;
//    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    @Override
    public String toString() {
        Instant instant = this.localTime.toInstant();
        String time = instant.atZone(ZoneOffset.UTC).toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"));
        return String.format("(%s) %s", time, this.title);
    }
}
