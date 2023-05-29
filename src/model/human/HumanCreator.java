package model.human;
import java.util.Scanner;

public class HumanCreator {
    private final Scanner scanner;

    public HumanCreator() {
        this.scanner = new Scanner(System.in);
    }

    public Human createNewHuman(Gender gender, String name, String lastName, Integer age ) {
        return new Human(gender, name, lastName, age);
    }
}
