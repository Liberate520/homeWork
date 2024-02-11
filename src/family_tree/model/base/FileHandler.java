package family_tree.model.base;

import family_tree.model.tree.FamilyTree;
import family_tree.model.human.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandler {
    public static <E> void main(String[] args) throws IOException {
        // Создаем объект, который нужно сериализовать
        ArrayList<Human> humans = new ArrayList<>();
//        Human human1 = new Human("Ивановский", "Иван Семенович", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Null,350000.0, LocalDate.of(1991, 1, 10), 0.001);
//        Human human2 = new Human("Семенова", "Марианна Петровна", Gender.Female, Position.Mother, SocialPosition.Married, Fondation.Informal,350000.0, LocalDate.of(1993, 10, 10), 0.002);
//        Human human3 = new Human("Семенов", "Денис Петрович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal,950000.0, LocalDate.of(1998, 7, 7), 0.003);
//        Human human4 = new Human("Савельев", "Петр Сергеевич", Gender.Male, Position.Father, SocialPosition.Not_married, Fondation.Informal,50000.0, LocalDate.of(1980, 6, 5), 0.004);
//        Human human5 = new Human("Живнов", "Марат Клементьевич", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Informal,600000.0, LocalDate.of(1973, 12, 6), 0.005);
//        Human human6 = new Human("Алябьева", "Маргарита Васильевна", Gender.Female, Position.Mother, SocialPosition.Not_married, Fondation.Formal,135000.0, LocalDate.of(1984, 9, 27), 0.006);
//        Human human7 = new Human("Ивановский", "Михаил Иванович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Non_formal,5000.0, LocalDate.of(2009, 4, 21), 0.007);
//        Human human8 = new Human("Алябьев", "Петр Маратович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal,10000.0, LocalDate.of(2003, 11, 9), 0.008);
//        Human human9 = new Human("Малинович", "Анна Борисовна", Gender.Female, Position.Daughter, SocialPosition.Not_married, Fondation.Non_formal,5000.0, LocalDate.of(2013, 3, 5), 0.009);
//        Human human10 = new Human("Малинович", "Марианна Борисовна", Gender.Female, Position.Child, SocialPosition.Not_married, Fondation.Non_formal,1000.0, LocalDate.of(2020, 8, 12), 0.010);
//        Human human11 = new Human("Крылова", "Сабина Сергеевна", Gender.Female, Position.Daughter, SocialPosition.Not_married, Fondation.Non_formal,12000.0, LocalDate.of(2010, 4, 24), 0.011);
//        Human human12 = new Human("Живнова", "Аделаида Андреевна", Gender.Female, Position.Daughter, SocialPosition.Null, Fondation.Formal,120000.0, LocalDate.of(1975, 11, 29), 0.012);
        humans.add(new Human("Ивановский", "Иван Семенович", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Formal, 350000.0, LocalDate.of(1991, 1, 10), 1));
        humans.add(new Human("Семенова", "Марианна Петровна", Gender.Female, Position.Mother, SocialPosition.Married, Fondation.Informal, 350000.0, LocalDate.of(1993, 10, 10), 2));
        humans.add(new Human("Семенов", "Денис Петрович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal, 950000.0, LocalDate.of(1998, 7, 7), 3));
        humans.add(new Human("Савельев", "Петр Сергеевич", Gender.Male, Position.Father, SocialPosition.Not_married, Fondation.Informal, 50000.0, LocalDate.of(1980, 6, 5), 4));
        humans.add(new Human("Живнов", "Марат Клементьевич", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Informal, 600000.0, LocalDate.of(1973, 12, 6), 5));
        humans.add(new Human("Алябьева", "Маргарита Васильевна", Gender.Female, Position.Mother, SocialPosition.Not_married, Fondation.Formal, 135000.0, LocalDate.of(1984, 9, 27), 6));
        humans.add(new Human("Ивановский", "Михаил Иванович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Non_formal, 5000.0, LocalDate.of(2009, 4, 21), 7));
        humans.add(new Human("Алябьев", "Петр Маратович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal, 10000.0, LocalDate.of(2003, 11, 9), 8));
        humans.add(new Human("Малинович", "Анна Борисовна", Gender.Female, Position.Daughter, SocialPosition.Not_married, Fondation.Non_formal, 5000.0, LocalDate.of(2013, 3, 5), 9));
        humans.add(new Human("Малинович", "Марианна Борисовна", Gender.Female, Position.Child, SocialPosition.Not_married, Fondation.Non_formal, 1000.0, LocalDate.of(2020, 8, 12), 10));
        humans.add(new Human("Крылова", "Сабина Сергеевна", Gender.Female, Position.Daughter, SocialPosition.Not_married, Fondation.Non_formal, 12000.0, LocalDate.of(2010, 4, 24), 11));
        humans.add(new Human("Живнова", "Аделаида Андреевна", Gender.Female, Position.Daughter, SocialPosition.Married, Fondation.Formal, 120000.0, LocalDate.of(1975, 11, 29), 12));
        humans.add(new Human("Живнов", "Олег Андреевич", Gender.Male, Position.Son, SocialPosition.Married, Fondation.Formal, 160000.0, LocalDate.of(1975, 11, 29), 13));
        humans.add(new Human("Семенова", "Марина Денисовна", Gender.Female, Position.Daughter, SocialPosition.Null, Fondation.Non_formal, 3000.0, LocalDate.of(2020, 6, 2), 14));
        humans.add(new Human("Семенов", "Ян Петрович", Gender.Male, Position.Son, SocialPosition.Null, Fondation.Non_formal, 34000.0, LocalDate.of(2000, 8, 23), 15));

//        String filePath = "homeWork/src/family_tree.txt";
        String filePath = "homeWork/src/model_app/family_tree.txt";
//        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath/*, true*/);
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
//             {
            // Сериализуем объект
//            for (Human human : humans) {
//                objectOutputStream.writeObject(human);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Сериализуем объект
            for (Human human : humans) {
                writer.write(String.valueOf(human));
                writer.newLine();
            };
        } catch (IOException e) {
            e.printStackTrace();
        }


//        {
//            // Сериализуем объект
//            objectOutputStream.writeObject(human1);
//            objectOutputStream.writeObject(human2);
//            objectOutputStream.writeObject(human3);
//            objectOutputStream.writeObject(human4);
//            objectOutputStream.writeObject(human5);
//            objectOutputStream.writeObject(human6);
//            objectOutputStream.writeObject(human7);
//            objectOutputStream.writeObject(human8);
//            objectOutputStream.writeObject(human9);
//            objectOutputStream.writeObject(human10);
//            objectOutputStream.writeObject(human11);
//            objectOutputStream.writeObject(human12);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //  Сортировка списка
//        FamilyTree.methodSortByLastName(humans);
//        FamilyTree.methodSortByAge(humans);
//        familyTree.methodSortByIncome(humans);



//        System.out.println("\n============= Сортировка списка по Фамилии (по алфавиту) :");
//        //  Сортировка списка по Фамилии
//        humans.sort(Comparator.comparing(Human::getLastName));
//        for (Human human : humans) {
//            System.out.println(human);
//        }

//        System.out.println("\n============= Сортировка списка по Возрасту (по убыванию) :");
//        //  Сортировка списка по Возрасту
//        humans.sort(Comparator.comparing(Human::getAge).reversed());
//        for (Human human : humans) {
//            System.out.println(human);
//        }

//        System.out.println("\n============= Сортировка списка по Доходу (по убыванию) :");
////          Сортировка списка по Доходам
////        humans.sort(Comparator.comparing(Human::getIncome).reversed());
//        humans.sort(Comparator.comparing(Human::getIncome).reversed());
//        for (Human human : humans) {
//            System.out.println(human);
//        }


    }


//    public static void FileHandlerForFamilyTree() throws IOException {
////        String filePath = "homeWork/src/family_tree.txt";
//        String filePath = "homeWork/src/model_app/family_tree.txt";
//        // выводим на экран
//        try (FileInputStream fileInputStream = new FileInputStream(filePath);
//             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//            // Десериализуем объекты
//            while (true) {
//                try {
//                    Human human;
//                    human = (Human) objectInputStream.readObject();
//                    System.out.println(human);
//                } catch (EOFException e) {
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
////        try(FileInputStream fileInputStream = new FileInputStream(filePath);
////            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
////
////            // Десериализуем
////            Human human1;
////            try {
////                human1 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human2;
////            try {
////                human2 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human3;
////            try {
////                human3 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human4;
////            try {
////                human4 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human5;
////            try {
////                human5 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human6;
////            try {
////                human6 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human7;
////            try {
////                human7 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human8;
////            try {
////                human8 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human9;
////            try {
////                human9 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human10;
////            try {
////                human10 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human11;
////            try {
////                human11 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Human human12;
////            try {
////                human12 = (Human) objectInputStream.readObject();
////            } catch (ClassNotFoundException | IOException ex) {
////                throw new RuntimeException(ex);
////            }
////
////
////            // выводим на экран
////            System.out.println(human1);
////            System.out.println(human2);
////            System.out.println(human3);
////            System.out.println(human4);
////            System.out.println(human5);
////            System.out.println(human6);
////            System.out.println(human7);
////            System.out.println(human8);
////            System.out.println(human9);
////            System.out.println(human10);
////            System.out.println(human11);
////            System.out.println(human12);
////
////        }
//    }
//
//
////    public static <E> void methodSortByLastName(ArrayList<Human> humans) {
////        System.out.println("\n============= Сортировка списка по Фамилии (по алфавиту) :");
////        //  Сортировка списка по Фамилии
////        humans.sort(Comparator.comparing(Human::getLastName));
////        for (Human human : humans) {
////            System.out.println(human);
////        }
////    }
////
////    public static void methodSortByAge(ArrayList<Human> humans) {
////        System.out.println("\n============= Сортировка списка по Возрасту (по убыванию) :");
////        //  Сортировка списка по Возрасту
////        humans.sort(Comparator.comparing(Human::getAge).reversed());
////        for (Human human : humans) {
////            System.out.println(human);
////        }
////    }
////
////    public static void methodSortByIncome(ArrayList<Human> humans) {
////        System.out.println("\n============= Сортировка списка по Доходу (по убыванию) :");
//////          Сортировка списка по Доходам
////        humans.sort(Comparator.comparing(Human::getIncome).reversed());
////        for (Human human : humans) {
////            System.out.println(human);
////        }
////    }
//
//
}