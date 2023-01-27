package VIVI.Command;

import Homework_6.Designer_Human;
import VIVI.Search.ISearch;
import VIVI.Search.SearchHuman;

import java.util.List;

public class SearchCommand implements ICommand{
    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();

        ISearch search = new SearchHuman();
        search.search((List<Designer_Human>) designer_human);
    }
    //Тут добавил один класс для наглядности, остальные на отдельные кнопки.
}
