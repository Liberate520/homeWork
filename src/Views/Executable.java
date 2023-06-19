package Views;

public interface Executable {
    /** показ списка записей */
    public void show();

    /** получить запись по id или заголовку */
    public void read();

    /** создать запись */
    public void create();

    /** удалить запись */
    public void remove();

    /** редактировать запись */
    public void update();

    /** очистить все записи */
    public void clear();
    
    /** сохранить изменения */
    public void save();
    
    /** очистить все записи */
    public void help();

    /** выход */
    public void quit();

}
