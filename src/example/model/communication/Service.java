package org.example.model.communication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public interface Service {

    void communicator(String command, String text, Integer index) throws IOException;
    ArrayList<Map<String, String>> getAListPrintHuman();




}
