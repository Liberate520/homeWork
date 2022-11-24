import java.util.ArrayList;
import java.util.Random;

public class Human {

    private int id;
    private String name;
    private int age;
    private ArrayList<Relationships> relationships;

    public static int setId(ArrayList<Human> list) {

        int upperRange = 10000000;
        Random random = new Random();

        int tempId = random.nextInt(upperRange);

        for (int i = 0; i < list.size(); i++){
        if (list.get(i).id == tempId);
            tempId++;
            i = 0;
        }
        return tempId;
    }

    public static Human createHuman(ArrayList<Human> list){
        Human tempHuman = new Human();

        tempHuman.id = setId(list);
        tempHuman.name = UserInputFromConsole.inputKey("Введите имя");
        tempHuman.age = Integer.parseInt(UserInputFromConsole.inputKey("Введите возраст"));
        return tempHuman;
    }
    
    public static String getNameIfNewId(ArrayList<Human> list, int id){

        String tempName = "";

        for (Human human : list) {
            if(human.id == id ){
                tempName = human.name;
            }
        }
        return tempName;
    }


    public static void printHuman(ArrayList<Human> list){
        String res = "";

        for (Human human : list) {
            res = "id человека: " + human.id + "\n" + "имя человека: " + human.name + "\n" + 
            "Возраст человека: " + human.age +"\n" + "Связи человека: " + "\n";
            for (int i = 0; i < human.relationships.size(); i++){
                res = res + "с человеком " + human.relationships.get(i).getRelationToHumanId() +
                getNameIfNewId(list, human.relationships.get(i).getRelationToHumanId()) +
                " существует связь" + human.relationships.get(i).getRelation() + "\n";
            }
            System.out.print(res);
            res = "";  
        }
    }

    public static void deleteHuman(ArrayList<Human> list, int id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).id == id){
                list.remove(i);
            }  
        }
    }

    public static void addRelation(ArrayList<Human> list, int id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).id == id){
                list.get(i).relationships = Relationships.setRelationships();
            }  
        }
    }

    public static void printChildrens(ArrayList<Human> list, int id){
        String res = "";
        for (int i = 0; i < list.get(id).relationships.size(); i++){
            if (list.get(id).relationships.get(i).getRelationsId() == 2){ //2 - 'это связь дети в Relationships'
                res = res + "Имя ребенка " + getNameIfNewId(list,list.get(id).relationships.get(i).getRelationToHumanId()) +
                "Id ребенка " + list.get(id).relationships.get(i).getRelationToHumanId() + "\n";
            }
            System.out.print(res); 
        }
    }

    
}
