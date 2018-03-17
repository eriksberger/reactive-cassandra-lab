package se.avega.lab.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;

@Table("people_by_first_name")
public class Person {

    @PrimaryKey
    private PersonKey key;

    @Column("last_name")
    private String lastName;

    @Column
    private double salary;

    public Person() {
    }

    public Person(PersonKey key, String lastName, int salary) {
        this.key = key;
        this.lastName = lastName;
        this.salary = salary;

    }

    public PersonKey getKey() {
        return key;
    }

    public void setKey(PersonKey key) {
        this.key = key;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "key=" + key +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.salary, salary) == 0 &&
                Objects.equals(key, person.key) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, lastName, salary);
    }
}
