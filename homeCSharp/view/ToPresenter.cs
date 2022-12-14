namespace GeekBrains;
public class ToPresenter {

    private Presenter presenter = new Presenter();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        if (userSelect == "1") {
            // посмотреть всех в консоли
            presenter.consolePrintAllHumans();    
            }
        
        else if (userSelect == "2") {
            // Добавить человека
            String name = input.inputKey(TextsMenu.inviteName);
            int age = Int32.Parse(input.inputKey(TextsMenu.inviteAge));
            presenter.addHuman(name, age);
        }

        else if (userSelect == "3") {
            // удалить человека по id
            int id = Int32.Parse(input.inputKey(TextsMenu.inviteId));
            presenter.removeHuman(id);
        }

        else if (userSelect == "4") {
            // показать детей по id
            int id = Int32.Parse(input.inputKey(TextsMenu.inviteId));
            presenter.printChildrens(id);
        }

        else if (userSelect == "5") {
            // Добавить человеку связь
            int id = Int32.Parse(input.inputKey(TextsMenu.inviteId));
            int relationId = Int32.Parse(input.inputKey(TextsMenu.inviteReletionId));
            int relationToHumanId = Int32.Parse(input.inputKey(TextsMenu.inviteIdTo));
            presenter.addReletionToHuman(id, relationId, relationToHumanId);
        }
        
        else if (userSelect == "6") {
            // Записать человека в файл txt
            int id = Int32.Parse(input.inputKey(TextsMenu.inviteId));
            presenter.addToTxt(id);
        }
        
        else if (userSelect == "7") {
            // Записать человека в док
            int id = Int32.Parse(input.inputKey(TextsMenu.inviteId));
            presenter.addToDoc(id);
        }   
    }    
}
