package view.consoleUI.input;

import model.members.Gender;

import java.util.Scanner;

public class InputReader{
    private Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String inputLn(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Проверяет веденные пользователем данные, являются ли они целыми числами
     *
     * @param line входная строка
     * @return boolean
     */
    public boolean checkLineOnNumbers(String line) {
        return line.matches("[0-9]+");
    }

    public int checkDateOfBirth(String dateOfBirth) {
        return checkLineOnNumbers(dateOfBirth) ? Integer.parseInt(dateOfBirth) : -1;
    }

    public int inputDateOfBirth(String dateOfBirth) {
        String inputLine = inputLn(dateOfBirth);
        return checkLineOnNumbers(inputLine) ? Integer.parseInt(inputLine) : -1;
    }

    public String  nextLine() {
        return scanner.nextLine();
    }

    public Gender inputGender(String gender) {
        return Gender.fromStringValue(inputLn(gender));
    }

}

