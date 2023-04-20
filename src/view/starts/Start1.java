package view.starts;
import view.choice.ChoiceInterface;
import view.choice.ItemStart;
public class Start1 implements StartChoice {
    @Override
    public int start1()
    {
        ChoiceInterface selectItem = new ItemStart();
        selectItem.selectItem();
        int choice = ReadNumber.readNumberConsole();

        while(choice < 1 || choice > 7)
        {
            System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
            selectItem.selectItem();
            choice = ReadNumber.readNumberConsole();
        }
        return choice;
    }

}

