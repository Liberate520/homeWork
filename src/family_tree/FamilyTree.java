package family_tree;

import java.util.Scanner;

public class FamilyTree {
    static int population;
    static Scanner input = new Scanner(System.in);
    public static Human createTree() {

        System.out.print("Введите имя : ");
        String name = input.next();

        System.out.print("Является отцом/матерью (да - 1 или нет - 0) ");
        char m = input.next().charAt(0);
        boolean parents = m == '1';

        if(parents) {
            System.out.print("Введите имя второго родителя : ");
            String twoname = input.next();
            System.out.print("Сколько детей? ");
            int n = input.nextInt();
            if(n==0) {
                return new Human(name, parents, twoname);
            }
            Human[] children = new Human[n];
            for(int i=0;i<n;i++) {
                System.out.print("Ребёнок "+(i+1) + " ");
                children[i] = createTree();
            }
            return new Human(name, parents, twoname, children,(n));
        }
        else return new Human(name);
    }

    public void display(Human root, int tabs) {
        population += 1;
        String t = "";
        for(int j = 0; j < tabs; j++){
            t += "\t";
        }

        System.out.println(" ");
        if (population > 2) {
            System.out.println("Родитель 1 (дети): "+ root.name);
        } else {
            System.out.println("Родитель 1: "+ root.name);
        }


        if(root.parents) {
            population += 1;

            System.out.println("Родитель 2 : "+ root.secondparent);
            if(root.child >0) {

                System.out.println("Дети : "+ root.child);
                for(int i=0; i<root.child; i++){
                    display(root.children[i],tabs+2);

                }
            }
        }

    }



}