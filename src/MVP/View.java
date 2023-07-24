package MVP;

import java.util.List;

public interface View {
    void showMenu(String menu);
    void printObjects(List objects);
    String getInput(String prompt);
    void print(String text);
}
