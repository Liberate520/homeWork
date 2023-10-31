/*
//Очень хочется перейти на сервис и билдер, но нужно тогда перепрописать конструкторы
//TODO допилить создание человека билдером и использование сервиса
package service;


import builder.HumanBuilder;
import familyTree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree fTree;
    private HumanBuilder builder;

    public Service(){
        fTree = new FamilyTree();
        builder = new HumanBuilder();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        Human human = builder.build(name, gender, birthDay, deathDay, mother, father);
        fTree.addHuman(human);
    }
    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for (Human human: fTree) {
            stringBuilder.append(human +"\n");
        }
        return stringBuilder.toString();
    }

}
 */