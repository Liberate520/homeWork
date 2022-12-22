package view;


public class PrintView implements IViewable {
    @Override
    public void print(String str){
        System.out.print(str);
    }
}
