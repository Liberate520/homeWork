package view.commands;

import view.Console;

public class exit {
  private Console console;

  public exit(Console console) {
    this.console = console;
  }

  public String getDescription() {
    return "Завершить программу";
  }

  public void execute() {
    console.exit();
  }
}

