package com.example.web_project.common;

public enum Category {

    INTRODUCE("GIỚI_THIỆU"),
    NEWS_AND_EVENT("TIN_TỨC_SỰ_KIỆN"),
    LEGAL_DISSEMINATION_AND_EDUCATION("PHỔ_BIẾN_GIÁO_DỤC_PHÁP_LUẬT"),
    MINISTRY_AND_POLICE("BỘ_VỚI_CÔNG_DÂN"),
    STATISTICS("THỐNG_KÊ");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
