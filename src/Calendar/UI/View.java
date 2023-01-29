package Calendar.UI;

import Calendar.model.Day;
import Calendar.model.Diary;
import Calendar.model.Record;
import Calendar.presenter.Presenter;

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
