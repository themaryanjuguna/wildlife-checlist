package models;

import java.util.Objects;

import static java.lang.Object.*;
import static java.util.Objects.hash;

public class Ranger {
    private String rangerName;
    private int id;
    private int radioFrequency;
    private String avatarUrl;

    public Ranger(String rangerName, int radioFrequency, String avatarUrl) {
        this.rangerName = rangerName;
        this.radioFrequency = radioFrequency;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id && radioFrequency == ranger.radioFrequency && Objects.equals(rangerName, ranger.rangerName) && Objects.equals(avatarUrl, ranger.avatarUrl);
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setRadioFrequency(int radioFrequency) {
        this.radioFrequency = radioFrequency;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
