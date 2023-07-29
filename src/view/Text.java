package view;

public abstract class Text {
    public static void MainMenu(){
        System.out.println("1. Watch the tree; \n" +
                "2. Add person; \n" +
                "3. Sort by name; \n" +
                "4. Sort by age;\n" +
                "5. Write tree to database; \n" +
                "6. Read tree from database; \n" +
                "7. Exit.");
    }
    public static void inputOrganismType(){
        System.out.println("Input whom you want to add: dog or human?\n");
    }
    public static void inputName(){
        System.out.println("Input name: \n");
    }
    public static void inputBirthday(){
        System.out.println("Input birthday. Format: 1990-12-9 (YYYY-MM-DD)\n");
    }
    public static void inputSex(){
        System.out.println("Input sex: male or female?\n");
    }
    public static void sortingComplete(){
        System.out.println("Sorting complete.");
    }
}
