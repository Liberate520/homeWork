package View;

import model.Person;

import java.util.List;

public interface GenealogyTreeView {
    void displayMessage(String message);

    void displayChildren(List<Person> children);

    void displayAncestors(List<Person> ancestors);
}
