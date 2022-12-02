package controller;

import model.*;

public class Controller {
    private String userSelect = "EMPTY";
    private String userString = "EMPTY";
    private HumanList humanList = new HumanList();

    public String getUserSelect() {
        return userSelect;
    }
    public void setUserSelect(String userSelect) {
        this.userSelect = userSelect;
    }
    public String getUserString() {
        return userString;
    }
    public void setUserString(String userString) {
        this.userString = userString;
    }

    public void doSomething(){
        if (userSelect.equals("1")) {
            // посмотреть всех
            for (Human human : humanList.getHumanList()) {
                human.printHuman(human.getHuman(human));
            }
        }
        
        else if (userSelect.equals("2")) {
            // Добавить человека
            humanList.addHuman();
        }

        else if (userSelect.equals("3")) {
            // удалить человека по id
            humanList.removeHuman();
        }

        else if (userSelect.equals("4")) {
            // показать детей по id
            humanList.printChildrens();
        }

        else if (userSelect.equals("5")) {
            // Добавить человеку связь
            humanList.addReletionToHuman();
        }
        
        else if (userSelect.equals("6")) {
            // Записать человека в файл txt
            humanList.addToTxt();
        }
        
        else if (userSelect.equals("7")) {
            // Записать человека в док
            humanList.addToDoc();
        }   
    }    
}
