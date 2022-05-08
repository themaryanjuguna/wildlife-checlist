package dao;

import models.Animals;
import models.Location;

import java.util.List;

public interface AnimalsDao {

    List<Animals> getAllAnimals();

    List<Location> getAllLocation();

    void addAnimal(Animals animals);

    void findAnimalByName(String name);

    void findAnimalByRisk(String risk);

    void findAnimalByHealth(String health);

    void findAnimalByAge(int age);

    void deleteAnimalById(int id);

    void deleteAllAnimals();


}
