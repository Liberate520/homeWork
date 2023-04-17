package oop_homework_1;

public class LowerLevel {
    public static String lowerLevel(Human human, String str) {

        str = str + "Дети: ";

        for(int i = 0; i < human.getChildren().size(); i++){
            str = str + human.getChildren().get(i).getFio() + "     ";
        }

        str = str + "\n";            
    
        return str;
    }
}
