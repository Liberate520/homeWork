package Views;

public interface Executable {
    /** show list of notes */
    public void show();

    /** get concrete note item */
    public void read();    

    /** create new note */
    public void create();

    /** remove note */
    public void remove();

    /** update note */
    public void update();

    /** save changes */
    public void save();

    /** quit */
    public void quit();
}
