package service.IO;

import java.io.IOException;

public interface IO {
    <E> void toFile(E element, String path);

    Object fromFile(String path);
}
