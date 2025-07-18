package com.example.web_project.common;

public enum Type {

    TYPE_1("Tin tức"),
    TYPE_2("Trả lời câu hỏi");

    private String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
