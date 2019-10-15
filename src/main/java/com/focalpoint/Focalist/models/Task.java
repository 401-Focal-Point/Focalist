package com.focalpoint.Focalist.models;

import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.util.Date;
import java.time.OffsetDateTime;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String note;
//    OffsetDateTime time;
    Date time;
    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public Task(String title, String note, Date time, ApplicationUser applicationUser) {
        this.title = title;
        this.note = note;
        this.time = time;
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
