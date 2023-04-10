package view;
import java.io.IOException;

import model.FamilyTree;
import presenter.Presenter;

public interface View<T> 
{
    T StartProgram(T t) throws ClassNotFoundException, IOException;
    void print(T t);
    void setPresenter(Presenter presenter);
    
}
