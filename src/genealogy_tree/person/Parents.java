package genealogy_tree.person;

import java.io.Serializable;

public class Parents implements Serializable{
    private Person mother;
    private Person father;

    public Person getMother() {
        return mother;
    }
    
    public void setParent(Person parent){
        if (parent.getGender() == Gender.Female){
            this.mother = parent;
        }else{
            this.father = parent;
        }
    }    

    public Person getFather() {
        return father;
    }    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Мать: " + (mother != null ?  mother.toString() : "unknown") + "\n");
        sb.append("Отец: " + (father != null ? father.toString() : "unknown"));
        return sb.toString();
    }
}