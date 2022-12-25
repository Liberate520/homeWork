
import java.io.IOException;
import java.util.List;

public interface File_interface {
    List<Human> read_files() throws IOException, ClassNotFoundException;

    void write_files(List<Human> homo) throws IOException;

}

