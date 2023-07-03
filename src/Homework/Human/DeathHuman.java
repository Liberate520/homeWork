package Homework.Human;

import java.time.LocalDate;

public class DeathHuman extends Human {
    private LocalDate death;


    public DeathHuman(String name, LocalDate birth, LocalDate death, Gender gender) {
        super(name, birth, gender);
        this.death = death;
    }

    public DeathHuman(String name, LocalDate birth, LocalDate death, Gender gender, Human father, Human mother) {
        super(name, birth, gender, father, mother);
        this.death = death;
    }

    public DeathHuman(String name, LocalDate birth, LocalDate death, Gender gender, Human parent) {
        super(name, birth, gender, parent);
        this.death = death;
    }

    @Override
    public String toString() {
        if(father != null && mother != null){return "ФИО: " + name + ", " + birth + " г.р., " + "Дата смерти: " + death + " (" + (death.getYear()-birth.getYear()) + " лет)" + ", Пол: " + gender + ", Отец: " + father.getName() + ", Мать: " + mother.getName();}
        if(father != null && mother == null){return "ФИО: " + name + ", " + birth + " г.р., " + "Дата смерти: " + death + " (" + (death.getYear()-birth.getYear()) + " лет)" + ", Пол: " + gender + ", Отец: " + father.getName();}
        if(father == null && mother != null){return "ФИО: " + name + ", " + birth + " г.р., " + "Дата смерти: " + death + " (" + (death.getYear()-birth.getYear()) + " лет)" + ", Пол: " + gender + ", Мать: " + mother.getName();}
        else{return "ФИО: " + name + ", " + birth + " г.р., " + "Дата смерти: " + death + " (" + (death.getYear()-birth.getYear()) + " лет)" + ", Пол: " + gender;}
    }
}
