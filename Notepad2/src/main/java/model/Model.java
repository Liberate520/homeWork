package model;

import model.commands.AllNotes;
import model.commands.CommandsInterface;
import model.commands.CreateNote;
import model.commands.Exit;

import java.util.ArrayList;
import java.util.List;

public class Model implements ModelInterface{
    private List<CommandsInterface> commands = new ArrayList<>();

    CreateNote createNote = new CreateNote();
    /**
     * Конструктор. Сюда добавлять новые пункты меню
     */
    public Model() {
        this.commands.add(createNote);
        this.commands.add(new AllNotes());
        this.commands.add(new Exit());
    }

    /**
     * Сюда приходит комманда из презентера, выполняется логика и возвращается ответ
     * @param commandNumber
     * @return
     */
    @Override
    public String commandResult(String commandNumber) {
        int commandIndex = Integer.parseInt(commandNumber) - 1;
        String result = commands.get(commandIndex).result();

        return result;
    }

    /**
     * Создает меню. Берет List<CommandsInterface> переделывает в строку и отправляет в презентер
     * @return отправляет меню в презентер
     */
    @Override
    public String createMenu() {
        String menu = "";
        for (int i = 0; i < commands.size(); i++) {
            Integer index = i + 1;
            menu += index + ". " + commands.get(i).getName() + "\n";
        }
        return menu;
    }
    @Override
    public void createNewNote(String text){
        createNote.newNote(text);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
