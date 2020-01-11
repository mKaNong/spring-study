package com.ahdy.xem.log;

public enum LogEnum {

    BUSSINESS("bussiness"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),

    ;

    private String category;

    LogEnum(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
