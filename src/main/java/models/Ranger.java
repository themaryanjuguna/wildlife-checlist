package models;

import java.util.Objects;

import static java.lang.Object.*;
import static java.util.Objects.hash;

public class Ranger {
    private String rangerName;
    private int id;
    private int radioFrequency;
    private String avatarUrl;
    private int badgeNumber;

    public Ranger(String rangerName, int radioFrequency, String avatarUrl, int badgeNumber) {
        this.rangerName = rangerName;
        this.radioFrequency = radioFrequency;
        this.avatarUrl = avatarUrl;
        this.badgeNumber = badgeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id && radioFrequency == ranger.radioFrequency && badgeNumber ==ranger.badgeNumber && Objects.equals(rangerName, ranger.rangerName) && Objects.equals(avatarUrl, ranger.avatarUrl);
    }

    @Override
    public int hashCode() {return hash(id,rangerName, radioFrequency, avatarUrl);}

    public void setId(int id) {
        this.id = id;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId() {
        return id;
    }

    public int getRadioFrequency() {
        return radioFrequency;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setRadioFrequency(int radioFrequency) {
        this.radioFrequency = radioFrequency;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
