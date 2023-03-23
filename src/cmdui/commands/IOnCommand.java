package cmdui.commands;

public interface IOnCommand {
    void onCmdGet(ICmdGet cmdGet);

    void onCmdAdd(ICmdAdd cmdAdd);

    void onCmdUpdate(ICmdUpdate cmdUpdate);
}
