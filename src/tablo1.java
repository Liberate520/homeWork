import javax.xml.transform.stream.StreamSource;

public interface tablo1 {
    public static void tabloSave()
    {
        System.out.println("""
                            Выберите формат сохранения фамильного дерева:

                            1 - сохранение в формате: file.txt

                            2 - сохранение данных в формате: file.doc

                            3 - сохранение данных в формате: file.md

                            4 - перейти на чтение сохраненных файлов

                            4 - Выход из программы

                            """);
    }

}
