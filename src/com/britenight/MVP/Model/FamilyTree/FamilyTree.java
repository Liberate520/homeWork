package com.britenight.MVP.Model.FamilyTree;

import com.britenight.MVP.Model.Relation.Relation;
import com.britenight.MVP.Model.Relation.RelationType;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree<E extends Comparable<E>> implements Serializable, Iterable<E> {
    private final LinkedList<Node<E>> nodes = new LinkedList<>();


    //region RelationsManagement

    public List<E> getRelations(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations();
        return collection.stream().map(x -> x.getObject()).collect(Collectors.toList());
    }

    public List<E> getParents(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations().stream().filter(x -> x.getObjectType().equals(RelationType.Parent))
                .collect(Collectors.toList());
        return collection.stream().map(x -> x.getObject()).collect(Collectors.toList());
    }

    public List<E> getChildren(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations().stream().filter(x -> x.getObjectType().equals(RelationType.Child))
                .collect(Collectors.toList());
        return collection.stream().map(x -> x.getObject()).collect(Collectors.toList());
    }

    public List<String> printRelations(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations();
        return collection.stream().map(x -> x.toString()).collect(Collectors.toList());
    }

    public List<String> printParents(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations().stream().filter(x -> x.getObjectType().equals(RelationType.Parent))
                .collect(Collectors.toList());
        return collection.stream().map(x -> x.toString()).collect(Collectors.toList());
    }

    public List<String> printChildren(E object) {
        List<Relation<E>> collection = nodes.stream().filter(x -> x.getMainObject().equals(object))
                .collect(Collectors.toList()).get(0)
                .getRelations().stream().filter(x -> x.getObjectType().equals(RelationType.Parent))
                .collect(Collectors.toList());
        return collection.stream().map(x -> x.toString()).collect(Collectors.toList());
    }

    @SafeVarargs
    public final void addParent(E child, E... parents) {
        for (E parent : parents) {
            nodes.stream().filter(x -> x.getMainObject().equals(child)).collect(Collectors.toList()).get(0)
                    .getRelations().add(new Relation<>(parent, RelationType.Parent));
            nodes.stream().filter(x -> x.getMainObject().equals(parent)).collect(Collectors.toList()).get(0)
                    .getRelations().add(new Relation<>(child, RelationType.Child));
        }
    }

    @SafeVarargs
    public final void removeParent(E child, E... parents) {
        for (E parent : parents) {
            nodes.stream().filter(x -> x.getMainObject().equals(child)).collect(Collectors.toList()).get(0)
                    .getRelations().remove(new Relation<>(parent, RelationType.Parent));
            nodes.stream().filter(x -> x.getMainObject().equals(parent)).collect(Collectors.toList()).get(0)
                    .getRelations().remove(new Relation<>(child, RelationType.Child));
        }
    }

    @SafeVarargs
    public final void addChild(E parent, E... children) {
        for (E child : children) {
            nodes.stream().filter(x -> x.getMainObject().equals(parent)).collect(Collectors.toList()).get(0)
                    .getRelations().add(new Relation<>(child, RelationType.Child));
            nodes.stream().filter(x -> x.getMainObject().equals(child)).collect(Collectors.toList()).get(0)
                    .getRelations().add(new Relation<>(parent, RelationType.Parent));
        }
    }

    @SafeVarargs
    public final void removeChild(E parent, E... children) {
        for (E child : children) {
            nodes.stream().filter(x -> x.getMainObject().equals(parent)).collect(Collectors.toList()).get(0)
                    .getRelations().remove(new Relation<>(child, RelationType.Child));
            nodes.stream().filter(x -> x.getMainObject().equals(child)).collect(Collectors.toList()).get(0)
                    .getRelations().remove(new Relation<>(parent, RelationType.Parent));
        }
    }

    //endregion

    //region NodesManagement

    public boolean addObject(E object) {
        if (nodes.stream().anyMatch(x -> x.getMainObject().equals(object))) {
            return false;
        }
        nodes.add(new Node<>(object, new ArrayList<>()));
        return true;
    }

    public boolean removeObject(E object) {
        if (nodes.stream().noneMatch(x -> x.getMainObject().equals(object))) {
            return false;
        }
        // Удаляем все relation у других объектов к этому объекту
        for (Node<E> n : nodes) {
            n.getRelations().removeIf(eRelation -> eRelation.getObject().equals(object));
        }
        nodes.remove(nodes.stream().filter(x -> x.getMainObject().equals(object)).collect(Collectors.toList()).get(0));
        return true;
    }

    public void sort(Comparator<? super Node<E>> c) {
        nodes.sort(c);
    }

    //endregion

    //region Getters

    public ArrayList<E> getObjects() {
        ArrayList<E> result = new ArrayList<>();
        for (Node<E> node : nodes) {
            result.add(node.getMainObject());
        }
        return result;
    }

    //endregion

    //region DefaultOverride

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final Iterator<Node<E>> nodesIterator = nodes.iterator();

            @Override
            public boolean hasNext() {
                return nodesIterator.hasNext();
            }

            @Override
            public E next() {
                return nodesIterator.next().getMainObject();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("FamilyTree:");

        for (Node<E> node : nodes) {
            stringBuilder.append("\n\n");
            stringBuilder.append(node);
        }

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FamilyTree && this.hashCode() == obj.hashCode();
    }

    //endregion
}
