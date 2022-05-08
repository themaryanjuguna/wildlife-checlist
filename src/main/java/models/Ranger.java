package models;

import jdk.jfr.Timestamp;

public class Ranger {
    private String rangerName;
    private int rangerId;
    private int radioFrequency;
    private String avatarUrl;

    public Ranger(String rangerName, int radioFrequency, String avatarUrl) {
        this.rangerName = rangerName;
        this.radioFrequency = radioFrequency;
        this.avatarUrl = avatarUrl;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getRangerId() {
        return rangerId;
    }

    public int getRadioFrequency() {
        return radioFrequency;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    public void setRadioFrequency(int radioFrequency) {
        this.radioFrequency = radioFrequency;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
