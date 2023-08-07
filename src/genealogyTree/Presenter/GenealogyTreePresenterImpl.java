package Presenter;

import model.GenealogyTreeModel;
import model.Person;

import java.util.List;

import View.GenealogyTreeView;

public class GenealogyTreePresenterImpl implements GenealogyTreePresenter {
    private GenealogyTreeModel model;
    private GenealogyTreeView view;

    public GenealogyTreePresenterImpl(GenealogyTreeModel model) {
        this.model = model;
    }

    @Override
    public void attachView(GenealogyTreeView view) {
        this.view = view;
    }

    @Override
    public void addPerson(String parentName, String childName, int childAge) {
        // Реализация добавления персоны
        Person parent = new Person(parentName, 0); // Здесь вы можете указать возраст или получить его из пользовательского ввода
        Person child = new Person(childName, childAge);
        model.addPerson(parent, child);
    }

    @Override
    public void getChildren(String personName) {
        // Реализация получения детей
        Person person = new Person(personName, 0); // Здесь вы можете указать возраст или получить его из пользовательского ввода
        List<Person> children = model.getChildren(person);
        view.displayChildren(children);
    }

    @Override
    public void getAncestors(String personName) {
        // Реализация получения предков
        Person person = new Person(personName, 0); // Здесь вы можете указать возраст или получить его из пользовательского ввода
        List<Person> ancestors = model.getAncestors(person);
        view.displayAncestors(ancestors);
    }

    @Override
    public void sortChildrenByName(String personName) {
        // Реализация сортировки детей по имени
        Person person = new Person(personName, 0); // Здесь вы можете указать возраст или получить его из пользовательского ввода
        List<Person> sortedChildren = model.sortChildrenByName(person);
        view.displayChildren(sortedChildren);
    }

    @Override
    public void sortAncestorsByName(String personName) {
        // Реализация сортировки предков по имени
        Person person = new Person(personName, 0); // Здесь вы можете указать возраст или получить его из пользовательского ввода
        List<Person> sortedAncestors = model.sortAncestorsByName(person);
        view.displayAncestors(sortedAncestors);
    }
}
