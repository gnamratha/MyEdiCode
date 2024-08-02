package edi;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SESegment
{
    @JsonProperty("SE01")
    private String se01;

    @JsonProperty("SE02")
    private String se02 ;


    // Constructor
    public SESegment() {

    }


    //  Method to convert STSegment to EDI string format
    public String toEDIString()

    {
        return "SE*" + se01 + "*" + se02 + "*" + "~";
    }

    //Getters and Setters for SE01
    public String getSe01()

    {
        return se01;
    }

    public void setSe01(String se01)

    {
        this.se01 = se01;
    }

    public String getSe02()

    {
        return se02;
    }

    public void setSe02(String se02)

    {
        this.se02 = se02;
    }


    // Constructor with parameters
    public SESegment(String se01, String se02) {
        this.se01 = se01;
        this.se02 = se02;
       }
}
