package Notebook.Core.Models;

public class Recording implements Comparable<Recording> {
    private String title;
    private String  recording;

    public Recording(String title, String recording) {
        this.title = title;
        this.recording = recording;
    }

    @Override
    public int compareTo(Recording o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Recording t = (Recording)obj;
        return this.title == t.title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    public void printRecord(){
        System.out.println("\t" +  getTitle() + ":\n" + "" + getRecording() + "\n");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
