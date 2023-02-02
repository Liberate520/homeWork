package VIVI.AddHuman;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_6.Designer_Human;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddPeopleWithJOptionPane implements IAddHumanSimple {

    Designer_Human designer_human;
    //Переделал метод убрал все лишнее поменял логику использовал конструктор людей, код читабельнее и меньше
//Поработал с инкапсуляцией
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)

    @Override
    public void addHumanSimple() {//Без параметров (тем самым можно избежать создание экземпляра класса)
        String end = "Готово";
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя:");
            iConverted.personСonvertedUpper_Lower(personName);
            if (personName.equals(end)) ;
            {
                String personSEX = showInputDialog("Пожалуйста, введите пол:");
                iConverted.personСonvertedUpper_Lower(personSEX);
                if (personSEX.equals(end)) ;
                {
                    Integer personDate = Integer.parseInt(showInputDialog("Пожалуйста, год рождения:"));
                    if (personDate != null && personDate.equals(end)) //Пытался сделать по разному только так сработало
                    //Нужен вывод типа boolean
                    {
                        continue;

                    }
                    Designer_Human designer_human1 = new Designer_Human(personName, personSEX, personDate);
                    designer_human.getHumans().add(designer_human1);
                    showMessageDialog(null, "Новый человек добавлен в список: " + designer_human1);
//
//
                }
            }
            String txt2 = showInputDialog(null, "Повторить Выбор ?\nДа? Нет?");
            if (Objects.equals(txt2.toLowerCase(), "да")) {
                continue outer;
            } else {
                Objects.equals(txt2.toLowerCase(), "нет");
                {
                    break outer; //я не знаю почему светит серым, но все работает
                }
            }
        }
    }
}
