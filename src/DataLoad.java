import java.io.IOException;

public interface DataLoad {
    Object loadData(String fileName) throws IOException, ClassNotFoundException;
}
