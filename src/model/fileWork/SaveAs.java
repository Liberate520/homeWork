package model.fileWork;

import java.io.IOException;

public interface SaveAs<T> 
{
    int SaveFormat(T t) throws ClassNotFoundException, IOException;   
}

