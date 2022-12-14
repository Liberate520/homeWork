namespace GeekBrains;

public class Menu {

    private static UserInputFromConsole scan = new UserInputFromConsole();
    private static String userSelect = "EMPTY";
    private static ToPresenter toPresenter = new ToPresenter();

    public void Start(){

        while (userSelect != "q"){
            userSelect = "EMPTY";
            userSelect = scan.inputKey(TextsMenu.inviteMenu);
            toPresenter.doSomething(userSelect);           
        }
        Console.WriteLine("Пока!");
    }
}
