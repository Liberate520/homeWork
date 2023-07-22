package com.britenight.FamilyTree;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FamilyTree<E extends Comparable<Object>> implements Serializable, Iterable<FamilyTreeNode<E>> {
    private final ArrayList<E> objArray;
    private final ArrayList<Relation<E>> relations;

    public FamilyTree() {
        relations = new ArrayList<>();
        objArray = new ArrayList<>();
    }

    //region Relations
    public void addRelation(Relation<E> relation) {
        relations.add(relation);
    }

    public void removeRelation(Relation<E> relation) {
        relations.remove(relation);
    }

    public List<Relation<E>> getRelations() {
        return relations;
    }

    public List<Relation<E>> getRelations(E node, boolean isMainObject) {
        return relations.stream().filter(relation ->
                isMainObject && relation.getMainObject().equals(node)
                        || !isMainObject && relation.getRelationObject().equals(node)).collect(Collectors.toList());
    }

    public List<Relation<E>> getRelations(E node, boolean isMainObject, RelationType searchFor) {
        return relations.stream().filter(relation ->
                (isMainObject && relation.getMainObject().equals(node) || !isMainObject && relation.getRelationObject().equals(node))
                        && relation.getRelationObjectType() == searchFor).collect(Collectors.toList());
    }
    //endregion

    //region Objects
    public void addObject(E node) {
        objArray.add(node);
    }

    public void removeObject(E node) {
        var tmp = relations.stream().filter(relation -> relation.getRelationObject() == node
                || relation.getMainObject() == node).collect(Collectors.toList());
        for (Relation<E> i : tmp) {
            relations.remove(i);
        }
        objArray.remove(node);
    }

    public List<E> getObjects() {
        return objArray;
    }
    //endregion

    //region FamilyTreeNodes
    private List<E> getRelativeObjects(List<Relation<E>> relations, boolean isMainObject) {
        List<E> list = new ArrayList<>();

        for (Relation<E> i : relations) {
            if (isMainObject)
                list.add(i.getRelationObject());
            else
                list.add(i.getMainObject());
        }

        return list;
    }

    public List<E> getRelativeObjects(E node, boolean isMainObject, RelationType searchFor) {
        return getRelativeObjects(getRelations(node, isMainObject, searchFor), isMainObject);
    }

    public List<E> getRelativeObjects(E node, boolean isMainObject) {
        return getRelativeObjects(getRelations(node, isMainObject), isMainObject);
    }

    public ArrayList<FamilyTreeNode<E>> getNodes() {
        ArrayList<FamilyTreeNode<E>> list = new ArrayList<>();

        for (E p : objArray) {
            List<Relation<E>> relations = getRelations(p, true);
            list.add(new FamilyTreeNode<E>(p, relations));
        }

        return list;
    }
    //endregion

    //region Overrides
    @Override
    public Iterator<FamilyTreeNode<E>> iterator() {
        return new Iterator<>() {
            final Iterator<FamilyTreeNode<E>> nodesIterator = getNodes().iterator();
            @Override
            public boolean hasNext() {
                return nodesIterator.hasNext();
            }

            @Override
            public FamilyTreeNode<E> next() {
                return nodesIterator.next();
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        getNodes().forEach(action);
    }

    @Override
    public Spliterator<FamilyTreeNode<E>> spliterator() {
        return getNodes().spliterator();
    }
    //endregion
}
