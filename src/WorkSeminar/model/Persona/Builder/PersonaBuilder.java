package WorkSeminar.model.Persona.Builder;

import WorkSeminar.model.Persona.Builder.CheckingIO.CheckIO;
import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonaBuilder {
    //private Scanner scann;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    // Переменная для управления циклами.
    private boolean cicle;
    /*
    Класс собирает нового персонжа, путём ввода с консоли основных параметров:
    Мия, Фамилия, Гендр, Дата рождения.
    Предплогается, что будет и более расширенный класс, котрый будет позволять вводить вообще все поля.
    TODO Пределать класс, разбив на методы: Ввод, ввод и проверка гендора, ввод и проверка даты рождения.
     */
    public Persona build(){
        //scann = new Scanner(System.in);
        Persona persona = new Persona();
        // Класс проверки. Содержит методы проверки коректности ввода даты и гендора.
        CheckIO io = new CheckIO();
        // Фактически, трай-кетч тут уже не нужен.
        try {
            System.out.println("Введите имя");
            name = Input.inputs();
            persona.setName(name);
            System.out.println("Введите фамилию");
            lastName = Input.inputs();
            persona.setLastName(lastName);
            System.out.println("Введите пол (Male/Female)");
            cicle = true;
            // Циклы дублируються, вынести запрос ввод в отдельный метод? Подумать
            while (cicle){
                String gen = Input.inputs();
                if(io.checkGender(gen)){
                    gender = Gender.valueOf(gen);
                    persona.setGender(gender);
                    cicle = false;
                } else {System.out.println("Не корректный гендр. Попробуйте снова.");}
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,M,d");
            System.out.println("Введите дут рождения: 1900,10,1");
            cicle = true;
            while (cicle){
                String time = Input.inputs();
                if(io.checkTime("yyyy,M,d", time)){
                    birthday = LocalDate.parse(time, formatter);
                    persona.setBirthday(birthday);
                    cicle = false;
                } else {System.out.println("Не корректный формат даты. Попробуйте снова.");}
            }
        } catch (Exception ex){
            System.out.println("Ошибка ввода!");
            ex.printStackTrace();
        }
        return persona;
    }
}
