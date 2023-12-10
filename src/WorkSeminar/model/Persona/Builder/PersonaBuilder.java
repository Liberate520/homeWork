package WorkSeminar.model.Persona.Builder;

import WorkSeminar.model.Persona.Builder.CheckingIO.CheckIO;
import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonaBuilder {
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    private boolean cicle;
    /*
    Класс собирает нового персонжа, путём ввода с консоли основных параметров:
    Мия, Фамилия, Гендр, Дата рождения.
    Предплогается, что будет и более расширенный класс, котрый будет позволять вводить вообще все поля.
     */
    public Persona build(Scanner scan){
        Persona persona = new Persona();

        // Класс проверки. Содержит методы проверки коректности ввода даты и гендора.
        CheckIO io = new CheckIO();

        try {
            do {
                System.out.println("Введите имя");
                name = Input.inputs(scan);
                if(io.checkString(name)){
                    persona.setName(name);
                    cicle = false;
                } else {
                    cicle = true;
                    System.out.println("Введено не корректное имя. Попробуйте снова.");
                }
            } while (cicle);

            do {
                System.out.println("Введите фамилию");
                lastName = Input.inputs(scan);
                if(io.checkString(lastName)){
                    persona.setLastName(lastName);
                    cicle = false;
                } else {
                    cicle = true;
                    System.out.println("Введено не корректная фамилия. Попробуйте снова.");
                }
            } while (cicle);


            do {
                System.out.println("Введите пол (Male/Female)");
                String gen = Input.inputs(scan);
                if(io.checkGender(gen)){
                    gender = Gender.valueOf(gen);
                    persona.setGender(gender);
                    cicle = false;
                } else {
                    cicle = true;
                    System.out.println("Не корректный гендр. Попробуйте снова.");
                }
            } while (cicle);


            do {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd");
                System.out.println("Введите дут рождения: 1900,10,1");
                String time = Input.inputs(scan);
                if(io.checkDate(formatter, time)){
                    birthday = LocalDate.parse(time, formatter);
                    persona.setBirthday(birthday);
                    cicle = false;
                } else {
                    cicle = true;
                    System.out.println("Не корректный формат даты. Попробуйте снова.");
                }
            } while (cicle);

        } catch (Exception ex){
            System.out.println("Ошибка ввода!");
        }
        return persona;
    }
}
