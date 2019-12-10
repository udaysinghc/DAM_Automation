package com.intelligencebank.stepDefinitions.admin.data;

public class Email {
    String domain;

    public Email(String folderName) {
        setDomain(folderName);
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }
}
