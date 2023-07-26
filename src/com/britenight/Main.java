package com.britenight;

import com.britenight.Person.Person;
import com.britenight.MVP.View.ConsoleView;
import com.britenight.MVP.View.View;
import com.britenight.Person.PersonFabric;

public class Main {
    public static void main(String[] args) {
        View app = new ConsoleView<Person>(new PersonFabric());
        app.start();
    }
}
