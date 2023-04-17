package model.tree.classes;

import java.util.Scanner;

public class SetHuman {

    public void settingHuman(Human human){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input name: ");
        human.setName(scanner.nextLine());

        System.out.println("Input patronymic: ");
        human.setPatronymic(scanner.nextLine());

        System.out.println("Input surname: ");
        human.setSurname(scanner.nextLine());

        boolean loop = false;
        while(!loop){
            System.out.println("Input date of birth: ");
            String dateBirthString = scanner.nextLine();
            try{
                human.setDateBirth(Integer.parseInt(dateBirthString));
                loop = true;
            }
            catch(NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");
            }
        }
        
        loop = false;
        while(!loop){
            System.out.println("Input date of death: ");
            String dateDeathString = scanner.nextLine();
            try{
                human.setDateDeath(Integer.parseInt(dateDeathString));
                loop = true;
            }
            catch(NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");               
            }
        }
        
    }

}
