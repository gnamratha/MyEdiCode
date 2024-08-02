package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2000BSegment {
    @JsonProperty("HL01")
    private String hl01;

    @JsonProperty("HL02")
    private String hl02;

    @JsonProperty("HL03")
    private String hl03;

    @JsonProperty("HL04")
    private String hl04;


    //  Method to convert STSegment to EDI string format
    public String toEDIString() {
        return "HL" + hl01 + "*" + hl02 + "*" + hl03 + "*" + hl04 + "*" + "~";
    }

    //Getters and Setters for LOOP2000A

    public String getHl01() {
        return hl01;
    }

    public void setHl01(String hl01) {
        this.hl01 = hl01;
    }

    public String getHl02() {
        return hl02;
    }

    public void setHl02(String hl02) {
        this.hl02 = hl02;
    }

    public String getHl03() {
        return hl03;
    }

    public void setHl03(String hl03)

    {
        this.hl03 = hl03;
    }

    public String getHl04() {
        return hl04;
    }

    public void setHl04(String hl04) {
        this.hl04 = hl04;
    }

    // Constructor with parameters
    public LOOP2000BSegment(String hl01, String hl02, String hl03, String hl04) {
        this.hl01 = hl01;
        this.hl02 = hl02;
        this.hl03 = hl03;
        this.hl04 = hl04;
    }
}
