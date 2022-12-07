package view;

import presenter.Presenter;

public class ToPresenter {

    private Presenter presenter = new Presenter();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        if (userSelect.equals("1")) {
            // посмотреть всех в консоли
            presenter.consolePrintAllHumans();    
            }
        
        else if (userSelect.equals("2")) {
            // Добавить человека
            String name = input.inputKey(TextsMenu.inviteName);
            int age = Integer.parseInt(input.inputKey(TextsMenu.inviteAge));
            presenter.addHuman(name, age);
        }

        else if (userSelect.equals("3")) {
            // удалить человека по id
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            presenter.removeHuman(id);
        }

        else if (userSelect.equals("4")) {
            // показать детей по id
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            presenter.printChildrens(id);
        }

        else if (userSelect.equals("5")) {
            // Добавить человеку связь
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            int relationId = Integer.parseInt(input.inputKey(TextsMenu.inviteReletionId));
            int relationToHumanId = Integer.parseInt(input.inputKey(TextsMenu.inviteIdTo));
            presenter.addReletionToHuman(id, relationId, relationToHumanId);
        }
        
        else if (userSelect.equals("6")) {
            // Записать человека в файл txt
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            presenter.addToTxt(id);
        }
        
        else if (userSelect.equals("7")) {
            // Записать человека в док
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            presenter.addToDoc(id);
        }   
    }    
}
