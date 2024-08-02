package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BHTSegment
{
    @JsonProperty("BHT01")
    private String bht01;

    @JsonProperty("BHT02")
    private String bht02;

    @JsonProperty("BHT03")
    private String bht03;

    @JsonProperty("BHT04")
    private String bht04;

    @JsonProperty("BHT05")
    private String bht05;

    // Constructor
    public BHTSegment() {

    }


    //  Method to convert STSegment to EDI string format
    public String toEDIString()

    {
        return "BHT*" + bht01 + "*" + bht02 + "*" + bht03 + "*"+ bht04 + "*" + bht05 + "~";
    }


    //Getters and Setters for BHT

    public String getBht01()
    {
        return bht01;
    }
    public void setBht01(String bht01)
    {
        this.bht01 = bht01;
    }

    public String getBht02()
    {
        return bht02;
    }
    public void setBht02(String bht02)
    {
        this.bht02 = bht02;
    }

    public String getBht03()
    {
        return bht03;
    }
    public void setBht03(String bht03)
    {
        this.bht03 = bht03;
    }

    public String getBht04()
    {
        return bht04;
    }
    public void setBht04(String bht04)
    {
        this.bht04 = bht04;
    }
    public String getBht05()
    {
        return bht05;
    }
    public void setBht05(String bht05)
    {
        this.bht05 = bht05;
    }

    // Constructor with parameters
    public BHTSegment(String bht01, String bht02, String bht03, String bht04, String bht05) {
        this.bht01 = bht01;
        this.bht02 = bht02;
        this.bht03 = bht03;
        this.bht04 = bht04;
        this.bht05 = bht05;
    }
}