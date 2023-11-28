import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FamilyTree {
    private Person root;

        // Конструктор класса FamilyTree
        public FamilyTree(Person root) {
            this.root = root;
        }

        // Метод для получения всех детей выбранного человека
        public List<Person> getAllChildren(Person person) {
            List<Person> allChildren = new ArrayList<>();
            Queue<Person> queue = new LinkedList<>();

            queue.add(person);

            while (!queue.isEmpty()) {
                Person currentPerson = queue.poll();
                List<Person> children = currentPerson.getChildren();

                for (Person child : children) {
                    allChildren.add(child);
                    queue.add(child);
                }
            }

            return allChildren;
        }
}
