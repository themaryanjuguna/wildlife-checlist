package models;

public class Animals {

    public int id;
    public String name;
    public String age;
    public String behaviour;
    public String health;
    public String risk;

    public Animals(String name, String age, String behaviour, String health, String risk) {
        this.name = name;
        this.age = age;
        this.behaviour = behaviour;
        this.health = health;
        this.risk = risk;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public String getHealth() {
        return health;
    }

    public String getRisk() {
        return risk;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}
