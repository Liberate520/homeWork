package App;
import App.Commands.AddFamilyMemberCommand;
import App.Commands.DisplayAllRelationshipsCommand;
import App.Commands.DisplayFamilyTreeCommand;
import App.Commands.SortAndDisplayFamilyTreeCommand;
import Model.GenealogyPresenterInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {
    private final GenealogyPresenterInterface presenter;
    private final BufferedReader reader;
    private final Command[] commands;

    public ConsoleUI(GenealogyPresenterInterface presenter) {
        this.presenter = presenter;
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        // Инициализация команд
        commands = new Command[] {
                new AddFamilyMemberCommand(presenter, reader),
                new DisplayFamilyTreeCommand(presenter),
                new DisplayAllRelationshipsCommand(presenter),
                new SortAndDisplayFamilyTreeCommand(presenter, reader)

        };
    }

    public void start() {
        try {
            presenter.loadFamilyTree();
            System.out.println("Family Tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading Family Tree: " + e.getMessage());
        }

        while (true) {
            System.out.println("Genealogy App Menu:");
            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getDescription());
            }
            System.out.println((commands.length + 1) + ". Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                if (choice == commands.length + 1) {
                    saveAndExit();
                    return;
                } else if (choice > 0 && choice <= commands.length) {
                    commands[choice - 1].execute();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void saveAndExit() {
        // Реализация сохранения и выхода

        try {
            presenter.saveFamilyTree(); // Сохранение семейного дерева
            System.out.println("Family Tree saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving Family Tree: " + e.getMessage());
        }  {
            System.out.println("Goodbye!");
            System.exit(0); // Завершаем работу приложения
        }
    }

}

