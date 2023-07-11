package family_tree.creatures.enums;

public enum Gender {
    Male, Female;
    @Override
    public String toString() {
        if (this.name().equals("Male")){
            return "Мужской";
        }else{
            return "Женский";
        }
    }
}
