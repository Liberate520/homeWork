package Notebook.Core.MVP.Models.FileReaderr;

import java.util.ArrayList;
import java.util.List;

import Notebook.Core.Essence.Recording;

public class RecordingConverter {
    public static List<Recording> convert(List<String> lines) {
        List<Recording> recordings = new ArrayList<>();
        for (String string : lines) {
            string = (string.replace("{", "")
                    .replace("}", "")
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\"", ""))
                    .trim();
            String[] temp = string.split(":");
            recordings.add(new Recording(temp[0], temp[1]));                
        }
        return recordings;
    }
}