package models;

import java.util.Objects;

import static java.util.Objects.hash;

public class Ranger {
    private String rangerName;
    private int id;
    private int radioTelephoneFrequency;
    private String avatarUrl;
    private int badgeNumber;

    public Ranger(String rangerName, int radioTelephoneFrequency, String avatarUrl, int badgeNumber) {
        this.rangerName = rangerName;
        this.radioTelephoneFrequency = radioTelephoneFrequency;
        this.avatarUrl = avatarUrl;
        this.badgeNumber = badgeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id && radioTelephoneFrequency == ranger.radioTelephoneFrequency && badgeNumber ==ranger.badgeNumber && Objects.equals(rangerName, ranger.rangerName) && Objects.equals(avatarUrl, ranger.avatarUrl);
    }

    @Override
    public int hashCode() {return hash(id,rangerName, radioTelephoneFrequency, avatarUrl);}

    public void setId(int id) {
        this.id = id;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId() {
        return id;
    }

    public int getRadioTelephoneFrequency() {
        return radioTelephoneFrequency;
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

    public void setRadioTelephoneFrequency(int radioTelephoneFrequency) {
        this.radioTelephoneFrequency = radioTelephoneFrequency;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
