package GenerationTree.View;

import java.util.Map;

public interface View {
    void startup();

    boolean fileExist(String name);

    int selectTreeMemberId(Map<Integer, String> members);

    void print(String text);
}
