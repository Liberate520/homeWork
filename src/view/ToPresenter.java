package view;


import presenter.Presenter;

public class ToPresenter {

    private final Presenter presenter = new Presenter();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        switch (userSelect) {
            case "1" ->
                // посмотреть всех в консоли
                    presenter.PrintAllPerson();
            case "2" -> {
                // Добавить человека
                String name = input.inputKey(TextsMenu.Name);
                int age = Integer.parseInt(input.inputKey(TextsMenu.Age));
                presenter.addPerson(name, age);
            }
            case "3" -> {
                // удалить человека по id
                int id = Integer.parseInt(input.inputKey(TextsMenu.Id));
                presenter.removePerson(id);
            }
            case "4" -> {
                // показать детей по id
                int id = Integer.parseInt(input.inputKey(TextsMenu.Id));
                presenter.printChildren(id);
            }
            case "5" -> {
                // Добавить человеку связь
                int id = Integer.parseInt(input.inputKey(TextsMenu.Id));
                int relationId = Integer.parseInt(input.inputKey(TextsMenu.RelationId));
                int relationToPersonId = Integer.parseInt(input.inputKey(TextsMenu.IdTo));
                presenter.addRelationToPerson(id, relationId, relationToPersonId);
            }
            case "6" -> {
                // Записать человека в файл txt
                int id = Integer.parseInt(input.inputKey(TextsMenu.Id));
                presenter.addToTxt(id);
            }
            case "7" -> {
                // Записать человека в док
                int id = Integer.parseInt(input.inputKey(TextsMenu.Id));
                presenter.addToCsv(id);
            }
        }
    }    
}
