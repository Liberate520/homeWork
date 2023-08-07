package view.commands;

import view.Console;

public class sortByName {
  private Console console;

  public sortByName(Console console) {
    this.console = console;
  }

  public String getDescription() {
    return "Отсортировать по имени";
  }

  public void execute() {
    console.sortByName();
  }
}
