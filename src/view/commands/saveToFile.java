package view.commands;

import view.Console;

public class saveToFile {
  private Console console;

  public saveToFile(Console console) {
    this.console = console;
  }

  public String getDescription() {
    return "Сохранить дерево в файл";
  }

  public void execute() {
    console.save();
  }
}

