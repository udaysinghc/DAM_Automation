package com.intelligencebank.stepDefinitions.resources.data;

public class File {

    String name;

    public File(String fileName) {
        setName(fileName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
