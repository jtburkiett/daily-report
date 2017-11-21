package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;


/**
 * Created by LaunchCode
 */

//Goals--
//Have Reports display on a calendar where each date
//contains a link to the reports for that day.
//
//Every user has their own calendar.
//
//Export reports to excel and/or email, either by day, range of days, month or year.


@Entity
public class Report {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    private String billGroup;

    private String timeIn;

    private String timeOut;

    private String assigned;

    private String completed;

    private String skipped;

    private int startMiles;

    private int endMiles;

    private int probes;

    private String probeFolder;

    private int reReads;

    private String comments;

    public Report(String name, String billGroup, String timeIn, String timeOut, String assigned, String completed, String skipped, int startMiles, int endMiles, int probes, String probeFolder, int reReads, String comments) {
        this.name = name;
        this.billGroup = billGroup;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.assigned = assigned;
        this.completed = completed;
        this.skipped = skipped;
        this.startMiles = startMiles;
        this.endMiles = endMiles;
        this.probes = probes;
        this.probeFolder = probeFolder;
        this.reReads = reReads;
        this.comments = comments;
    }

    public Report() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillGroup() {
        return billGroup;
    }

    public void setBillGroup(String billGroup) {
        this.billGroup = billGroup;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getSkipped() {
        return skipped;
    }

    public void setSkipped(String skipped) {
        this.skipped = skipped;
    }

    public int getStartMiles() {
        return startMiles;
    }

    public void setStartMiles(int startMiles) {
        this.startMiles = startMiles;
    }

    public int getEndMiles() {
        return endMiles;
    }

    public void setEndMiles(int endMiles) {
        this.endMiles = endMiles;
    }

    public int getProbes() {
        return probes;
    }

    public void setProbes(int probes) {
        this.probes = probes;
    }

    public String getProbeFolder() {
        return probeFolder;
    }

    public void setProbeFolder(String probeFolder) {
        this.probeFolder = probeFolder;
    }

    public int getReReads() {
        return reReads;
    }

    public void setReReads(int reReads) {
        this.reReads = reReads;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}





