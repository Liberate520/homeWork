package Presenter;

import View.View;
import Repository.RepositoryTree;

public class Presenter {
    private View view;
    private RepositoryTree repository;

    public Presenter(View view, RepositoryTree repository) {
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }

    public void onClick(int num){
        repository.get(num);
    }
}