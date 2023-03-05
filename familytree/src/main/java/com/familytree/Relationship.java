package com.familytree;

import java.util.List;

public class Relationship {
    private static Person source;
    private static Person destination;

    public static boolean isParent(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        if (!(Utility.getShortestPathFromBFS(pathToPerson) == 1)) {
            return false;
        }

        if (!source.getRelationships().containsKey(destination.getName())) {
            return false;
        }

        return source.getRelationships().get(destination.getName()) == RelationshipType.PARENT;
    }

    public static boolean isChild(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        if (!(Utility.getShortestPathFromBFS(pathToPerson) == 1)) {
            return false;
        }

        if (!destination.getRelationships().containsKey(source.getName())) {
            return false;
        }

        return destination.getRelationships().get(source.getName()) == RelationshipType.PARENT;
    }

    public static boolean isSpouse(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        if (!(Utility.getShortestPathFromBFS(pathToPerson) == 1)) {
            return false;
        }

        if (!source.getRelationships().containsKey(destination.getName())) {
            return false;
        }

        return source.getRelationships().get(destination.getName()) == RelationshipType.SPOUSE;
    }

    public static boolean isSibling(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 2)) {
            return false;
        }

        return isChild(pathToPerson.subList(0, shortestPath)) && isParent(pathToPerson.subList(1, shortestPath + 1));
    }

    public static boolean isCousin(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 4)) {
            return false;
        }

        if (!isChild(pathToPerson.subList(0, 2))) {
            return false;
        }

        if (!isSibling(pathToPerson.subList(1, shortestPath))) {
            return false;
        }

        return isParent(pathToPerson.subList(shortestPath - 1, shortestPath + 1));
    }

    public static boolean isGrandParent(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 2)) {
            return false;
        }

        return isParent(pathToPerson.subList(0, shortestPath)) && isParent(pathToPerson.subList(shortestPath - 1, shortestPath + 1));
    }

    public static boolean isGrandChild(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 2)) {
            return false;
        }

        return isChild(pathToPerson.subList(0, shortestPath)) && isChild(pathToPerson.subList(shortestPath - 1, shortestPath + 1));
    }

    public static boolean isNieceOrNephew(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 3)) {
            return false;
        }

        if (!isChild(pathToPerson.subList(0, shortestPath - 1))) {
            return false;
        }

        return isSibling(pathToPerson.subList(1, shortestPath + 1));
    }

    public static boolean isAuntOrUncle(List<Person> pathToPerson) {
        source = pathToPerson.get(0);
        destination = pathToPerson.get(pathToPerson.size() - 1);

        int shortestPath = Utility.getShortestPathFromBFS(pathToPerson);

        if (!(shortestPath == 3)) {
            return false;
        }

        if (!isSibling(pathToPerson.subList(0, shortestPath))) {
            return false;
        }

        return isParent(pathToPerson.subList(shortestPath - 1, shortestPath + 1));
    }

    public static String createRelationshipMessage(String nameA, String nameB, RelationshipTypeGendered rType) {
        return nameA + " is " + rType.name() + " of " + nameB;
    }
}
