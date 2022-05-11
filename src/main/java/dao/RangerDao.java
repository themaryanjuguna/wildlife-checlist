package dao;

import models.Ranger;

import java.util.List;

public interface RangerDao {

    List<Ranger> getAllRangers();

    void addRanger(Ranger ranger);

    Ranger findRangerById(int id);

    Ranger findRangerByBadgeNumber(int badgeNumber);

    void deleteRangerById(int id);

    void deleteAllRangers();
}
