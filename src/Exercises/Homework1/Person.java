package Exercises.Homework1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public Person(String name, LocalDate dateBirth) {
        this._name = name;
        this._dateBirth = dateBirth;
        this._parrents = new ArrayList<>();
        this._children = new ArrayList<>();
    }

    private String _name;
    private LocalDate _dateBirth;
    private List<Person> _parrents;
    private List<Person> _children;

    public String GetName() {
        return _name;
    }

    public LocalDate GetDateBirth() {
        return _dateBirth;
    }

    public List<Person> GetChildren() {
        return _children;
    }

    public void AddChild(Person child) {
        _children.add(child);
        child.AddParrent(this);
    }

    public List<Person> GetParrents() {
        return _parrents;
    }

    public void AddParrent(Person child) {
        _parrents.add(child);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            var another = (Person) obj;
            return this._name == another._name &&
                    this._dateBirth == another._dateBirth &&
                    this._parrents.equals(another._parrents) &&
                    this._children.equals(another._children);
        }
        return false;
    }

    @Override
    public String toString() {
        return _name + ", дата рождения: " + _dateBirth;
    }
}
