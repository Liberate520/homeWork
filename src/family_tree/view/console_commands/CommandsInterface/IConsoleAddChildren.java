package family_tree.view.console_commands.CommandsInterface;

public interface IConsoleAddChildren {
    boolean addChildrenCon();
    long getIdFather();
    long getIdMother();
    long getIdChildren();
}
