package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2110CSegment {

    @JsonProperty("EQ01")
    private String eq01;

    // Constructor with parameters
    public LOOP2110CSegment(String eq01) {
        this.eq01 = eq01;
    }

    // Method to convert LOOP2110CSegment to EDI string format
    public String toEDIString() {
        return "EQ*" + eq01 + "~";
    }

    // Getters and Setters for LOOP2110CSegment
    public String getEq01() {
        return eq01;
    }

    public void setEq01(String eq01) {
        this.eq01 = eq01;
    }
}
