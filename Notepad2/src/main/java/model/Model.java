package model;

import model.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Model implements ModelInterface{
    private List<CommandsInterface> commands = new ArrayList<>();
    private CreateNote createNote = new CreateNote();
    private AllNotes allNotes = new AllNotes();
    private Exit exit = new Exit();
    private int indexMenu;
    private ChangeNote changeNote = new ChangeNote();
    private RemoveNote removeNote = new RemoveNote();

    /**
     * Конструктор. Сюда добавлять новые пункты меню
     */
    public Model() {
        this.commands.add(createNote);
        this.commands.add(allNotes);
        this.commands.add(changeNote);
        this.commands.add(removeNote);
        this.commands.add(exit);

    }

    /**
     * Сюда приходит комманда из презентера, выполняется логика и возвращается ответ
     * @param command
     * @return
     */
    @Override
    public String commandResult(String command) {

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getKey().equals(command)){
                String result = commands.get(i).result(command);
                this.indexMenu = i;
                return result;
            }
        }

        try {
            Integer.parseInt(command);
            String result = commands.get(indexMenu).result(command);
            return result;
        } catch (NumberFormatException nfe) {
            String result = commands.get(indexMenu).result(command);
            return result;
        }

    }

    /**
     * Создает меню. Берет List<CommandsInterface> переделывает в строку и отправляет в презентер
     * @return отправляет меню в презентер
     */
    @Override
    public String createMenu() {
        String menu = "";
        for (int i = 0; i < commands.size(); i++) {
            menu += commands.get(i).getName() + "\n";
        }
        return menu;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
