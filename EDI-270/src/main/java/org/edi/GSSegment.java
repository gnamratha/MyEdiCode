package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GSSegment
{
    @JsonProperty("GS01")
    private String gs01;
    @JsonProperty("GS02")
    private String gs02 ;
    @JsonProperty("GS03")
    private String gs03;
    @JsonProperty("GS04")
    private String gs04 ;
    @JsonProperty("GS05")
    private String gs05 ;
    @JsonProperty("GS06")
    private String gs06;
    @JsonProperty("GS07")
    private String gs07;

    @JsonProperty("GS08")
    private String gs08;

    // Constructor
    public GSSegment() {

    }

    // Constructor
    public GSSegment(String gs01, String gs02, String gs03, String gs04, String gs05, String gs06, String gs07, String gs08) {
        this.gs01 = gs01;
        this.gs02 = gs02;
        this.gs03 = gs03;
        this.gs04 = gs04;
        this.gs05 = gs05;
        this.gs06 = gs06;
        this.gs07 = gs07;
        this.gs08 = gs08;
    }

    // Getters and Setters
    // ... (Include getters and setters for all fields)

    // Method to convert GSSegment to EDI string format
    public String toEDIString() {
        return "GS*" + gs01 + "*" + gs02 + "*" + gs03 + "*" + gs04 + "*" + gs05 + "*" + gs06 + "*" + gs07 + "*" + gs08 + "~";
    }

    public String getGs01()
    {
        return gs01;
    }

    public void setGs01(String gs01)
    {
        this.gs01 = gs01;
    }

    public String getGs02()
    {
        return gs02;
    }

    public void setGs02(String gs02)
    {
        this.gs02 = gs02;
    }

    public String getGs03()
    {
        return gs03;
    }

    public void setGs03(String gs03)
    {
        this.gs03 = gs03;
    }

    public String getGs04()
    {
        return gs04;
    }

    public void setGs04(String gs04)
    {
        this.gs04 = gs04;
    }

    public String getGs05()
    {
        return gs05;
    }

    public void setGs05(String gs05)
    {
        this.gs05 = gs05;
    }

    public String getGs06()
    {
        return gs06;
    }

    public void setGs06(String gs06)
    {
        this.gs06 = gs06;
    }

    public String getGs07()
    {
        return gs07;
    }

    public void setGs07(String gs07)
    {
        this.gs07 = gs07;
    }

    public String getGs08()
    {
        return gs08;
    }

    public void setGs08(String gs08)
    {
        this.gs08 = gs08;
    }
}
