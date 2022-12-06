public interface View {
    void setController(Controller controller);
    void start();
    int printMenu(String text);
    String scanOne(String s);
    String scanOther(String s);

    void printStr(String s);
}
