package dao;

import models.Animals;
import models.Location;

import java.util.List;

public interface AnimalsDao {


    List<Animals> getAllAnimals();

    List<Location> getAllLocation();

    void addAnimal(Animals animals);

    Animals findAnimalByName(String name);

    Animals findAnimalByRisk(String risk);

    Animals findAnimalByHealth(String health);

    Animals findAnimalByAge(int age);

    void deleteAnimalById(int id);

    void deleteAllAnimals();


}
