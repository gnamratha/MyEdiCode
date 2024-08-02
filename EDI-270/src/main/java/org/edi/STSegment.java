package edi;


import com.fasterxml.jackson.annotation.JsonProperty;

public class STSegment
{
    @JsonProperty("ST01")
    private String st01;

    @JsonProperty("ST02")
    private String st02 ;

    @JsonProperty("ST03")
    private String st03;

    // Constructor
    public STSegment() {

    }


    //  Method to convert STSegment to EDI string format
    public String toEDIString()

    {
        return "ST*" + st01 + "*" + st02 + "*" + st03 + "*" + "~";
    }

    //Getters and Setters for ST01
    public String getSt01()

    {
        return st01;
    }

    public void setSt01(String st01)

    {
        this.st01 = st01;
    }

    public String getSt02()

    {
        return st02;
    }

    public void setSt02(String st02)

    {
        this.st02 = st02;
    }

    public String getSt03()
    {
        return st03;
    }

    public void setSt03(String st03)

    {
        this.st03 = st03;
    }


    // Constructor with parameters
    public STSegment(String st01, String st02, String st03) {
        this.st01 = st01;
        this.st02 = st02;
        this.st03 = st03;
    }
}
