package Семинар1.homeWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Tree;
public class Main {
    
    
    public static void main(String[] args) throws IOException{

        Human person_1 = new Human("Pavel", "Petrov", "10.01.1980", null, "m", "1PP_80", null, null);
        Human person_2 = new Human("Maria", "Petrova", "15.09.1980", null, "w", "1MP_80", null, null);
        Human person_3 = new Human("Petr", "Petrov", "12.11.1961", null, "m", "1PP_61", null, null);
        Human person_4 = new Human("Marina", "Petrova", "22.10.1965", null, "w", "1MP_65", null, null);
        ArrayList<Human> family = new ArrayList<>();
        person_3.setMother_id(person_2.getPerson_id());
        person_3.setFather_id(person_1.getPerson_id());
        person_4.setMother_id(person_2.getPerson_id());
        person_4.setFather_id(person_1.getPerson_id());
       
        family.add(person_1);
        family.add(person_2);
        family.add(person_3);
        family.add(person_4);
    
        
        Tree.print_sister_and_brother(family, person_3);
        Tree f = new Tree(family); // Только после создания этого объекта удалось выполнить функции в строчках 31 и 32
        
        f.read_info(family, "input_family.txt");
        f.print_info(family);
        System.out.println(family);    
        Tree.age(person_4);
    
        }
    }
    
