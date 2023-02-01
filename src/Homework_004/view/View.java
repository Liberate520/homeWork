package Homework_004.view;

import java.io.IOException;

import Homework_004.model.*;
import Homework_004.controller.Controller;


public interface View {
    void setController(Controller controller);
    void start() throws ClassNotFoundException, IOException;
    //void returnToView(FamilyTree familyTree);
    void answer(Object obj);
}
