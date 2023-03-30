public class Human {
    private static int count = 1;
    private int id;
    private String firstName;
    private String lastName;
    //DateTime dateBirth;
    String dateBirth;
    //DateTime dateDeath;
    String dateDeath;
    private Sex sex;
    private int idMother;
    private int idFather;

    /******************************************************************************************************************
     * class Human
     * @param firstName < Имя
     * @param lastName  < Фамилия
     * @param dateBirth < День рождения
     * @param dateDeath < День смерти
     * @param sex       < Пол (мужской / женский)
     * @param idMother  < id матери
     * @param idFather  < id отца
     ******************************************************************************************************************/
    public Human(String firstName, String lastName, String dateBirth, String dateDeath, Sex sex, int idMother, int idFather) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.sex = sex;
        this.idMother = idMother;
        this.idFather = idFather;
    }

    public Human(String firstName, String lastName, String dateBirth, Sex sex, int idMother, int idFather) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.dateDeath = null;
        this.sex = sex;
        this.idMother = idMother;
        this.idFather = idFather;
    }
    public Human(String firstName, String lastName, String dateBirth, Sex sex) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.dateDeath = null;
        this.sex = sex;
        this.idMother = 0;
        this.idFather = 0;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public Sex getSex() {
        return sex;
    }

    public int getIdMother() {
        return idMother;
    }

    public int getIdFather() {
        return idFather;
    }

    public String toString(){
        if(dateDeath != null){
            return " %s %s(id %d) \n  Дата рождения - %s' Дата сметри - %s'\n".formatted(firstName, lastName, id, dateBirth, dateDeath);
        }
        return " %s %s (id %d) \n  Дата рождения - %s \n".formatted(firstName, lastName, id, dateBirth);
    }
}
