package ui;

public class User {

    Command startCommand;

    public User(Command startCommand) {

        this.startCommand = startCommand;
    }

    public void startCommand() {
        startCommand.execute();
    }
}