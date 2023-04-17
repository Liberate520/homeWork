package oop_homework_1;

public class Level0 {
    public static String level0(Human human, String str) {

        if(!human.getBro().isEmpty()){
            for (int i = 1; i < human.getBro().size() + 1; i++){
                if (i % 2 == 0){
                    str = human.getBro().get(i - 1).toString() + "     " + str;
                }
                else{
                    str = str + "     " + human.getBro().get(i - 1).getFio().toString();
                }
            }            
        }
            
        str = "Братья/сестры: " + str + "\n";
    
        return str;
    }
    
}
