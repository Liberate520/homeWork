package GenerationTree.ui.MenuRender;

import java.util.Scanner;

public class ConsoleManager {

    private Scanner cs;
    private StringBuilder frame = new StringBuilder();
    private Boolean onLog;
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
        this.onLog = onLog;
        setTextCode(charsetName);
        this.keyEvent = new JFrameKeyEvent();
    }

    public String getFrameText(Boolean toDelete) {
        var text = this.frame.toString();
        if (toDelete) {
            this.frame.delete(0, this.frame.length());
        }
        return text;
    }

    public int getKeyEvent() {
        return this.keyEvent.start();
    }

    public String inputText(String message) {
        System.out.print(message);
        var text = this.cs.nextLine();
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
        this.cs = new Scanner(System.in, charsetName);
    }

    private void consoleReading(String text) {
        if (this.onLog) {
            this.frame.append(text);
        }
    }
}