package family_tree.FamilyTree.View;

import java.io.IOException;

public interface View {
    void start() throws IOException;
    //TODO если так нельзя называть - переименую
    void printResponse(String response);
}
