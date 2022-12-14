namespace GeekBrains;
using System.Collections;
public class Human:  Item {
    
    private int id;
    private String name;
    private int age;
    private List<Relationship> relationships;

    public Human(List<Item> list, String name, int age) {
        this.id = setId(list);
        this.name = name;
        this.age = age;
    }

    public Human() {
    }

    public int getId() {
        return id;
    }

    private int setId(List<Item> list) {
        int upperRange = 1000;
        Random random = new Random();
        int tempId = random.Next(upperRange);
        for (int i = 0; i < list.Count(); i++){
            if (list[i].getId() == tempId){
                tempId++;
                i = 0;
            }
        }
        return this.id = tempId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }
    
    public void setRelationship(Relationship relationship) {
        
        if (this.relationships == null){
            List<Relationship> temp = new List<Relationship>();
            temp.Add(relationship);
            this.relationships = temp;
        }
        else{
            this.relationships.Add(relationship);
        }
    }
    
    public String itemToString(){
        String res = "";
        res = "id человека: " + this.id + "\n" + "имя человека: " + this.name + "\n" + 
        "Возраст человека: " + this.age +"\n" + "Связи человека: " + "\n";
        if (this.relationships != null){
            foreach (Relationship r in this.relationships){
                    res = res + "с человеком " + r.getRelationToHumanId() +
                    " существует связь - " + r.getRelation() + "\n";
                }
        }            
        return res; 
    }
    
    public String childrensToString(){
        String res = "";
        if (this.relationships != null){
            foreach (Relationship r in this.relationships){
                if (r.getRelationId() == 2){ //2 - 'это связь дети в Relationships'
                    res = res + "Id ребенка " + r.getRelationToHumanId();
                }    
            }
        }
        return res;
    }
}

