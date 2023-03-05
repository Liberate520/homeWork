package com.familytree;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BreadthFirstTest {
    private Person root;
    private Person firstNeighbor;
    private Person firstNeighborNeighbor;
    private Person secondNeighbor;

    private void initializePersons() {
        root = new Person("Boris", Gender.MALE);
        firstNeighbor = new Person("Alla", Gender.FEMALE);

        root.connect(firstNeighbor);
        firstNeighbor.connect(root);

        firstNeighborNeighbor = new Person("Ivan", Gender.MALE);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(firstNeighbor);

        firstNeighborNeighbor.connect(root);
        root.connect(firstNeighborNeighbor);

        secondNeighbor = new Person("Anna", Gender.FEMALE);
        root.connect(secondNeighbor);
        secondNeighbor.connect(root);
    }

    @Test
    public void whenSearchBob_thenExists() {
        initializePersons();
        assertThat(BreadthFirstSearch.search("Boris", firstNeighborNeighbor)).isPresent();
    }

    @Test
    public void whenSearchBob_thenRoot() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Boris", firstNeighborNeighbor).get();
        assertThat(Utility.getPersonFromBFS(result)).isEqualTo(root);
    }

    @Test
    public void whenSearchJohn_thenExists() {
        initializePersons();
        assertThat(BreadthFirstSearch.search("Ivan", firstNeighborNeighbor)).isPresent();
    }

    @Test
    public void whenSearchJohn_thenNeighborNeighbor() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Ivan", firstNeighborNeighbor).get();
        assertThat(Utility.getPersonFromBFS(result)).isEqualTo(firstNeighborNeighbor);
    }

    @Test
    public void whenSearchAnnie_thenExists() {
        initializePersons();
        assertThat(BreadthFirstSearch.search("Anna", firstNeighborNeighbor)).isPresent();
    }

    @Test
    public void whenSearchAnnie_thenSecondNeighbor() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Anna", firstNeighborNeighbor).get();
        assertThat(Utility.getPersonFromBFS(result)).isEqualTo(secondNeighbor);
    }

    @Test
    public void whenSearchJulia_thenNotFound() {
        initializePersons();
        assertThat(BreadthFirstSearch.search("Yula", firstNeighborNeighbor)).isEmpty();
    }

    @Test
    public void whenSearchBob_thenShortestPathOne() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Boris", firstNeighborNeighbor).get();
        assertThat(Utility.getShortestPathFromBFS(result)).isEqualTo(1);
    }

    @Test
    public void whenSearchJohn_thenShortestPathZero() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Ivan", firstNeighborNeighbor).get();
        assertThat(Utility.getShortestPathFromBFS(result)).isEqualTo(0);
    }

    @Test
    public void whenSearchAnnie_thenShortestPathTwo() {
        initializePersons();
        List<Person> result = BreadthFirstSearch.search("Anna", firstNeighborNeighbor).get();
        assertThat(Utility.getShortestPathFromBFS(result)).isEqualTo(2);
    }
}
