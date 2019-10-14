package com.focalpoint.Focalist.models;

import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String note;
    OffsetDateTime time;
    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public Task(String title, String note, OffsetDateTime time, ApplicationUser applicationUser) {
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

    public OffsetDateTime getTime() {
        return time;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
}
