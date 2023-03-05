package com.familytree;

import java.util.Objects;

public class StringPair {
    private final String leftString;
    private final String rightString;

    private int hashCode;

    public StringPair(String leftString, String rightString) {
        this.leftString = leftString;
        this.rightString = rightString;
        this.hashCode = Objects.hash(leftString, rightString);
    }

    public String getLeftString() {
        return leftString;
    }

    public String getRightString() {
        return rightString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof StringPair)) {
            return false;
        }

        StringPair otherStringPair = (StringPair) other;
        return leftString.equals(otherStringPair.leftString) && rightString.equals(otherStringPair.rightString);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
