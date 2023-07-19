package faminly_tree.view.examination;

public interface Examination {
    int itsNumber(String line);
    boolean rightDate();
    boolean rightGender(String sex);
    public boolean dayExamination(int day, int month, int year);
    public boolean monthExamination(int month);
    public boolean yearExamination(int year);

}
