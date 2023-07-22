package faminly_tree.view.examination;

public interface Examination {
    int itsNumber(String line);

    boolean dayExamination(int day, int month, int year);

    boolean monthExamination(int month);

    boolean yearExamination(int year);

}
