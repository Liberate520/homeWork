package VIVI.Search;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;

import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class SearchName implements ISearch {
    Designer_Human designer_human;
    Femily_Tree femily_tree;
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)

    @Override
    public void search(List<Designer_Human> humans) {
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя:");
            iConverted.personСonvertedUpper_Lower(personName);


            for (Designer_Human human : humans) {
                if (Objects.equals(human.getName(), personName)) {
                    humans.add((Designer_Human) designer_human.getHumans());
//                    femily_tree.forEach(System.out::println);
                }
                showMessageDialog(null, humans);
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