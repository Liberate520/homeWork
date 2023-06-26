package MenuRender;

import java.util.Scanner;

import Controllers.LoggerController;

public class ConsoleManager {

    public ConsoleManager() {
        SetTextCode("");
    }

    public ConsoleManager(String charsetName) {
        SetTextCode(charsetName);
    }

    public ConsoleManager(Boolean onLog) {
        this._onLog = onLog;
        SetFullSettings("");
    }

    public ConsoleManager(String charsetName, Boolean onLog) {
        this._onLog = onLog;
        SetFullSettings(charsetName);
    }

    private Scanner _cs;
    private StringBuilder _frame = new StringBuilder();
    private LoggerController _lc = null;
    private Boolean _onLog = false;

    public String GetFrameText(Boolean toDelete) {
        var text = _frame.toString();
        if (toDelete) {
            _frame.delete(0, _frame.length());
            _lc.Log("END LOG.");
            _lc.Dispose();
        }
        return text;
    }

    public String InputText(String message) {
        System.out.print(message);
        var text = _cs.nextLine();
        ConsoleReading(message + text + "\n");
        return text;
    }

    public void PrintText() {
        PrintText("", "\n");
    }

    public void PrintText(String text) {
        PrintText(text, "\n");
    }

    public void PrintText(String text, String end) {
        ConsoleReading(text + end);
        System.out.print(text + end);
    }

    public <T> void PrintArray(T[] array) {
        var output = new StringBuilder();
        output.append("[ ");
        for (var item : array) {
            output.append(String.format("%s, ", item));
        }
        output.append("\b\b ]");
        var text = output.toString();
        ConsoleReading(text);
        System.out.print(text);
    }

    public int GetKeyEvent() {
        return KeyEventManager.Start();
    }

    public void ConsoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (_onLog) {
            _lc.Log("Clear console.");
        }
    }

    private void SetFullSettings(String charsetName) {
        SetTextCode(charsetName);
        _lc = _onLog ? new LoggerController(this.getClass().getName(), true) : null;
    }

    private void SetTextCode(String charsetName) {
        if (charsetName.isEmpty()) {
            charsetName = "cp866";
        }
        _cs = new Scanner(System.in, charsetName);
    }

    private void ConsoleReading(String text) {
        if (_onLog) {
            _frame.append(text);
            _lc.Log(text);
        }
    }

    public static void HideCursor(boolean isHidden) {
        if (isHidden) {
            System.out.print("\033[?25l");
        } else {
            System.out.print("\033[?25h");
        }
    }

    public static String СompressString(String input) {
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