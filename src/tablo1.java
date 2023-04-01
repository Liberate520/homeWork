import javax.xml.transform.stream.StreamSource;

public interface tablo1 {
    public static void tabloSave()
    {
        System.out.println("""
                            Выберите формат сохранения фамильного дерева:

                            1 - заделать сериализацию данных (записать файл с бинарными данными)

                            2 - сохранение в формате: file.txt

                            3 - сохранение данных в формате: file.doc

                            4 - сохранение данных в формате: file.md

                            5 - перейти на чтение сохраненных файлов

                            6 - Выход из программы

                            """);
    }

}
