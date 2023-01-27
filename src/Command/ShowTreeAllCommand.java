package Command;

import Homework_6.Designer_Human;
import Print.IPrintList;
import Print.PrintListInFor;

import java.util.List;

public class ShowTreeAllCommand implements  ICommand{
    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();
        IPrintList print3 = new PrintListInFor();
        print3.printList((List<Designer_Human>) designer_human);
    }
    //Перегрузил одни методом
}
