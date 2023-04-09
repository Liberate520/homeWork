package view;
import java.io.IOException;

import model.FamilyTree;
import presenter.Presenter;

public interface View 
{
    FamilyTree StartProgram(FamilyTree familyTree) throws ClassNotFoundException, IOException;
    void print(FamilyTree familyTree);
    void setPresenter(Presenter presenter);
    
}
