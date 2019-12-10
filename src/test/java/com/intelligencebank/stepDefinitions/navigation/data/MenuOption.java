package com.intelligencebank.stepDefinitions.navigation.data;

public class MenuOption {
    String name;

    public MenuOption(String menuOption) {
        setName(menuOption);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
