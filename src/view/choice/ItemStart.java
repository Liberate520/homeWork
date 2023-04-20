package view.choice;

public class ItemStart implements ChoiceInterface{
    @Override
    public void selectItem() {
        System.out.println(
                "\nВведите номер действия:\n" + "1. Вывести фамильное дерево\n" +
                        "2. Найти человека по имени\n" +
                        "3. Отсортировать фамильное дерево по имени\n" +
                        "4. Отсортировать фамильное дерево по дате смерти\n" +
                        "5. Сохранить файл\n" + "6. Загрузить файл\n" +
                        "7. Выход\n");
    }
}
