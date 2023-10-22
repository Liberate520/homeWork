package ru.gb.family_tree.person;


public class Parents {
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
        sb.append(mother != null ? "Мать: " + mother.toString() : "unknown");
        sb.append(father != null ? "\nОтец: " + father.toString() : "unknown");
        return sb.toString();
    }
}