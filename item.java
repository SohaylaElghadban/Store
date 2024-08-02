package org.example;

public class item {
    private String itemCode;
    private String name;

    public item(String itemCode, String name) {
        this.itemCode = itemCode;
        this.name = name;

    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
