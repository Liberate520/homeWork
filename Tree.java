package Семинар1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import Семинар1.homeWork.Tree_2ndgen;

public class Tree {
    public static void main(String[] args) throws IOException{

    Tree_2ndgen person_1 = new Tree_2ndgen("Pavel", "Petrov", "10.01.1980", null, "m", "1PP_80", null, null, null);
    Tree_2ndgen person_2 = new Tree_2ndgen("Maria", "Petrova", "15.09.1980", null, "w", "1MP_80", null, null, null);
    Tree_2ndgen person_3 = new Tree_2ndgen("Petr", "Petrov", "12.11.1961", null, "m", "1PP_61", null, null, null);
    Tree_2ndgen person_4 = new Tree_2ndgen("Marina", "Petrova", "22.10.1965", null, "w", "1MP_65", null, null, null);
    List<Tree_2ndgen> family = new ArrayList<>();
    person_3.setMother_id(person_2.getPerson_id());
    person_3.setFather_id(person_1.getPerson_id());
    person_4.setMother_id(person_2.getPerson_id());
    person_4.setFather_id(person_1.getPerson_id());
    person_1.setChild_id(person_3.getPerson_id());
    person_2.setChild_id(person_3.getPerson_id());
    family.add(person_1);
    family.add(person_2);
    family.add(person_3);
    family.add(person_4);

    
    person_3.print_sister_and_brother(family, person_3);

    person_3.print_family(family);
    person_3.read_info(family, "input_family.txt");
    System.out.println(family);    
    person_4.age(person_4);

    }
}

