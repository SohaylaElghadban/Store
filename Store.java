package org.example;

public class Store {
    private String storeCode;
    private String name;


    public Store(String storeCode, String name) {
        this.storeCode = storeCode;
        this.name = name;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
