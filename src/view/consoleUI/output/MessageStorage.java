package view.consoleUI.output;

import java.util.ArrayList;
import java.util.List;

public class MessageStorage {
    private List<String> messages;

    public MessageStorage() {
        messages = new ArrayList<>(){{
            add("Ошибка ввода");
        }};
    }


    public void clearMessages() {
        messages.clear();
    }


}

