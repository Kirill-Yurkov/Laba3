package Locations;

import TextObjects.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractLocation {
    private String name;
    private ArrayList<Person> people = new ArrayList<>();
    public AbstractLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void interactInside(Person person);
    public void enterLocation(Person person) {
        addPeople(person);
        person.setLocation(this);
        System.out.println(person.getName() + " enters " + getName() + ".");
    }

    public Person[] getPeople() {
        Person[] people = new Person[this.people.size()];
        return this.people.toArray(people);
    }

    public void removePeople(Person... people) {
        for (Person person : people) {
            this.people.remove(person);
        }
    }
    public void addPeople(Person... people) {
        this.people.addAll(Arrays.asList(people));
    }
    public void exitLocation(Person person) {
        removePeople(person);
        person.setLocation(null);
        System.out.println(person.getName() + " exits " + getName() + ".");
    }


    @Override
    public String toString() {
        return "AbstractLocation{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLocation that = (AbstractLocation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = 31 * name.hashCode();
        return total;
    }
}