package mvp.presenter;

import mvp.ui.View;

public class Presenter {
    private View view;

    public void addNote(String timeWrite, String textWrite) {
        System.out.println("Добавление члена семьи и его данных");
    }

    public void getNote(String text) {
        System.out.println("Получение члена семьи и его данных");
    }

    public void getAllNote() {
        System.out.println("Получение всех родственников и их данных");
    }

}
