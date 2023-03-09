package ui;

import presenter.Presenter;

public interface View {
    public void setPresenter(Presenter presenter);

    public void start();

    public void print(String text);

}
