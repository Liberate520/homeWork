package model.fileWork.Format.ReadDoc;

import java.io.IOException;

public interface interfaceRead<T>
{
    String read(T t) throws IOException, ClassNotFoundException;
}
