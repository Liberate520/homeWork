package org.example.presenter;

import org.example.gui.View;
import org.example.model.communication.SystemModelCommunication;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {
    private View view;
    private final SystemModelCommunication systemModelCommunication;


    public Presenter(View view, SystemModelCommunication sc) {
        this.systemModelCommunication = sc;
        this.view = view;
        this.view.setPresenter(this);
    }

    public ArrayList<Map<String,String>> setCommandFromView(String command, String text, Integer index){
        if (command.equals("1") && text.equals("")){
            return systemModelCommunication.getAListPrintHuman();
        } else if (command.equals("addH")) {
            systemModelCommunication.addHuman(text);
        } else if (command.equals("EditingName")) {
            systemModelCommunication.setNameHuman(text, index);
        } else if (command.equals("gender")){
            systemModelCommunication.setGenderHuman(text, index);
        } else if (command.equals("dateB")) {
            systemModelCommunication.setDateBirth(text, index);
        } else if (command.equals("dateD")) {
            systemModelCommunication.setDateDeath(text, index);
        } else if (command.equals("mother")){
            systemModelCommunication.setMother(Integer.parseInt(text) - 1, index);
        } else if (command.equals("father")){
            systemModelCommunication.setFather(Integer.parseInt(text) - 1, index);
        } else if (command.equals("children")){
            systemModelCommunication.setChildren(Integer.parseInt(text) - 1, index);
        } else if (command.equals("brothersAndSisters")){
            systemModelCommunication.setBrothersAndSisters(Integer.parseInt(text) - 1, index);
        } else if (command.equals("remove")) {
            systemModelCommunication.removeHuman(index);
        }
        return null;
    }

}
