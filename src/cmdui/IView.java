package cmdui;

import java.util.function.Consumer;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;

public interface IView {
    void setCmdGetHandler(Consumer<ICmdGet> handler);

    void setCmdAddHandler(Consumer<ICmdAdd> handler);

    void setPrintOut(String out);
}
