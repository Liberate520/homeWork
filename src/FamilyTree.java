import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FamilyTree {
    // Класс имеет одно поле с листом
    private ArrayList<Human> humans;

    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        humans = new ArrayList<>();
    }

    // Метод для заполнения ArrayList экземплярами класса Human
    public void addHuman(Human human) {
        humans.add(human);
    }

    // Переопределяем метод toString класса FamilyThree
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Human h : humans) {
            builder.append("имя: ")
                    .append(h.getName())
                    .append(", Фамилия: ")
                    .append(h.getLastName())
                    .append(", дата рождения: ")
                    .append(h.getBirthDay().toString())
                    .append(", пол: ")
                    .append(h.getGender()).append(", дети: ").append(h.children)
                    .append("\n");
        }
        return builder.toString();
    }

    public String findChildren(String name,String lastName) {
        StringBuilder builder = new StringBuilder();
        for (Human human : humans) {
            if (human.getLastName().equals(lastName)&&human.getName().equals(name)) {
                return builder.append("имя: ")
                        .append(human.getName())
                        .append(", Фамилия: ")
                        .append(human.getLastName())
                        .append(", дата рождения: ")
                        .append(human.getBirthDay().toString())
                        .append(", пол: ")
                        .append(human.getGender()).append(", дети: ")
                        .append(human.getChildren())
                        .append("\n").toString();

            }


        }
        return "Такого человека нет в вашем списке!";
    }
}










