public class View {

    public double getValue(string title) {
        Console.WriteLine(title);
        double value = Convert.ToDouble(Console.ReadLine());
        return value;
    }

    public string getAction(string title){
        Console.WriteLine(title);
        string action = Console.ReadLine();
        return action;
    }

}