package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IEASegment {

    @JsonProperty("IEA01")
    private String iea01;

    @JsonProperty("IEA02")
    private String iea02;

    // Constructor with parameters
    public IEASegment(String iea01, String iea02) {
        this.iea01 = iea01;
        this.iea02 = iea02;
    }

    // Method to convert IEASegment to EDI string format
    public String toEDIString() {
        return "IEA*" + iea01 + "*" + iea02 + "~";
    }

    // Getters and Setters
    public String getIea01() {
        return iea01;
    }

    public void setIea01(String iea01) {
        this.iea01 = iea01;
    }

    public String getIea02() {
        return iea02;
    }

    public void setIea02(String iea02) {
        this.iea02 = iea02;
    }
}
