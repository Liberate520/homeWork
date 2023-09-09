package family_tree.FamilyTree.View;

import java.io.IOException;

public interface View {
    void start() throws IOException;

    void printResponse(String response);
}
