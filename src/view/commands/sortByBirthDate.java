package view.commands;

import view.Console;

public class sortByBirthDate {
  private Console console;

  public sortByBirthDate(Console console) {
    this.console = console;
  }

  public String getDescription() {
    return "Отсортировать по дате рождения";
  }

  public void execute() {
    console.sortByBirthDate();
  }
}
