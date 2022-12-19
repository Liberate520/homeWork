package presenter;

import view.TextMenu;
import view.View;

public class ToPresenter {
    private Presenter presenter = new Presenter();

    public void doSomething(String userSelect){
        View input = new View();
        switch (userSelect){
            case "1":
                //посмотреть всех людей
                presenter.printAllHuman();
                break;
            case "2":
                //добавить человека
                String name = input.inputKey(TextMenu.choiceName);
                int age = Integer.parseInt(input.inputKey(TextMenu.choiceAge));
                presenter.addHuman(name, age);
                break;
            case "3":
                //удалить человека
                int id = Integer.parseInt(input.inputKey(TextMenu.choiceId));
                presenter.removeHuman(id);
                break;
            case "4":
                //показать детей
                int ShowChild = Integer.parseInt(input.inputKey(TextMenu.choiceId));
                presenter.printChildren(ShowChild);
                break;
            case "5":
                //добавить человеку связь
                int addId = Integer.parseInt(input.inputKey(TextMenu.choiceId));
                int addRelationId = Integer.parseInt(input.inputKey(TextMenu.choiceRelationId));
                int relationHuman = Integer.parseInt(input.inputKey(TextMenu.choiceIdFor));
                presenter.addRelationHuman(addId, addRelationId, relationHuman);
                break;
        }
    }
}
