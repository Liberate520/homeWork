package Tree;

public class Research {
    /**
     * Research Класс определяющий методы исследования. Имеет три перегрузки, для получения списка зависимостей:
     * По Человеку и типу родственной связи (допустим ищет для Человека всех Сыновей),
     * По типу родственной связи (Допустим ищет всех людей являющихся кому-либо Мужем),
     * По Человеку (ищет все записи родственных связей для конкретного человека).
     */
    public static void getResearch( Relations relation, Person person, Tree tree) {
        for (Communications el : tree.getLinks()) {
            if (el.getPeople().getSurName().equals(person.getSurName())  &&
                    el.getPeople().getFirstName().equals(person.getFirstName())
                    && el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }


    public static void getResearch(Relations relation, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getResearch(Person person, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getPeople().getSurName().equals(person.getSurName())   &&
                    el.getPeople().getFirstName().equals(person.getFirstName())) {
                System.out.println(el);
            }
        }
    }

}
