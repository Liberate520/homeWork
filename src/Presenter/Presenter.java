package Presenter;


import ThreeFamily.Repository;
import View.View;

public class Presenter {

    private View view;
    private Repository repository;

    public Presenter(View view, Repository repository){
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }
    public void onClick(int num) {
        repository.getNum(num);
    }
}
