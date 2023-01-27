import java.io.IOException;

public interface Option {
    String dicription();

    void execute() throws IOException, ClassNotFoundException;

}
