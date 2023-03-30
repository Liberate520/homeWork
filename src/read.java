import java.io.IOException;
import java.io.Serializable;

public interface read {
    public GeoTree read(Serializable ser) throws IOException, ClassNotFoundException;
}
