package view;

public class Menu {

    private static UserInputFromConsole scan = new UserInputFromConsole();
    private static String userSelect = "EMPTY";
    private static ToController toController = new ToController();

    public static void Start(){

        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scan.inputKey(TextsMenu.inviteMenu);
            toController.doSomething(userSelect);           
        }
        scan.input.close();
        System.out.println("Пока!");
    }
}
