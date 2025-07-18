package com.example.web_project.common;

public enum Field {

    FIELD_1("Chế độ chính sách"),
    FIELD_2("Đấu tranh phòng chống tội phạm"),
    FIELD_3("Pháp chế"),
    FIELD_4("Phòng cháy và chữa cháy"),
    FIELD_5("Thi hành án hình sự và hỗ trợ tư pháp"),
    FIELD_6("Thủ tục hành chính"),
    FIELD_7("Tuyển dụng và đào tạo"),
    FIELD_8("Trật tự an toàn giao thông"),
    FIELD_9("Các lĩnh vực khác");

    private final String fieldName;

    Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
