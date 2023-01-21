package homeWork.src.finalProjectDiary.file;

import homeWork.src.finalProjectDiary.model.Diary;
import homeWork.src.finalProjectDiary.presenter.Presenter;

public class Service {

    private final Writable writable;
    private Presenter presenter;

    private String message;

    private final String filename;

    public Service(Writable writable, String filename) {
        this.writable = writable;
        this.filename = filename;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    /*
        сохранить Diary
         */
    public void saveDiary(Diary diary) {
        try {
            writable.save(diary);
            presenter.showMessage(String.format("Diary сохранён в файле %s", filename));
        } catch (Exception ex) {
            presenter.showMessage("Что-то пошло не так" + ex.getMessage());
        }
    }

    /*
    прочитать Diary
     */
    public Diary readDiary() {
        if (writable != null) {
            try {
// если Diary ещё не существует, то создаём новый и возвращаем
                if (writable.read() == null) {
                    presenter.showMessage("Diary в файле нет! Создаём новый Diary.");
                    return new Diary();
                } else {
                    presenter.showMessage(String.format("Diary загружен из файла %s", filename));
                    return (Diary) writable.read();
                }
            } catch (Exception ex) {
                presenter.showMessage("Что-то пошло не так" + ex.getMessage());
            }
        } else {
            presenter.showMessage("Файл не загружен!");
            return null;
        }
        return null;
    }
}
