package view;

public class ConsoleView implements ConsoleViewable{

    @Override
    public void print(String str){
        System.out.print(str);
    }
}
