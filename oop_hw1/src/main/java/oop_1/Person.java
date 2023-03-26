package oop_1;

public class Person {

    private String full_name;
    private String year_of_birth;
    private String sex;

    public Person(String full_name, String year_of_birth, String sex) {
        this.full_name = full_name;
        this.year_of_birth = year_of_birth;
        this.sex = sex;
    }

    public String getFull_name() {
        return full_name;
    }


    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }


    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String printInfoPerson() {
        System.out.printf("%s, %s г.р, пол: %s", full_name, year_of_birth, sex);
        return "";
    }


}