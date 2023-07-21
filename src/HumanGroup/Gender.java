package Tree.homeWork.src.HumanGroup;

public enum Gender {
    Male, Female;
    public String getGender(Gender gender){
        String res = "Пол: ";
        if (Gender.valueOf("м") == gender.Male){
            res += "мужской";
        }

        if (Gender.valueOf("ж") == gender.Female) {
            res += "женский";
        }
        return res;
    }
}
