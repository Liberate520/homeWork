package Tree;

public class Research {
    /**
     *     Класс определяющий методы исследования. Имеет три перегрузки, для получения списка зависимостей:
     *     По Человеку и типу родственной связи (допустим ищет для Человека всех Сыновей),
     *     По типу родственной связи (Допустим ищет всех людей являющихся кому-либо Мужем),
     *     По Человеку (ищет все записи родственных связей для конкретного человека).
     */
    public static void getRelation(Person person, Relations relation, Tree tree) {
        for (Communications el : tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())
                    && el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }


    public static void getRelation(Relations relation, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getRelation(Person person, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())) {
                System.out.println(el);
            }
        }
    }
}
