package saveload;

import java.io.IOException;

public interface SaveTo {
    public void saveTo(Object obj, String path) throws IOException;
}
