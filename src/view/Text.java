package view;

public abstract class Text {

    public static void inputOrganismType(){
        System.out.println("Input whom you want to add: dog or human?\n");
    }
    public static void inputName(){
        System.out.println("Input name: \n");
    }
    public static void inputBirthday(){
        System.out.println("Input birthday. Format: 1990-12-09 (YYYY-MM-DD)\n");
    }
    public static void inputSex(){
        System.out.println("Input sex: male or female?\n");
    }
    public static void sortingComplete(){
        System.out.println("Sorting complete.");
    }
    public static void setSpouseHusband(){
        System.out.println("Select husband (male)");
    }
    public static void setSpouseWife() {
        System.out.println("Select wife (female)");
    }

    public static void setChildParent() {
        System.out.println("Select parent");
    }

    public static void setChildChild() {
        System.out.println("Select child");
    }

//    public static void getInfoCreation() {
//        System.out.println("Whom you want to create?" +
//                "1. Human;" +
//                "2. Dog\n");
//    }
}
