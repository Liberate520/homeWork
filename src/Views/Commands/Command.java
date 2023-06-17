package Views.Commands;

/** Interface Command */
public interface Command {
    /** string present of action */
    String getInfo();

    /** action */
    void execute();
}
