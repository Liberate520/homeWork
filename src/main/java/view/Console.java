package view;
/**
 * абстрактный класс для реализции разных интерфейсов
 */
public abstract class Console<T> {
    protected T controller;
    public void setController(T controller) {
        this.controller = controller;
    }
    public T getController(){
        return this.controller;
    }
}
