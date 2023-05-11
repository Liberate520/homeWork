package OOP_Prodject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View<T extends Character> {
    public ArrayList<String> data_import() {
        ArrayList<String> data = new ArrayList<String>();
        String race = raceChoice();
        data.add(race);
        String prof = professionChoice();
        data.add(prof);
        String name = nameChoice();
        data.add(name);
        List<String> stats = statsDistribution();
        for (String stat : stats) {
            data.add(stat);
        }

        return data;

    }

    private String raceChoice() {
        Boolean flag = true;
        Scanner scan = new Scanner(System.in);
        String race = "";
        while (flag) {
            System.out
                    .println("Выберете персонажа:\n 1) Эльф\n 2) Гном\n 3) Человек\n 4) Гоблин\n (Введите его номер)");
            int race_number = Integer.parseInt(scan.nextLine());

            if (race_number == 1) {

                race = "Elf";
                flag = false;

            }

            else if (race_number == 2) {
                race = "Dwarf";
                flag = false;
            }

            else if (race_number == 3) {
                race = "Human";
                flag = false;
            }

            else if (race_number == 4) {
                race = "Goblin";
                flag = false;
            } else {
                System.out.println("Попробуйте снова");
            }

        }
        // scan.close();
        return race;

    }

    private String professionChoice() {
        Boolean flag = true;
        Scanner scan = new Scanner(System.in);
        String prof = "";
        while (flag) {
            System.out.println(
                    "Выберете класс персонажа:\n 1) Воин\n 2) Убийца\n 3) Танк\n 4) Маг\n 5) Целитель\n 6) Варвар\n (Введите его номер)");
            int class_number = Integer.parseInt(scan.nextLine());

            if (class_number == 1) {

                prof = "Warrior";
                flag = false;
            }

            else if (class_number == 2) {
                prof = "Killer";
                flag = false;
            }

            else if (class_number == 3) {
                prof = "Tank";
                flag = false;
            }

            else if (class_number == 4) {
                prof = "Magician";
                flag = false;
            }

            else if (class_number == 5) {
                prof = "Healer";
                flag = false;
            }

            else if (class_number == 6) {
                prof = "Barbarian";
                flag = false;
            } else {
                System.out.println("Попробуйте снова");
            }

        }

        // scan.close();
        return prof;
    }

    private String nameChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name = scan.nextLine();
        // scan.close();
        return name;
    }

    private ArrayList<String> statsDistribution() {
        Boolean flag = true;
        int total = 10;
        Scanner scan = new Scanner(System.in);
        ArrayList<String> stats = new ArrayList<String>();
        System.out.println("Раскидайте дополнительные 10 очков характеристик, но не более 3 на каждую");
        int max = Math.min(total, 3);
        while (flag) {
            System.out.println("Здоровье");
            String stat = scan.nextLine();
            if (Integer.parseInt(stat) <= max) {
                stats.add(stat);
                total = total - Integer.parseInt(stat);
                flag = false;
                continue;
            } else {
                System.out.println("Введено слишком много либо вообще что-то не то O_o, попробуйте снова");
            }
        }
        flag = true;
        max = Math.min(total, 3);
        while (flag) {
            System.out.println("Атака");
            String stat = scan.nextLine();
            if (Integer.parseInt(stat) <= max) {
                stats.add(stat);
                total = total - Integer.parseInt(stat);

                flag = false;
                continue;
            } else {
                System.out.println("Введено слишком много либо вообще что-то не то O_o, попробуйте снова");
            }

        }
        flag = true;
        max = Math.min(total, 3);
        while (flag) {
            System.out.println("Скорость");
            String stat = scan.nextLine();
            if (Integer.parseInt(stat) <= max) {
                stats.add(stat);
                total = total - Integer.parseInt(stat);

                flag = false;
                continue;
            } else {
                System.out.println("Введено слишком много либо вообще что-то не то O_o, попробуйте снова");
            }

        }
        flag = true;
        max = Math.min(total, 3);
        while (flag) {
            System.out.println("Сопротивляемость");
            String stat = scan.nextLine();
            if (Integer.parseInt(stat) <= max) {
                stats.add(stat);
                total = total - Integer.parseInt(stat);

                flag = false;
                continue;
            } else {
                System.out.println("Введено слишком много либо вообще что-то не то O_o, попробуйте снова");
            }

        }
        flag = true;
        max = Math.min(total, 3);
        while (flag) {
            System.out.println("Мана");
            String stat = scan.nextLine();
            if (Integer.parseInt(stat) <= max) {
                stats.add(stat);
                total = total - Integer.parseInt(stat);

                flag = false;
                continue;
            } else {
                System.out.println("Введено слишком много либо вообще что-то не то O_o, попробуйте снова");
            }

        }
        return stats;
    }

    public void partyInfo(Party<Character> party) {
        for (Character c : party) {
            c.toString();
        }
    }

}
