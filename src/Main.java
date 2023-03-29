import java.util.ArrayList;
import java.util.Arrays;

// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например: модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

public class Main {
    public static void main(String[] args) {

        dinastyRomanov();
    }

    public static ArrayList<Relation> dinastyRomanov() {
        ArrayList<Relation> relationsArray = new ArrayList<Relation>();
        ArrayList<Person> emptyList = new ArrayList<>();


        System.out.println(relationsArray);


        return relationsArray;
    }
}
