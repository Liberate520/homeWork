namespace GeekBrains;

public class UserInputFromConsole {

    public String inputKey(String invate){

        String key;
        Console.WriteLine(invate);
        key = Console.ReadLine();

        return key;
    }
}

