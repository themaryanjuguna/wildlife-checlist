package models;

public class Animals {

    public int id;
    public String name;
    public int age;
    public String behaviour;
    public String health;
    public String classification;

    public Animals(String name, int age, String behaviour, String health, String classification) {
        this.name = name;
        this.age = age;
        this.behaviour = behaviour;
        this.health = health;
        this.classification = classification;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public String getHealth() {
        return health;
    }

    public String getClassification() {
        return classification;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
