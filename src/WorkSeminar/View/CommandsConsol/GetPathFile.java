package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class GetPathFile extends Commands {
    public GetPathFile(View view) {
        super("Показать текущий путь к файлу ", view);
    }

    public void execute() {
        getView().getPathFile();
    }
}