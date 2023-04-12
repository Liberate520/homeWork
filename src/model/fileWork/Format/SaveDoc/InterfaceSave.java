package model.fileWork.Format.SaveDoc;

import java.io.IOException;

public interface InterfaceSave<T>
{
    void write(T t) throws IOException, ClassNotFoundException;
}
