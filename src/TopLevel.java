package oop_homework_1;

public class TopLevel {

    public static String topLevel(Human human, String str) {
        String strWork = "";
        if(human.getFather() != null){
            strWork = strWork + human.getFather().getFio() + "     ";
        }
        if(human.getMother() != null){
            strWork = strWork + human.getMother().getFio();
        }
        str = "Родители: "  + strWork + "\n" + str;     
    
        return str;
    }
    
}
