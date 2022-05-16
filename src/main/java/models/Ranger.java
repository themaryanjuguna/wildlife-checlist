package models;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.hash;

public class Ranger {
    private String rangerName;
    private int id;
    private String radioTelephoneFrequency;
    private int badgeNumber;

    public Ranger(String rangerName, String radioTelephoneFrequency, int badgeNumber) {
        this.rangerName = rangerName;
        this.radioTelephoneFrequency = radioTelephoneFrequency;
        this.badgeNumber = badgeNumber;
    }

      @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id && radioTelephoneFrequency.equals(ranger.radioTelephoneFrequency) && badgeNumber ==ranger.badgeNumber && Objects.equals(rangerName, ranger.rangerName);
    }

    @Override
    public int hashCode() {return hash(id,rangerName, radioTelephoneFrequency);}

    public void setId(int id) {
        this.id = id;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId() {
        return id;
    }

    public String getRadioTelephoneFrequency() {
        return radioTelephoneFrequency;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }


    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setRadioTelephoneFrequency(String radioTelephoneFrequency) {
        this.radioTelephoneFrequency = radioTelephoneFrequency;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

}
