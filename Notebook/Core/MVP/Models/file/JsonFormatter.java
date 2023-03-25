package notebook.core.mvp.models.file;

import notebook.core.essence.Recording;

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
