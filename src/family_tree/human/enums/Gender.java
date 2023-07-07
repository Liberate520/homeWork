package family_tree.human.enums;

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
