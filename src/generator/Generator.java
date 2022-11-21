package generator;

import classes.Human;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    /**
     * файлы со списками имён
     */
    public static Random rand = new Random();
    private static String maleNames = "src/generator/MaleNames.txt";
    private static String femaleNames = "src/generator/FemaleNames.txt";
    private static String familyNames = "src/generator/FamilyNames.txt";

    /**
     * сам генератор с проверками на гендер
     */
    public static Human create(String familyName) throws IOException {
        Human newOne = new Human();
        if (rand.nextInt(2) == 1) {
            newOne.setGender(1);
            newOne.setName(createParam(maleNames));
        } else {
            newOne.setGender(0);
            newOne.setName(createParam(femaleNames));
        }
        newOne.setFamilyname(familyName);
        return newOne;
    }

    public static Human create() throws IOException {
        String familyName = createParam(familyNames);
        return create(familyName);
    }

    /**
     * считыватель файлов. Рандомно вытаскивает значение
     *
     * @param file - источник
     * @return - строка из файла
     */
    private static String createParam(String file) throws IOException {
        String param = "";
        FileReader data = new FileReader(file);
        Scanner scan = new Scanner(data);
        for (int i = 0; i < rand.nextInt(0, 100); i++) {
            param = scan.nextLine();
        }
        data.close();
        scan.close();
        return param;
    }
}
