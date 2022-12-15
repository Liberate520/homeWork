/**
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека
компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
компонент для проведения исследований
дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
Под “проведением исследования” можно понимать получение всех детей выбранного человека.
 */
public class Main {

    public static void main(String[] args) {
        TreeFamily treeRelations = new TreeFamily();
        TreeFamily treeFamily = new TreeFamily();
        Person parent1 = new Person("Irina", "Brokkoli", "02.05.1960", "female", 62, Relations.Mother);
        Person parent2 = new Person("Arnold", "Brokkoli", "02.07.1961", "male", 61, Relations.Father);
        Person sibling1 = new Person("Shtraus", "Brokkoli", "11.06.1988", "male", 34, Relations.Son);
        Person sibling2 = new Person("Anna", "Brokkoli", "12.08.1991", "female", 32, Relations.Daughter);
        treeFamily.addPerson(parent1);
        treeFamily.addPerson(parent2);
        treeFamily.addPerson(sibling1);
        treeFamily.addPerson(sibling2);
        treeRelations.addRelation(parent1, parent2, Relations.Wife, Relations.Husband);
        treeRelations.addRelation(parent1, sibling1, Relations.Mother, Relations.Son);
        treeRelations.addRelation(parent1, sibling2, Relations.Mother, Relations.Daughter);
        treeRelations.addRelation(parent2, sibling1, Relations.Father, Relations.Son);
        treeRelations.addRelation(parent2, sibling2, Relations.Father, Relations.Daughter);
        System.out.println("Family Tree:\n" + treeFamily.print());
        System.out.println("Relations Tree:\n" + treeRelations);
        treeFamily.search("Shtraus");
    }
}