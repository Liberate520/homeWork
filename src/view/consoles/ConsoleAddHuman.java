package view.consoles;

import Animal.Human.Gender;

public class ConsoleAddHuman extends Consoles {
    private String name;
    private Gender gender;
    private int year, month, day, dyear, dmonth, dday;
    

    public void workConsole(){
        System.out.print("Введите имя человека: ");
        name = scanner.nextLine();
        System.out.print("Укажите пол человека 'm,f': ");
        gender = setGender(scanner.nextLine());
        System.out.println("Укажите дату рождения человека ");
        System.out.print("ГГГГ: ");
        year = Integer.parseInt(scanner.nextLine());
        System.out.print("ММ: ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.print("ЧЧ: ");
        day = Integer.parseInt(scanner.nextLine());
        System.out.print("Человек еще жив? Y/N ");
        if (scanner.nextLine().equals("N")){
            System.out.print("Укажите дату смерти человека");
            System.out.print("ГГГГ: ");
            dyear = Integer.parseInt(scanner.nextLine());
            System.out.print("ММ: ");
            dmonth = Integer.parseInt(scanner.nextLine());
            System.out.print("ЧЧ: ");
            dday = Integer.parseInt(scanner.nextLine());
            cons.getPresenter().addHuman(name,year,month,day,dyear,dmonth,dday,gender);
        } else cons.getPresenter().addHuman(name,year,month,day,gender);
    }

    private Gender setGender(String value){
        if (value.equals("m")) return Gender.Male;
        else return Gender.Female;       
    }
}
