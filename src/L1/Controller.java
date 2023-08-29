package L1;

import java.io.IOException;
import java.util.Scanner;

import static L1.FindPersonOrChildren.findChildrenOfPerson;
import static L1.FindPersonOrChildren.findInfoAboutPerson;

public class Controller {

    public void userInput(Family_tree people) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("///////////////////////////////////////" +
                    "\nmenu: 1 - print all people, 2 - find person info, 3 - find children of person, 11 - load people from file, " +
                    "12 - save people");
            String s = sc.nextLine();
            int userInp = Integer.parseInt(s);
            switch (userInp) {
                case (1):
                    System.out.println(people);
                    break;
                case (2):
                    findInfoAboutPerson(people);
                    break;
                case (3):
                    findChildrenOfPerson(people);
                    break;
                case (11):
                    FileHandler loadInfo = new FileHandler();
                    loadInfo.loadPeople(people);
                    break;
                case (12):
                    FileHandler saveInfo = new FileHandler();
                    saveInfo.savePeople(people);

            }
        }
    }

}
