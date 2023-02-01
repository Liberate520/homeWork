package Homework_006.view;

import java.io.IOException;
import java.util.ArrayList;

import Homework_006.controller.Controller;


public interface View {
    void setController(Controller controller);
    void start() throws ClassNotFoundException, IOException;
    void answer(Object obj);
    void answerNoData();
    ArrayList<String> createNodeForm();
    int[] setParentForm();
    void answerIdAbsent(int id);
    Integer requestChildId();
    Integer requestParentId();
    Integer requestNodeId();
}
