package view.tablo;

public class tabloStart implements interfaceTablo
{

    @Override
    public void tablo() {
        System.out.println("""
                                Выберите формат сохранения фамильного дерева:
    
                                1 - Вывести на экран фамильное дерево:
    
                                2 - работа с файломи

                                3 - найти человека

                                4 - отсортировать дерево по id

                                5 - отсортировать дерево по имени и фамилии
    
                                6 - Выход из программы
                                """);
    }
    
}
