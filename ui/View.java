package homeWork3.ui;

import homeWork3.viewer.ReView;

public interface View {
    void setViewer(ReView viewer);

    void start();

    void print(String text);

    String scan();
}