package homeWork.src.finalProjectDiary.ui;

import homeWork.src.finalProjectDiary.model.Day;
import homeWork.src.finalProjectDiary.model.Diary;
import homeWork.src.finalProjectDiary.model.Record;
import homeWork.src.finalProjectDiary.presenter.Presenter;

public interface View {
    Diary getDiary();
    Presenter getPresenter();
    void start();
    void printDiary(Diary diary);
    void printDay(int dayNum, Day day);
    void printRecord(String findedRecord);
    Record getRecord(boolean full);
    int getDay();
    void showMessage(String message);

}
