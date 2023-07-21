package com.romanovcopy.gmail.Genealogy.genealogyTree;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String name;
    private Gender gender; // Пол
    private List<Person> children; // Дети
    private List<Person> parents; // Родители
    private String id;

    public Animals(String name, LocalDate dateOfBirth, Gender gender){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        id=createId();
    }

    /**
     * генерация ключа исходя из текущей даты
     * @return
     */
    private String createId(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id: "+ getId()+"\n").append("Фамилия: "+getSurname()+"\n").append("Имя: "+getName()+"\n").
                append("Отчество: "+getPatronymic()+"\n").append("Дата рождения: "+dateOfBirth+"\n").
                append("Пол: "+gender+"\n").append("Семейное положение: "+maritalStatus+"\n");
        return stringBuilder.toString();
    }
}
