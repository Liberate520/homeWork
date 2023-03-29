package MyNote.Commands;

import MyNote.Presenter;

import MyNote.UI.View;

public class AddRecord implements Command {
    private Presenter presenter;
    private View view;

    public AddRecord(){

    }

	@Override
    public void execute() {
        String text = view.getText();
        presenter.addRecord(text);
        
    }
}
