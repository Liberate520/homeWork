package view;

import presenter.Presenter;

public class SearchPerson {

    private Presenter presenter;

    public SearchPerson(Presenter presenter) {
        this.presenter = presenter;
    }

    public void searchPerson() {
        presenter.searchPerson();
    }
}
