package commands;

import views.ConsoleInterface;

public class EstablishKinshipRelationship implements Option {
    ConsoleInterface consoleInterface;

    public EstablishKinshipRelationship(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }
    
    @Override
    public void execute() {
        consoleInterface.establishKinshipRelationship();
    }

    @Override
    public String description() {
        return "Установить родственную связь";
    }
}
