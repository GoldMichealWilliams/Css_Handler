package com.zgx.css;

/**
 * unique flag generators Enum
 * Created by zhouguoxin3 on 2017/9/8.
 */
public enum UniqueGeneratorsEnum {
    UUID("uuid"),
    RANDOM_CHARS("random_chars");

    String value;

    private UniqueGeneratorsEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
