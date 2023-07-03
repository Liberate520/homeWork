public class Person {

    private int id;                         // Индикационный номер
    private  int id_parent;                 // Номер главного родителя  (если 0 - это основатель древа, если 1 - это родители не известен(пока не реализовано))
    private int id_consort;                 // Номер супруга  
    private String sex;                     // Пол члена семьи
    private String name;                    // Имя члена семьи
    private String date_birthday;           // Дата рождения
    private String date_death;              // Дата смерти
    private int age;                        // Возраст (пока не реализовано, будет вычисляться автоматически)


    public Person(int id, int id_parent, int id_consort, String sex, String name, String data_birthday, String date_death){
        this.id=id;
        this.id_parent=id_parent;
        this.id_consort=id_consort;
        this.sex=sex;
        this.name=name;
        this.date_birthday=data_birthday;
        this.date_death=date_death;
    }

    public Person(int id, int id_parent, int id_consort, String sex, String name, String data_birthday){
        this.id=id;
        this.id_parent=id_parent;
        this.id_consort=id_consort;
        this.sex=sex;
        this.name=name;
        this.date_birthday=data_birthday;
    }

    public String show_person(){                                    //Метод печать (в строку) персональных данных
        StringBuilder pers = new StringBuilder();
        pers.append(id);
        pers.append(" Имя: ");
        pers.append(name);
        pers.append(" Пол: ");
        pers.append(sex);
        pers.append(" Дата рождения: ");
        pers.append(date_birthday);
        if (date_death!=null){
            pers.append(" Дата смерти: ");
            pers.append(date_death);
        }
       return pers.toString();

    }
                                                                    // Методы по возврату значений из персональных данных
    public int getId() {
        return id;
    }
    public int getId_parent() {
        return id_parent;
    }
    public int getId_consort() {
        return id_consort;
    }
    public String getSex() {
        return sex;
    }
    public String getName() {
        return name;
    }
    public String getDate_birthday() {
        return date_birthday;
    }
    public String getDate_death() {
        return date_death;
    }
    public int getAge() {
        return age;
    }
}
