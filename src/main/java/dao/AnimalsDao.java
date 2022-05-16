package dao;

import models.Animals;
import models.Location;

import java.util.List;

public interface AnimalsDao {


    List<Animals> getAllAnimals();

    List<Location> getAllLocation();

    void addAnimal(Animals animals);

    Animals getAnimalById(int id);

    void deleteAnimalById(int id);

    void deleteAllAnimals();


}
