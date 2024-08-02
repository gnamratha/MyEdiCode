package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2000CSegment {

    @JsonProperty("HL01")
    private String hl01;

    @JsonProperty("HL02")
    private String hl02;

    @JsonProperty("HL03")
    private String hl03;

    @JsonProperty("HL04")
    private String hl04;

    @JsonProperty("TRN02")
    private String trn02;

    @JsonProperty("TRN03")
    private String trn03;

    @JsonProperty("TRN04")
    private String trn04;


    //  Method to convert STSegment to EDI string format

    public String toEDIString()
    {
        return "HL*" + hl01 + "*" + hl02 + "*" + hl03 + "*"+ hl04 + "*" + "TRN*" + trn02 + "*"+ trn03 + "*"+ trn04 + "~";
    }


//Getters and Setters for BHT

    public String getHl01()
    {
        return hl01;
    }
    public void setHl01(String hl01)
    {
        this.hl01 = hl01;
    }

    public String getHl02()
    {
        return hl02;
    }
    public void setHl02(String hl02)
    {
        this.hl02 = hl02;
    }

    public String getHl03()
    {
        return hl03;
    }
    public void setHl03(String hl03)
    {
        this.hl03 = hl03;
    }

    public String getHl04()
    {
        return hl04;
    }
    public void setHl04(String hl04)
    {
        this.hl04 = hl04;
    }

    public String getTrn02()
    {
        return trn02;
    }
    public void setTrn02(String trn02)
    {
        this.trn02 = trn02;
    }

    public String getTrn03()
    {
        return trn03;
    }
    public void setTrn03(String trn03)
    {
        this.trn03 = trn03;
    }

    public String getTrn04()
    {
        return trn04;
    }
    public void setTrn04(String trn04)
    {
        this.trn04 = trn04;
    }

    // Constructor with parameters
    public LOOP2000CSegment(String hl01, String hl02, String hl03, String hl04, String trn02, String trn03, String trn04) {
        this.hl01 = hl01;
        this.hl02 = hl02;
        this.hl03 = hl03;
        this.hl04 = hl04;
        this.trn02 = trn02;
        this.trn03 = trn03;
        this.trn04 = trn04;
    }
}