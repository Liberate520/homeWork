package service.IO;

/*
Интерфейс для чтения\записи
 */
public interface IO {
    <E> void toFile(E element, String path) throws Exception;

    Object fromFile(String path) throws Exception;
}
