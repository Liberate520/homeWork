package FamTree.UI;

import FamTree.Presenter.Presenter;
public interface View {
    void setPresenter(Presenter presenter);
    void Start();
    void Print(String text);
    String scan();
}
