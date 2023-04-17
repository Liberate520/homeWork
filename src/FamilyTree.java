package oop_homework_1;

import oop_homework_1.Level0;
import oop_homework_1.TopLevel;
import oop_homework_1.LowerLevel;



public class FamilyTree {

    private Human human;
    
   
    public FamilyTree(Human human) {
        this.human = human;        
    }

    @Override
    public String toString() {
        System.out.println(human.getFio() + ":\n");
        String str = "";
        str = Level0.level0(human, str);
        str = TopLevel.topLevel(human, str);
        str = LowerLevel.lowerLevel(human, str);
                
        return str;
    }
   

    

    



    
}
