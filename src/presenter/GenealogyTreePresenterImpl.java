package presenter;

import io.FileHandler;
import io.FileWritableReadable;
import model.GenealogyTree;
import view.GenealogyTreeView;

import java.io.IOException;

public class GenealogyTreePresenterImpl implements GenealogyTreePresenter {
    private GenealogyTreeView view;
    private FileWritableReadable fileHandler;

    public GenealogyTreePresenterImpl() {
        this.fileHandler = new FileHandler();
    }

    @Override
    public void setView(GenealogyTreeView view) {
        this.view = view;
    }

    @Override
    public void loadGenealogyTree(String filename) {
        try {
            GenealogyTree genealogyTree = fileHandler.readFromFile(filename);
            if (view != null) {
                view.displayGenealogyTree(genealogyTree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveGenealogyTree(String filename, GenealogyTree genealogyTree) {
        try {
            fileHandler.writeToFile(filename, genealogyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}