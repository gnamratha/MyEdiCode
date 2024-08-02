package edi;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GESegment
{
    @JsonProperty("GE01")
    private String ge01;

    @JsonProperty("GE02")
    private String ge02 ;


    // Constructor
    public GESegment() {

    }


    //  Method to convert GESegment to EDI string format

    public String toEDIString()

    {
        return "GE*" + ge01 + "*" + ge02 + "*" + "~";
    }

    //Getters and Setters for GE
    public String getGe01()

    {
        return ge01;
    }

    public void setGe01(String ge01)

    {
        this.ge01 = ge01;
    }

    public String getGe02()

    {
        return ge02;
    }

    public void setGe02(String ge02)

    {
        this.ge02 = ge02;
    }


    // Constructor with parameters
    public GESegment(String ge01, String ge02) {
        this.ge01 = ge01;
        this.ge02 = ge02;
    }
}
