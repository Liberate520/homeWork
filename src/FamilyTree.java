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



}
