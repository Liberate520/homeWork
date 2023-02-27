package api;

import java.io.IOException;

public interface Service
{
    String get(String city) throws IOException, ClassNotFoundException;
}
