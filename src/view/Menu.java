package view;

import controller.Controller;

public class Menu {

    private static UserInputFromConsole scan = new UserInputFromConsole();
    private static Controller controller = new Controller();

    private static String userSelect = "EMPTY";

    public static void Start(){

        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scan.inputKey(TextsMenu.inviteMenu);
            controller.setUserSelect(userSelect);
            controller.doSomething();           
        }
        sayGoodbye();
    }

    private static void sayGoodbye(){
        scan.input.close();
        System.out.println("Пока!");
    }

    public static String getName(){
        String name = scan.inputKey(TextsMenu.inviteName);
        return name;
    }

    public static String getAge(){
        String age = scan.inputKey(TextsMenu.inviteAge);
        return age;
    }

    public static String getId(){
        String id = scan.inputKey(TextsMenu.inviteId);
        return id;
    }

    public static String getIdTo(){
        String id = scan.inputKey(TextsMenu.inviteIdTo);
        return id;
    }

    public static String getIdRelation(){
        String id = scan.inputKey(TextsMenu.inviteReletionId);
        return id;
    }

}
