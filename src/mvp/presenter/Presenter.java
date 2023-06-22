package mvp.presenter;

import java.time.LocalDate;

import mvp.ui.View;
import person.Person;

public class Presenter {
    private View view;

    public void addNote(String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth,
            Person father,
            Person mother) {

        System.out.println("Добавление члена семьи и его данных");
    }

    public void getNote(String text) {
        System.out.println("Получение члена семьи и его данных");
    }

    public void getAllNote() {
        System.out.println("Получение всех родственников и их данных");
    }
}
