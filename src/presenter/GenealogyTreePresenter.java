package presenter;

import model.GenealogyTree;
import view.GenealogyTreeView;

public interface GenealogyTreePresenter {
    void setView(GenealogyTreeView view);
    void loadGenealogyTree(String filename);
    void saveGenealogyTree(String filename, GenealogyTree genealogyTree);
}