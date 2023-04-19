package view;

import presenter.Presenter;

public class AddPerson {
    private Presenter presenter;
    private SearchPerson search;

    public AddPerson(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addPerson() {
        search = new SearchPerson(presenter);
        presenter.setHuman();
    }
}
