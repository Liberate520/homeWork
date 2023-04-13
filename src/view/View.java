package view;
import java.io.IOException;

import model.FamilyTree.FamilyTree;
import presenter.Presenter;

public interface View<T, E> 
{
    void StartProgram() throws ClassNotFoundException, IOException;
    void print(T t);
    void setPresenter(Presenter presenter);
    
}
