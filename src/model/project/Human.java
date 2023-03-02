package model.project;

import java.util.ArrayList;
import java.util.List;

public class Human extends User{
    private String name;
    private String sex;
    private Integer year_of_birth;
    private Human father;
    private Human mother;
    private List<Human> children;
    
    public Human(String name, String sex, Integer year_of_birth, User father, User mother) {
        super(name, sex, year_of_birth, father, mother);
    }
    
    public Human(String name, String sex, Integer year_of_birth){
        super(name, sex, year_of_birth, null, null);
    }
}