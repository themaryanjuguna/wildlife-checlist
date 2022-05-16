package models;

import java.util.Objects;

public class NormalAnimal {
    public int id;
    public String name;
    public String risk;

    public NormalAnimal(String name, String type) {
        this.name = name;
        this.risk = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return risk;
    }

    public void setType(String type) {
        this.risk = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalAnimal that = (NormalAnimal) o;
        return id == that.id && name.equals(that.name) && risk.equals(that.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, risk);
    }
}
