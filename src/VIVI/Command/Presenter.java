package VIVI.Command;

public class Presenter {


    ICommand AddHumanCommand;
    ICommand AddСhildrenCommand;
    ICommand AddParentsCommand;
    ICommand SearchCommand;
    ICommand ShowTreeAllCommand;
    ICommand SortingCommand;

    public Presenter(ICommand addHumanCommand,ICommand addCildrenCommand , ICommand addParentsCommand,
                     ICommand searchCommand, ICommand showTreeAllCommand, ICommand sortingCommand) {
        this.AddHumanCommand = addHumanCommand;
        this.AddСhildrenCommand = addCildrenCommand;
        this.AddParentsCommand = addParentsCommand;
        this.SearchCommand = searchCommand;
        this.ShowTreeAllCommand = showTreeAllCommand;
        this.SortingCommand = sortingCommand;
    }

    public void AddHumanCommandRecord() {
        AddHumanCommand.execute();
    }

    public void AddСhildrenCommandRecord() {
        AddСhildrenCommand.execute();
    }


    public void AddParentsCommandRecord() {
        AddParentsCommand.execute();
    }

    public void SearchCommandRecord() {
        SearchCommand.execute();
    }

    public void ShowTreeAllCommandRecord() {
        ShowTreeAllCommand.execute();
    }

    public void SortingCommand() {
        SortingCommand.execute();
    }
}

