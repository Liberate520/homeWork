package FamilyTree.model.nodes;

import java.lang.StringBuilder;

public class Dog extends Node{ 
    
    private String breeder;//второе имя (от заводчика)
    private String breed;//порода


    public Dog (String name, String breeder, String breed, Gender gender,int yearOfBirth,int yearOfDeath, Person father,Person mother) {
        super(name, gender, yearOfBirth, yearOfDeath, father, mother);
        this.breeder = breeder;
        this.breed = breed;    
    }
    public Dog (String name, String breeder, String breed, Gender gender,int yearOfBirth, int yearOfDeath) {
        this(name, breeder, breed, gender, yearOfBirth, yearOfDeath, null, null);
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int yearOfDeath = getYearOfDeath();
        sb.append("Кличка: ")
            .append(getName())
            .append(", питомник ")
            .append(breeder);
        if(getGender().equals(Gender.m)){
            sb.append(", самец, порода: ");
        } else sb.append(", самка, порода: ");
        sb.append(breed);
        sb.append(getYearOfBirth())
            .append(" - ");
        if(yearOfDeath > 0){
            sb.append(yearOfDeath);
        }
        return sb.toString();
    }

    @Override
    public boolean search(String text) {
        if(super.getName().contains(text) || breeder.contains(text) || breed.contains(text))
            return true;
        return false;    
    }

    
}
