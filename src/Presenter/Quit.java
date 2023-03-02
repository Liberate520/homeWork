package src.Presenter;

public class Quit extends Command{


    public Quit(Presenter presenter) {
        super(presenter);
    }

    @Override
    public String description() {
        return "Quit the program";
    }

    @Override
    public void execute() {
        System.out.println("Quit, files are closed");
    }
}
