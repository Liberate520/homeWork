package presenter;

import model.ImportJsonPerson;
import model.Person;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import view.ConsoleTerminal;

import java.io.IOException;

/**
 * класс презентер, для взаимодействия view и model(person)
 */
public class Controller{
    private ConsoleTerminal view;

    public Controller(ConsoleTerminal view){
        this.view = view;
        view.setController(this);
    }
    public void onClick() throws JSONException, IOException, ParseException {
        while (true) {
            String s = view.scanString("Введите данные через пробел : Фамилия_Имя_Отчество_Дата рождения(формат dd.mm.yyyy)_Номер телефона(одни цифры)_Пол(f или m)");
            Person per = null;
            try {
                per = new Person(s);
            } catch (Exception e) {
                view.printStr(e.getMessage());
            }
            //im.writeTextJson(per, im.getAr());
            try {
                ImportJsonPerson im = new ImportJsonPerson(per);
                im.writeFileJson(per.getFirstname() + ".json", im.writeTextJson(per));
                view.printStr("Файл создан");
                return;
            } catch (Exception e) {
                view.printStr("Произошла ошибка при создании файла");
            }
        }
    }
}