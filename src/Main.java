// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека
// компонента хранения связей и отношений между людьми: родитель, ребёнок - 
// классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// компонент для проведения исследований
// дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку 
// и сохранения в файл, получение\построение отдельных моделей человека
// Под “проведением исследования” можно понимать получение всех детей выбранного человека.

// Сделать PR к проекту: https://github.com/Liberate520/homeWork
// В качестве ответа указать ссылку на PR

public class Main {
    public static void main(String[] args) {
        Communications family1 = new Communications();
        Parent mother1 = new Parent("Vi", "Sol", "female", "29");
        Parent father1 = new Parent("Vo", "Sol", "male", "29");
        Child child1 = new Child("Tr", "Sol", "male", "10");

        family1.addInFamily(child1);
        family1.addInFamily(mother1);
        family1.addInFamily(father1);
        System.out.println("Family1");
        System.out.println(family1);

        Communications family2 = new Communications();
        Parent mother2 = new Parent("El", "Ivanova", "female", "25");
        Parent father2 = new Parent("Vi", "Ivanov", "male", "35");
        Child child2 = new Child("Maria", "Ivanova", "female", "5");
        
        family2.addInFamily(child2);
        family2.addInFamily(mother2);
        family2.addInFamily(father2);
        System.out.println("Family2");
        System.out.println(family2);







        
        


       
    }
}
