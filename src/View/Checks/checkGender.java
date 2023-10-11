package View.Checks;

import Model.obj.Gender;

public class checkGender {
    public static Gender checkGender(String str){
        try {
            if (str.equals("Male")) {
                return Gender.MALE;
            } else {
                return Gender.FEMALE;
            }
        } catch (Exception e) {
            System.out.println("Некорректные данные " + e);
        }
        return Gender.FEMALE;
    }
}
