package GenerationTree.ui.MenuRender;

import java.util.Scanner;

public class ConsoleManager {

    private Scanner _cs;
    private StringBuilder _frame = new StringBuilder();
    private Boolean _onLog;
    private JFrameKeyEvent keyEvent;

    public ConsoleManager() {
        this("", false);
    }

    public ConsoleManager(String charsetName) {
        this(charsetName, false);
    }

    public ConsoleManager(Boolean onLog) {
        this("", onLog);
    }

    public ConsoleManager(String charsetName, Boolean onLog) {
        this._onLog = onLog;
        setTextCode(charsetName);
        this.keyEvent = new JFrameKeyEvent();
    }

    public String getFrameText(Boolean toDelete) {
        var text = _frame.toString();
        if (toDelete) {
            _frame.delete(0, _frame.length());
        }
        return text;
    }

    public int getKeyEvent() {
        return this.keyEvent.Start();
    }

    public String inputText(String message) {
        System.out.print(message);
        var text = _cs.nextLine();
        consoleReading(message + text + "\n");
        return text;
    }

    public void printText() {
        printText("", "\n");
    }

    public void PrintText(String text) {
        printText(text, "\n");
    }

    public void printText(String text, String end) {
        consoleReading(text + end);
        System.out.print(text + end);
    }

    public <T> void printArray(T[] array) {
        var output = new StringBuilder();
        output.append("[ ");
        for (var item : array) {
            output.append(String.format("%s, ", item));
        }
        output.append("\b\b ]");
        var text = output.toString();
        consoleReading(text);
        System.out.print(text);
    }

    public void consoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void hideCursor(boolean isHidden) {
        if (isHidden) {
            System.out.print("\033[?25l");
        } else {
            System.out.print("\033[?25h");
        }
    }

    private void setTextCode(String charsetName) {
        if (charsetName.isEmpty()) {
            charsetName = "cp866";
        }
        _cs = new Scanner(System.in, charsetName);
    }

    private void consoleReading(String text) {
        if (_onLog) {
            _frame.append(text);
        }
    }
}