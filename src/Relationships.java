import java.util.ArrayList;

public class Relationships {

    private int relationsId;
    private String relation;
    private int relationToHumanId;


    public static ArrayList<Relationships> setRelationships(){

        ArrayList<Relationships> temparr = new ArrayList<Relationships>();
        int count;

        count = Integer.parseInt(UserInputFromConsole.inputKey("Введите количество связей у человека "));

        for (int i = 0; i < count; i++){
            Relationships tempRel = new Relationships();

            while(!(tempRel.relationsId == 1 || tempRel.relationsId == 2)){
            tempRel.relationsId = Integer.parseInt(UserInputFromConsole.inputKey("Введите название связи:\n"+
                                                                                    "1 - муж/жена\n"+
                                                                                    "2 - ребенок"));
            }

            if (tempRel.relationsId == 1){
                tempRel.relation = "брак";
            }
            else tempRel.relation = "ребенок";

            tempRel.relationsId = Integer.parseInt(UserInputFromConsole.inputKey("Введите номер человека для связи"));

            temparr.add(i, tempRel);
        }
        return temparr;
    }


    public int getRelationsId() {
        return relationsId;
    }


    public String getRelation() {
        return relation;
    }


    public int getRelationToHumanId() {
        return relationToHumanId;
    }

}

    