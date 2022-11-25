package Tree;

public record Human(String getFirstName,
                        String getSurName,
                        String birthDate,
                        Gender gender) {}




//public class Human1 {
//    private final String fName;
//    private final String sName;
//    private final String bDate;
//    private final Gender gender;
//
//
//    public Human(String firstName, String surName, String birthDate, Gender gender) {
//        this.fName = firstName;
//        this.sName = surName;
//        this.bDate = birthDate;
//        this.gender = gender;
//    }
//
//    public String getFirstName() {
//        return this.fName;
//    }
//
//    public String getSurName() {
//        return this.sName;
//    }
//
//    public String getBirthDate() {
//        return this.bDate;
//    }
//
//    public Gender getGender() {
//        return this.gender;
//    }
//
//
//    @Override
//    public String toString() {
//        return String.format("%s %s %s %s", fName, sName, bDate, gender);
//    }
//}