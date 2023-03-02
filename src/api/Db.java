package api;

import java.io.IOException;

public interface Db
{
    String get(String city) throws IOException, ClassNotFoundException;
}
