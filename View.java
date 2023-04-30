import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View<T extends Human> {
    public List<String> console_import() throws IOException{
            List<String> data = new ArrayList<>();
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите данные: ");
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
            System.out.print ("Пол: ");
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
            data.add(mother_id);
            return data;
           
       
        }
     
        public void c_import(Tree family) throws IOException{
            Scanner scan = new Scanner(System.in);
            System.out.println("Хотите занести данные через Консоль? Введите yes, если ДА");
            String answer = scan.nextLine().toLowerCase();
            while (answer.equals("yes")){
                List<String> data = new ArrayList<>();
                data = console_import();
                Presenter presenter = new Presenter();
                Human person = presenter.CreateHuman(data);
                family.addHuman(person);
                System.out.println("Хотите продолжить?");
                answer = scan.nextLine().toLowerCase();
            }

        }

        public void console_print(Tree<Human> family){
            System.out.println("Наша семья:");
            for (Human member : family){
                System.out.println(member);
            }

        }

    }