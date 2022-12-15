public class Human {
    private String name;
    private String surname;
    private int birth;
    private int death;
    private String gender;


    public Human(String name, String surname, int birth, int death, String gender) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.death = death;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth, int death) {
        if (birth < death) {
            this.birth = birth;
        } else {
            System.out.println("Вы ввели не верный год");
        }
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death, int birth) {
        if (death > birth) {
            this.death = death;
        } else {
            System.out.println("Вы ввели неверный год");
        }
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", surname=" + surname + ", birth=" + birth + ", death=" + death + ", gender="
                + gender
                + "]";
    }

}
