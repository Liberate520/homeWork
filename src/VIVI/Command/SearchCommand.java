package VIVI.Command;

import Homework_7.Designer_Human;
import VIVI.Search.ISearch;
import VIVI.Search.SearchHuman;

public class SearchCommand implements ICommand{
    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();

        ISearch search = new SearchHuman();
        search.search(designer_human.getHumans());
    }
    //Тут добавил один класс для наглядности, остальные на отдельные кнопки.
}
