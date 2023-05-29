package view.commands;

import model.human.Gender;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddPerson extends CommandsAbstract{
    private final String separator;

    public AddPerson(View view) {
        super(view, 1, "Add person");
        this.separator = "/";
    }

    @Override
    public void execute() {
        String[] human = getGeneralInfo().split(separator);
        this.getView().getPresenter().addNewHumanToFamilyTree(
                Gender.valueOf(human[0]), human[1], human[2], Integer.parseInt(human[3]));
    }

    private String getGeneralInfo() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(Gender.values()[getGender()]).append(separator);
        strBuilder.append(getString("Enter name: ")).append(separator);
        strBuilder.append(getString("Enter lastname: ")).append(separator);
        strBuilder.append(getAge());

        return strBuilder.toString();
    }

    private int getGender() {
        List<String> numbers = new ArrayList<>(Arrays.asList("1,2".split(",")));
        int answer = 0;
        while (answer < 1 || answer > 2) {
            System.out.println("Choose gender: ");
            System.out.println("[1] - male\n[2] - female");
            String temp = super.getScanner().nextLine();
            if (temp.length() == 1 && numbers.contains(temp)) {
                answer = Integer.parseInt(temp);
            }
        }
        return answer % 2;
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

    private String getString(String message) {
        System.out.println(message);
        return (super.getScanner().nextLine());
    }
}
