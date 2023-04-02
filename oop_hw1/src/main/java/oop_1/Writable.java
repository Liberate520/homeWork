package oop_1;
// интерфейс реализующий чтение и запись объектов
public interface Writable {
    void save(GeoTree tree);
    Object read();
}