package com.focalpoint.Focalist.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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
    boolean completed;

    @ManyToOne
    ApplicationUser applicationUser;

    public Task() {}

    public boolean isCompleted() {
        return completed;
    }

    public Task(String title, String note, Date UtcTime, Date localTime, ApplicationUser applicationUser) {
        this.title = title;
        this.note = note;
        this.utcTime = UtcTime;
        this.localTime = localTime;
        this.applicationUser = applicationUser;
        this.completed = false;

    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    @Override
    public String toString() {
        Instant instant = this.localTime.toInstant();
        String time = instant.atZone(ZoneOffset.UTC).toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"));
        return String.format("\n(%s) Title: %s \nNote: %s", time, this.title, this.note);
    }

    public String timeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm a");
        return simpleDateFormat.format(this.localTime);
    }
}
