package Notebook.Core.Models;

public abstract class Recording implements Comparable<Recording> {
    private String title;
    private String  recording;

    public Recording(String title, String recording) {
        this.title = title;
        this.recording = recording;
    }

    @Override
    public int compareTo(Recording o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Recording t = (Recording)obj;
        return this.title == t.title;
    }
}
