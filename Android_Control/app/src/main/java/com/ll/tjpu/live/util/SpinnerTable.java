package com.ll.tjpu.live.util;

public class SpinnerTable {
    private String number;
    private String style;
    private String sex;
    private String characher;
    private String type;

    public String getNumber() {
        return number;
    }

    public String getStyle() {
        return style;
    }

    public String getSex() {
        return sex;
    }

    public String getCharacher() {
        return characher;
    }

    public String getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCharacher(String characher) {
        this.characher = characher;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SpinnerTable{" +
                "number='" + number + '\'' +
                ", style='" + style + '\'' +
                ", sex='" + sex + '\'' +
                ", characher='" + characher + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
