package DZ5_7.MVP;

import java.util.Scanner;

import DZ5_7.Models.TypeGender;
import DZ5_7.Models.TypeCommunication;
import DZ5_7.Structure.FamilyTree;

public class View {

    public void print(FamilyTree familyTree) {
        System.out.println("Фамильное древо (список):");
        System.out.println(familyTree);
    }

    public String createData() {
        String data;
        Scanner in = new Scanner(System.in, "Cp866");
        data = in.next();
        return data;
    }

    public TypeGender createGender() {
        int n = 1;
        Scanner in = new Scanner(System.in);
        for (TypeGender typeGender : TypeGender.values()) {
            System.out.println(n++ + " " + typeGender);
        }
        while (true) {
            String num = in.next().toString();
            if (num.equals("1")) {
                return TypeGender.Male;
            }
            if (num.equals("2")) {
                return TypeGender.Female;
            } else {
                System.out.println("Неверные данные. Повторите.");
            }
        }
    }

    public TypeCommunication createTypeCommunication() {
        int n = 1;
        Scanner in = new Scanner(System.in);
        for (TypeCommunication typeCommunication : TypeCommunication.values()) {
            System.out.println(n++ + " " + typeCommunication);
        }
        while (true) {
            String num = in.next().toString();
            if (num.equals("1")) {
                return TypeCommunication.Father;
            }
            if (num.equals("2")) {
                return TypeCommunication.Mother;
            }
            if (num.equals("3")) {
                return TypeCommunication.Son;
            }
            if (num.equals("4")) {
                return TypeCommunication.Daughter;
            } else {
                System.out.println("Неверные данные. Повторите.");
            }
        }
    }
}