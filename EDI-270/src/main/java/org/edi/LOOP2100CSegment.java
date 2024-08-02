package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2100CSegment {

    @JsonProperty("REF01")
    private String ref01;

    @JsonProperty("REF02")
    private String ref02;

   @JsonProperty("DTP01")
    private String dtp01;

    @JsonProperty("DTP02")
    private String dtp02;

    @JsonProperty("DTP03")
    private String dtp03;

    @JsonProperty("NM103")
    private String nm103;

    @JsonProperty("NM104")
    private String nm104;

    @JsonProperty("NM108")
    private String nm108;

    @JsonProperty("NM109")
    private String nm109;

    @JsonProperty("DMG01")
    private String dmg01;

    @JsonProperty("DMG02")
    private String dmg02;

    @JsonProperty("DMG03")
    private String dmg03;


    //  Method to convert STSegment to EDI string format

    public String toEDIString()
    {
        return "REF*" + ref01 + "*" + ref02 + "DTP*" + "*" + dtp01 + "*"+ dtp02 + "*" + dtp03 + "NM1*" + nm103 +  nm104 +  nm108 +  nm109 + "*" +"DMG*" + dmg01 + "*"+ dmg02 + "*"+ dmg03 + "~";
    }



   //Getters and Setters for LOOP2100CSegment

    public String getRef01()
    {
        return ref01;
    }
    public void setRef01(String ref01)
    {
        this.ref01 = ref01;
    }

    public String getRef02()
    {
        return ref02;
    }
    public void setRef02(String ref02)
    {
        this.ref02 = ref02;
    }

    public String getDtp01()
    {
        return dtp01;
    }
    public void setDtp01(String dtp01)
    {
        this.dtp01 = dtp01;
    }

    public String getDtp02()
    {
        return dtp02;
    }
    public void setDtp02(String dtp02)
    {
        this.dtp02 = dtp02;
    }

    public String getDtp03()
    {
        return dtp03;
    }
    public void setDtp03(String dtp03)
    {
        this.dtp03 = dtp03;
    }

    public String getNm103()
    {
        return nm103;
    }
    public void setNm103(String nm103)
    {
        this.nm103 = nm103;
    }

    public String getNm104()
    {
        return nm104;
    }
    public void setNm104(String nm104)
    {
        this.nm104 = nm104;
    }

    public String getNm108()
    {
        return nm108;
    }
    public void setNm108(String nm108)
    {
        this.nm108 = nm108;
    }

    public String getNm109()
    {
        return nm109;
    }
    public void setNm109(String nm109)
    {
        this.nm109 = nm109;
    }

    public String getDmg01()
    {
        return dmg01;
    }
    public void setDmg01(String dmg01)
    {
        this.dmg01 = dmg01;
    }

    public String getDmg02()
    {
        return dmg02;
    }
    public void setDmg02(String dmg02)
    {
        this.dmg02 = dmg02;
    }

    public String getDmg03()
    {
        return dmg03;
    }
    public void setDmg03(String dmg03)
    {
        this.dmg03 = dmg03;
    }

    // Constructor with parameters
    public LOOP2100CSegment(String ref01, String ref02, String dtp01, String dtp02, String dtp03, String nm103, String nm104, String nm108, String nm109, String dmg01, String dmg02, String dmg03) {
        this.ref01 = ref01;
        this.ref02 = ref02;
        this.dtp01 = dtp01;
        this.dtp02 = dtp02;
        this.dtp03 = dtp03;
        this.nm103 = nm103;
        this.nm104 = nm104;
        this.nm108 = nm108;
        this.nm109 = nm109;
        this.dmg01 = dmg01;
        this.dmg02 = dmg02;
        this.dmg03 = dmg03;
    }
}





