package model;

public class Task extends Record implements DeadLine{
    private String deadline;//TODO -> datetime

    public Task(String text, String deadline) {
        super(text);
        this.deadline = deadline;
    }

    @Override
    public void setDate(String date) {
        this.deadline = date;
    }

    @Override
    public boolean isOverDate() {
        //TODO -> delta date
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s срок: %s \t%s \t", super.toString(), deadline, (isOverDate()) ? "просрочено" : "");
    }
}
