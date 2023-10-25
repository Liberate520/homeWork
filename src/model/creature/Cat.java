package model.creature;

import model.FamilyTree.Interface.CreatureItem;

import java.time.LocalDate;

public class Cat extends Creature implements CreatureItem<Creature> {
    private String breed;

    public Cat(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Human mother,
               Human father, String breed) {
        super(name, gender, dataBirth, dataDeath, mother, father);
        this.breed = breed;
    }

    public Cat(String name, Gender gender, LocalDate dataBirth) {
        super(name, gender, dataBirth);
    }

    public Cat(String name, Gender gender, LocalDate dataBirth, Human father, Human mother) {
        super(name, gender, dataBirth, father, mother);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean addChildren(Creature child) {
        return false;
    }

    @Override
    public String getChildrenInfo() {
        return null;
    }

    @Override
    public int getPeriod(LocalDate dataBirth, LocalDate dataDeath) {
        return 0;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void addParent(Creature parent) {

    }

    @Override
    public String getMotherInfo() {
        return null;
    }

    @Override
    public String getFatherInfo() {
        return null;
    }

}
