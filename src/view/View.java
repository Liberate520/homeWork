package view;

import model.Person;

public interface View {
    void printAnswer(String text);
    void start();
    void printPerson(Person person);
}
