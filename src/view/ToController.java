package view;

import controller.Controller;

public class ToController {

    private Controller controller = new Controller();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        if (userSelect.equals("1")) {
            // посмотреть всех в консоли
            controller.consolePrintAllHumans();    
            }
        
        else if (userSelect.equals("2")) {
            // Добавить человека
            String name = input.inputKey(TextsMenu.inviteName);
            int age = Integer.parseInt(input.inputKey(TextsMenu.inviteAge));
            controller.addHuman(name, age);
        }

        else if (userSelect.equals("3")) {
            // удалить человека по id
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            controller.removeHuman(id);
        }

        else if (userSelect.equals("4")) {
            // показать детей по id
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            controller.printChildrens(id);
        }

        else if (userSelect.equals("5")) {
            // Добавить человеку связь
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            int relationId = Integer.parseInt(input.inputKey(TextsMenu.inviteReletionId));
            int relationToHumanId = Integer.parseInt(input.inputKey(TextsMenu.inviteIdTo));
            controller.addReletionToHuman(id, relationId, relationToHumanId);
        }
        
        else if (userSelect.equals("6")) {
            // Записать человека в файл txt
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            controller.addToTxt(id);
        }
        
        else if (userSelect.equals("7")) {
            // Записать человека в док
            int id = Integer.parseInt(input.inputKey(TextsMenu.inviteId));
            controller.addToDoc(id);
        }   
    }    
}
