import java.io.IOException;

public class ComandExit implements Option {

    @Override
    public String dicription() {
        String exit = "Выход";
        return exit;
    }

    @Override
    public void execute() throws IOException {
    }

}
