import Fileredactor.Fileredactor;

import java.io.IOException;
import java.util.ArrayList;

class Main extends Fileredactor {
    
    
    public static void main(String[] args)  throws IOException, ClassNotFoundException{

        Human person_1 = new Human("Marya", "Faivisovich", "28.05.1979", null, "w", "1PP_79", null, null);
        Human person_2 = new Human("Andrey", "Faivisovich", "09.04.1988", null, "m", "1MP_88", null, null);
        Human person_3 = new Human("Aleksandr", "Faivisovich", "10.07.1953", null, "m", "1PP_53", null, null);
        Human person_4 = new Human("Irina", "Truschenko", "09.01.1953", null, "w", "1MP_53", null, null);
        Presenter c_import = new Presenter();
        


        Tree<Human> family = new Tree();
        TreeService family_service = new TreeService(family);
        
        
        person_3.setMother_id(person_4.getPerson_id());
        person_3.setFather_id(person_3.getPerson_id());
        person_4.setMother_id(person_4.getPerson_id());
        person_4.setFather_id(person_3.getPerson_id());
       
        family.addHuman(person_1);
        family.addHuman(person_2);
        family.addHuman(person_3);
        family.addHuman(person_4);
        c_import.c_import(family);
        family.print_sister_and_brother(person_4);

        Human father = family.find_father( person_3);
        System.out.println("Отец:\n" + father);
        ArrayList<Object> family_list = new ArrayList<>();
        Serialise s = new Serialise();
        s.SerialiseList("family.out", family_list);

 
 
    }

    }
    