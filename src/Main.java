import java.util.GregorianCalendar;
public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Владимир Бжешкович Пузо", Gender.Муж, new GregorianCalendar(1939, 9, 23));
        Human human2 = new Human("Ефросинья Абрамовна Жмышенко", Gender.Жен, new GregorianCalendar(1941, 1, 19));
        Human human3 = new Human("Андрей Владимирович Пузо", Gender.Муж, new GregorianCalendar(1964, 5, 25));
        Human human4 = new Human("Наталья Викторовна Биба", Gender.Жен, new GregorianCalendar(1963, 7, 3));
        Human human5 = new Human("Сергей Андреевич Пузо", Gender.Муж, new GregorianCalendar(1985, 10, 13));
        Human human6 = new Human("Ольга Андреевна Пузо", Gender.Жен, new GregorianCalendar(1992, 11, 6));
        Human human7 = new Human("Витька Владимирович Пузо", Gender.БоевойВертолёт, new GregorianCalendar(1968, 3, 22));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);

        human1.addRelationship(human2, Relationships.Жена);
        human1.addRelationship(human3, Relationships.Сын);
        human1.addRelationship(human7, Relationships.Сын);
        human1.addRelationship(human5, Relationships.Внук);
        human1.addRelationship(human6, Relationships.Внучка);
        human1.addRelationship(human4, Relationships.Невестка);

        human2.addRelationship(human1, Relationships.Муж);
        human2.addRelationship(human3, Relationships.Сын);
        human2.addRelationship(human7, Relationships.Сын);
        human2.addRelationship(human5, Relationships.Внук);
        human2.addRelationship(human6, Relationships.Внучка);
        human2.addRelationship(human4, Relationships.Невестка);

        human3.addRelationship(human1, Relationships.Отец);
        human3.addRelationship(human2, Relationships.Мать);
        human3.addRelationship(human7, Relationships.Брат);
        human3.addRelationship(human5, Relationships.Сын);
        human3.addRelationship(human6, Relationships.Дочь);
        human3.addRelationship(human4, Relationships.Жена);

        human4.addRelationship(human1, Relationships.Свёкр);
        human4.addRelationship(human2, Relationships.Свекровь);
        human4.addRelationship(human5, Relationships.Сын);
        human4.addRelationship(human6, Relationships.Дочь);
        human4.addRelationship(human3, Relationships.Муж);

        human5.addRelationship(human1, Relationships.Дедушка);
        human5.addRelationship(human2, Relationships.Бабушка);
        human5.addRelationship(human3, Relationships.Отец);
        human5.addRelationship(human4, Relationships.Мать);
        human5.addRelationship(human6, Relationships.Сестра);
        human5.addRelationship(human7, Relationships.Дядя);

        human6.addRelationship(human1, Relationships.Дедушка);
        human6.addRelationship(human2, Relationships.Бабушка);
        human6.addRelationship(human3, Relationships.Отец);
        human6.addRelationship(human4, Relationships.Мать);
        human6.addRelationship(human5, Relationships.Брат);
        human6.addRelationship(human7, Relationships.Дядя);

        human7.addRelationship(human1, Relationships.Отец);
        human7.addRelationship(human2, Relationships.Мать);
        human7.addRelationship(human3, Relationships.Брат);
        human7.addRelationship(human5, Relationships.Племянник);
        human7.addRelationship(human6, Relationships.Племянница);

        System.out.println(familyTree);
    }
}