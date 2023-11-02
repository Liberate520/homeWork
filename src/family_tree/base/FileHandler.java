package family_tree.base;

import family_tree.human.Human;

import java.io.*;

public class FileHandler {
    public static <E> void main(String[] args) {
        // Создаем объект, который нужно сериализовать
        Human<E> human1 = new Human<E>("Ивановский", "Иван Семенович", "Муж.", "Отец", "В браке", "Формальное",350000.0, 32, 0.1);
        Human<E> human2 = new Human<E>("Семенова", "Марианна Петровна", "Жен.", "Мать", "В браке", "Формальное",350000.0, 30, 0.2);
        Human<E> human3 = new Human<E>("Семенов", "Денис Петрович", "Муж.", "Ребенок", "Не в браке", "Специальное",950000.0, 27, 0.3);
        Human<E> human4 = new Human<E>("Савельев", "Петр Сергеевич", "Муж.", "Отец", "Не в браке", "Специальное",50000.0, 43, 0.4);
        Human<E> human5 = new Human<E>("Живнов", "Марат Клементьевич", "Муж.", "Отец", "В браке", "Специальное",600000.0, 50, 0.5);
        Human<E> human6 = new Human<E>("Алябьева", "Маргарита Васильевна", "Жен.", "Мать", "Не в браке", "Специальное",135000.0, 39, 0.6);
        Human<E> human7 = new Human<E>("Ивановский", "Михаил Иванович", "Муж.", "Ребенок", "Не в браке", "Формальное",5000.0, 14, 0.7);
        Human<E> human8 = new Human<E>("Алябьев", "Петр Маратович", "Муж.", "Ребенок", "Не в браке", "Формальное",10000.0, 20, 0.8);
        Human<E> human9 = new Human<E>("Малинович", "Анна Борисовна", "Жен.", "Ребенок", "Не в браке", "Формальное",5000.0, 10, 0.9);


        String filePath = "homeWork/src/family_tree.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Сериализуем объект
            objectOutputStream.writeObject(human1);
            objectOutputStream.writeObject(human2);
            objectOutputStream.writeObject(human3);
            objectOutputStream.writeObject(human4);
            objectOutputStream.writeObject(human5);
            objectOutputStream.writeObject(human6);
            objectOutputStream.writeObject(human7);
            objectOutputStream.writeObject(human8);
            objectOutputStream.writeObject(human9);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}




