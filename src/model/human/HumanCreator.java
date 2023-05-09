package model.human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HumanCreator {
    private final String separator;
    private final Scanner scanner;

    public HumanCreator() {
        this.separator = "/";
        this.scanner = new Scanner(System.in);
    }

    public Human createNewHuman() {
        String[] split = getGeneralInfo().split(separator);
        return new Human(Gender.valueOf(split[0]), split[1], split[2], Integer.parseInt(split[3]));
    }

    private String getGeneralInfo() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(Gender.values()[getGender()]).append(separator);
        strBuilder.append(getString("Enter name: ")).append(separator);
        strBuilder.append(getString("Enter lastname: ")).append(separator);
        strBuilder.append(getAge());

        return strBuilder.toString();
    }

    private String getAge() {
        String answer = "a";
        while (!checkIsDigit(answer)) {
            answer = getString("Enter age: ");
        }
        return answer;
    }

    private boolean checkIsDigit(String answer) {
        String numbers = "1234567890";
        for (String s : answer.split("")) {
            if (!numbers.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private int getGender() {
        List<String> numbers = new ArrayList<>(Arrays.asList("1,2".split(",")));
        int answer = 0;
        while (answer < 1 || answer > 2) {
            System.out.println("Choose gender: ");
            System.out.println("[1] - male\n[2] - female");
            String temp = scanner.nextLine();
            if (temp.length() == 1 && numbers.contains(temp)) {
                answer = Integer.parseInt(temp);
            }
        }
        return answer % 2;
    }

    private String getString(String message) {
        System.out.println(message);
        return (scanner.nextLine());
    }
}
