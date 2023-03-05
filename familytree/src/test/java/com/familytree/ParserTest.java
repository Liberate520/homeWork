package com.familytree;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.Objects;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    Path CSVPath = Paths.get("src", "main", "resources", "tree.csv");
    private Map<String, Person> record;

    private void initializeRecord() throws FileNotFoundException {
        record = Parser.parse(CSVPath);
    }

    @Test
    public void CSVPath_Exists() throws FileNotFoundException {
        assertThat(Files.exists(CSVPath));
    }

    @Test
    public void SteffonName_Exists() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.containsKey("Stepan Borisov"));
    }

    @Test
    public void whenSearchSteffonName_thenPersonExists() throws FileNotFoundException {
        initializeRecord();
        assertThat(Objects.nonNull(record.get("Stepan Borisov")));
    }

    @Test
    public void whenSearchSteffonName_thenNameSame() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getName().equals("Stepan Borisov"));
    }

    @Test
    public void whenSearchSteffonGender_thenGenderMale() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getGender().equals(Gender.MALE));
    }

    @Test
    public void whenSearchSteffonNeighbors_thenSizeFour() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getNeighbors().size() == 4);
    }

    @Test
    public void whenSearchSteffonNeighbors_thenRobertExists() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getNeighbors().contains(record.get("Robert Borisov")));
    }

    @Test
    public void whenSearchSteffonRelationships_thenRobertExists() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getRelationships().containsKey("Robert Borisov"));
    }

    @Test
    public void whenSearchSteffonRelationships_thenParentOfRobert() throws FileNotFoundException {
        initializeRecord();
        assertThat(record.get("Stepan Borisov").getRelationships().get("Robert Borisov")
                .equals(RelationshipType.PARENT));
    }
}
