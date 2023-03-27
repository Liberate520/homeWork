package model;

public class Person {
    private String firstname; //фамилия
    private String name; //имя
    private String patronymic; //отчество
    private String birthday;//дата рождения
    private Integer phoneNumber; //номер телефона
    private String floor; //пол

    public Person(String s) throws Exception{
        try {
            String[] parameters = s.split(" ");
            String str = "Возможна ошибка в введеном тексте";
            if (parameters.length > 6) str = "Данных введено больше, чем требуется";
            if (parameters.length < 6) str = "Данных введено меньше, чем требуется";
            if (parameters.length != 6) throw new Exception(str);
            for (int i = 0; i < 3; i++) {
                if (!parameters[i].matches("[А-Я].[а-я]+|[A-Z].[a-z]+"))
                    throw new Exception("В фамилии используются недопустимые символы(фио начинается с заглавных букв)");
            }
            this.firstname = parameters[0];
            this.name = parameters[1];
            this.patronymic = parameters[2];
            if (!parameters[3].matches(("^(0?[1-9]|[12][0-9]|3[0-1]).(0?[1-9]|1[0-9]).\\d{4}$"))) throw new Exception("Введен неверный формат даты");
            this.birthday = parameters[3];
            if (!parameters[4].matches("[0-9]+")) throw new Exception("В телефоне используются не только цифры");
            this.phoneNumber = Integer.valueOf(parameters[4]);
            if (!parameters[5].equals("f") && !parameters[5].equals("m")) throw new Exception("Неверно указан пол");
            this.floor = parameters[5];
        }catch (Exception e){
            throw e;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

}
