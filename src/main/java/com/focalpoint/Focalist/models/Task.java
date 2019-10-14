package com.focalpoint.Focalist.models;

import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String note;
    Date time;
    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public Task(String title, String note, String time, String timeZone, ApplicationUser applicationUser) {
        this.title = title;
        this.note = note;
        this.time = new Date(time);
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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
}
