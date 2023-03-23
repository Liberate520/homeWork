package Notebook.Core.MVP.Models.FileWriterr;

import Notebook.Core.Essence.Recording;

public class JsonFormatter {
    public static String toJson(Recording recording) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"").append(recording.getTitle()).append("\"");
        sb.append(":");
        sb.append("\"").append(recording.getRecording()).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
