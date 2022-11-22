package generator;

import classes.Parent;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    /**
     * файлы со списками имён
     */
    public static Random rand = new Random();
    private static final String maleNames = "src/generator/MaleNames.txt";
    private static final String femaleNames = "src/generator/FemaleNames.txt";
    private static final String familyNames = "src/generator/FamilyNames.txt";

    /**
     * сам генератор с проверками на гендер
     */
    public static Parent create(String familyName) {
        Parent newOne = new Parent();
        switch (rand.nextInt(2)) {
            case 1 -> {
                newOne.setGender(1);
                newOne.setName(createParam(maleNames));
            }
            case 0 -> {
                newOne.setGender(0);
                newOne.setName(createParam(femaleNames));
            }
        }
        newOne.setFamilyname(familyName);
        return newOne;
    }

    public static Parent create() {
        String familyName = createParam(familyNames);
        return create(familyName);
    }

    /**
     * считыватель файлов. Рандомно вытаскивает значение
     *
     * @param file - источник
     * @return - строка из файла
     */
    private static String createParam(String file) {
        String param = "";
        try {
            FileReader data = new FileReader(file);
            Scanner scan = new Scanner(data);
            for (int i = 0; i < rand.nextInt(0, 100); i++) {
                param = scan.nextLine();
            }
            data.close();
            scan.close();
        } catch (IOException e) {
            System.out.printf("File %s not found", file);
        }
        return param;
    }
}
