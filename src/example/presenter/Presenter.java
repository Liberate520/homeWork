package org.example.presenter;



import org.example.model.communication.Service;
import org.example.gui.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Presenter {
    private final Service service;


    public Presenter(View view, Service sc) {
        this.service = sc;
        view.setPresenter(this);
    }

    public ArrayList<Map<String,String>> getPrintList(){
        return service.getAListPrintHuman();
    }

    public  void setCommandFromView(String command, String text, Integer index) throws IOException {
        service.communicator(command, text, index);
    }



}
