package saveload;

import java.io.IOException;

public interface LoadFrom {
    public Object loadFrom(String path) throws IOException, ClassNotFoundException;
}
