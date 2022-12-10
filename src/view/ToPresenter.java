package view;

import presenter.Presenter;


@SuppressWarnings("unused")
public class ToPresenter {

    private final Presenter presenter = new Presenter();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        switch (userSelect) {
            case "1" ->
                // посмотреть всех в консоли
                    presenter.consolePrintAllPerson();
            case "2" -> {
                // Добавить человека
                String name = input.inputKey(TextsMenu.inviteName);
                int age = Integer.parseInt(input.inputKey(TextsMenu.inviteAge));
                presenter.addPerson(name, age);
            }
            case "3" -> {
                // удалить человека по id
                int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
                presenter.removePerson(id);
            }
            case "4" -> {
                // показать детей по id
                int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
                presenter.printChildren(id);
            }
            case "5" -> {
                // Добавить человеку связь
                int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
                int relationId = Integer.parseInt(input.inputKey(TextsMenu.inviteRelationId));
                int relationToHumanId = Integer.parseInt(input.inputKey(TextsMenu.inviteIdTo));
                presenter.addRelationToPerson(id, relationId, relationToHumanId);
            }
            case "6" -> {
                // Записать человека в файл txt
                int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
                presenter.addToTxt(id);
            }
            case "7" -> {
                // Записать человека в csv
                int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
                presenter.addToCsv(id);
            }
        }
    }
}
