package genealogy_tree.model.Human;

public enum Gender {
    Male("Male"), Female("Female");

    private final String genderString;

    Gender(String genderStrings) {
        this.genderString = genderStrings;
    }

    public  String getGender(){
        return genderString;
    }

}
