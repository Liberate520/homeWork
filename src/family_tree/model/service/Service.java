package family_tree.model.service;

import family_tree.model.gender.Gender;

import java.time.LocalDate;

public interface Service {

    public void add(String name,
                    LocalDate birthday,
                    LocalDate dayOfDeath,
                    Gender gender);

    public Object getPerson(String name);

    public void reviseDependencies();

    public void print();

    public void sortByName();

    public void sortByAge();

    public void saveTreeInFile();

    public void readTreeFromFile();


}
