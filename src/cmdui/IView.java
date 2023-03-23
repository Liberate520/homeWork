package cmdui;

import java.util.function.Consumer;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;
import cmdui.commands.ICmdUpdate;

public interface IView {
    void setCmdGetHandler(Consumer<ICmdGet> handler);

    void setCmdAddHandler(Consumer<ICmdAdd> handler);

    void setCmdUpdateHandler(Consumer<ICmdUpdate> handler);

    void setPrintOut(String out);
}
