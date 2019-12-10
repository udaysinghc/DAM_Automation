package com.intelligencebank.stepDefinitions.admin.data;

public class Name {
    String value;

    public Name(String folderName) {
        setValue(folderName);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
