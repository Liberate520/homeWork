package model.commands;

import presenter.Presenter;

public class CreateNote implements CommandsInterface {
    private final String NAME = "Создать заметку. (комманда: new)";
    private final String KEY = "new";

    @Override
    public String getName() {
        return NAME;
    }
    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String result(String text) {
        if (text.equals(KEY)){
            return "Новая заметка";
        } else {
            Note note = new Note(text);
            new AddEntry(note);
            return "Выход в главное меню";
        }
    }

    public void newNote(String text){
        Note note = new Note(text);
        new AddEntry(note);
    }
}
