package presenter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.View;

import model.familyTree.*;
import model.human.Human;


public class Presenter {
    public View view;
    private TreeService treeService;

    public Human addHuman(List<String> data) {
        Human new_person;
        if (data.get(0).equals("")) {
            System.out.println("Введено слишком мало данных");
            return null;
        } else {
            new_person = new Human(data.get(0),
                    data.get(1),
                    data.get(2),
                    data.get(3),
                    data.get(4),
                    data.get(5),
                    data.get(6),
                    data.get(7));
            return new_person;

        }
    }


        public void c_import(Tree family) throws IOException {
            Scanner scan = new Scanner(System.in);
            System.out.println("Хотите ли Вы занести данные через Консоль? Если да, введите yes");
            String answer = scan.nextLine().toLowerCase();
            while (answer.equals("yes")){
                Human person = console_import();
                family.addHuman(person);
                System.out.println("Сохраняем? Введите yes");
                answer = scan.nextLine().toLowerCase();
            }
    }

    public Human console_import() throws IOException{
        List<String> data = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Выведите данные: ");
        System.out.print("Имя: ");
        String firstname = scan.nextLine();
        data.add(firstname);
        System.out.print("Фамилия: ");
        String lastname = scan.nextLine();
        data.add(lastname);
        System.out.print ("Дата рождения: ");
        String birth_date = scan.nextLine();
        data.add(birth_date);
        System.out.print ("Дата смерти: ");
        String deth_date = scan.nextLine();
        data.add(deth_date);
        System.out.print ("Пол: W / M? ");
        String gender = scan.nextLine();
        data.add(gender);
        System.out.print ("Идентификационный номер: ");
        String person_id = scan.nextLine();
        data.add(person_id);
        System.out.print ("Отец: ");
        String father_id = scan.nextLine();
        data.add(father_id);
        System.out.print ("Мать: ");
        String mother_id = scan.nextLine();
        data.add(mother_id );
        if (firstname.equals("")){
            System.out.println("Вы не ввели данные");
            return null;  }




        else{
            Human new_person = new Human(data.get(0),
                    data.get(1),
                    data.get(2),
                    data.get(3),
                    data.get(4),
                    data.get(5),
                    data.get(6),
                    data.get(7));
            return new_person;
        }


    }
}

