package com.example.believeinyourshelves.models;

public enum BookType {

    READBOOK ("Book read"),
    WANTTOREAD("Book you want to read");

    private final String displayName;

    BookType (String displayName) { this.displayName = displayName; }

    public String getDisplayName () {return displayName; }
}
