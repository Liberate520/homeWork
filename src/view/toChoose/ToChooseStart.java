package view.toChoose;

public class ToChooseStart implements ToChooseInterface {

    @Override
    public int toChoose() {
        ToReadAnswer answer=new ToReadAnswer();
        System.out.println("\n1 - Загрузить все записи из файла\n" +
                "2 - Распечатать все записи\n" +
                "3 - Добавить новую запись\n" +
                "4 - Отсортировать записи по имени\n" +
                "5 - Отсортировать записи по Id\n" +
                "6 - Наити запись по имени\n" +
                "7 - Сохрянить все записи в файл\n" +
                "8 - Завершить работу.");
        return answer.readAnswer();
    }

}