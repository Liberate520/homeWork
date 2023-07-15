package GenerationTree.ui;

import java.util.Scanner;

public class ConsoleManager {

    public ConsoleManager() {
        setTextCode("");
    }

    public ConsoleManager(String charsetName) {
        setTextCode(charsetName);
    }

    public ConsoleManager(Boolean onLog) {
        this._onLog = onLog;
        setFullSettings("");
    }

    public ConsoleManager(String charsetName, Boolean onLog) {
        this._onLog = onLog;
        setFullSettings(charsetName);
    }

    private Scanner _cs;
    private StringBuilder _frame = new StringBuilder();
    private Boolean _onLog = false;

    public String getFrameText(Boolean toDelete) {
        var text = _frame.toString();
        if (toDelete) {
            _frame.delete(0, _frame.length());
        }
        return text;
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

    private void setFullSettings(String charsetName) {
        setTextCode(charsetName);
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

    public static void hideCursor(boolean isHidden) {
        if (isHidden) {
            System.out.print("\033[?25l");
        } else {
            System.out.print("\033[?25h");
        }
    }

    public static String compressString(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prevChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                result.append(prevChar).append(count);
                prevChar = currentChar;
                count = 1;
            }
        }
        result.append(prevChar).append(count);
        return result.toString();
    }
}