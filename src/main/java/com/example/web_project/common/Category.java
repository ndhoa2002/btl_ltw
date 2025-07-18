package com.example.web_project.common;

public enum Category {

    CATEGORY_1("GIỚI_THIỆU"),
    CATEGORY_2("TIN_TỨC_SỰ_KIỆN"),
    CATEGORY_3("PHỔ_BIẾN_GIÁO_DỤC_PHÁP_LUẬT"),
    CATEGORY_4("BỘ_VỚI_CÔNG_DÂN"),
    CATEGORY_5("THỐNG_KÊ");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
