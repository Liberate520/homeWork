package view;

public class Menu {
    private static final UserInputFromConsole scan = new UserInputFromConsole();
    private static String Select = "EMPTY";
    private static final ToPresenter toPresenter = new ToPresenter();

    public static void Start(){

        while (!Select.equals("q")){
            Select = "EMPTY";
            Select = scan.inputKey(TextsMenu.Menu);
            toPresenter.doSomething(Select);
        }
        scan.input.close();
        System.out.println("Пока!");
    }
}
