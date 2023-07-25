import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface IStream {
    void save(DataOutputStream stream_out) throws IOException;
    void load(DataInputStream stream_in) throws IOException;
}
