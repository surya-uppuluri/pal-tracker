package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TimeEntry {


    private long timeEntryId;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {
    }


    public long getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "timeEntryId=" + timeEntryId +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        if (getTimeEntryId() != timeEntry.getTimeEntryId()) return false;
        if (getProjectId() != timeEntry.getProjectId()) return false;
        if (getUserId() != timeEntry.getUserId()) return false;
        if (getHours() != timeEntry.getHours()) return false;
        if (!getDate().equals(timeEntry.getDate())) return false;
        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (getTimeEntryId() ^ (getTimeEntryId() >>> 32));
        result = 31 * result + (int) (getProjectId() ^ (getProjectId() >>> 32));
        result = 31 * result + (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getHours();
        return result;
    }

    public Long getId() {
        return this.timeEntryId;
    }
}
