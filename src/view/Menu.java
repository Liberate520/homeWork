package view;


public class Menu {

    private static final UserInputFromConsole scan = new UserInputFromConsole();
    private static String userSelect = "EMPTY";
    private static final ToPresenter toPresenter = new ToPresenter();

    public static void Start(){

        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scan.inputKey(TextsMenu.inviteMenu);
            toPresenter.doSomething(userSelect);           
        }
        scan.input.close();
        System.out.println("Досвидание!");
    }
}
