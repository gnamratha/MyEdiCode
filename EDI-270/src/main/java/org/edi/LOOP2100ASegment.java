package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2100ASegment

{
    @JsonProperty("NM101")
    private String nm101;

    @JsonProperty("NM102")
    private String nm102;

    @JsonProperty("NM103")
    private String nm103;

    @JsonProperty("NM108")
    private String nm108;

    @JsonProperty("NM109")
    private String nm109;

    // Constructor
    public LOOP2100ASegment() {

    }


    //  Method to convert LOOP2100ASegment  to EDI string format
    public String toEDIString()

    {
        return "NM1*" + nm101 + "*" + nm102 + "*" + nm103 + "*"+ nm108 + "*" + nm109 + "~";
    }


    //Getters and Setters for BHT

    public String getNm101()
    {
        return nm101;
    }
    public void setNm101(String nm101)
    {
        this.nm101 = nm101;
    }

    public String getNm102()
    {
        return nm102;
    }
    public void setNm102(String nm102)
    {
        this.nm102 = nm102;
    }

    public String getNm103()
    {
        return nm103;
    }
    public void setNm103(String nm103)
    {
        this.nm103 = nm103;
    }

    public String getNm108()
    {
        return nm108;
    }
    public void setNm108(String nm108)
    {
        this.nm108 =nm108;
    }
    public String getNm109()
    {
        return nm109;
    }
    public void setNm109(String bht05)
    {
        this.nm109 = nm109;
    }


    // Constructor with parameters
    public LOOP2100ASegment(String nm101, String nm102, String nm103, String nm108, String nm109) {
        this.nm101 = nm101;
        this.nm102 = nm102;
        this.nm103 = nm103;
        this.nm108 = nm108;
        this.nm109 = nm109;
    }
}

