package dao;

import models.NormalAnimal;

import java.util.List;

public interface NormalAnimalDao {

    List<NormalAnimal> getAllNormalAnimal();
    NormalAnimal getAnimalById(int id);

    void addNormalAnimal(NormalAnimal normalAnimal);

    void deleteNormalAnimalById(int id);

    void deleteAllNormalAnimal();

}
