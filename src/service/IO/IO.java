package service.IO;

/*
Интерфейс для чтения\записи
 */
public interface IO {
    <E> void toFile(E element, String path);

    Object fromFile(String path);
}
