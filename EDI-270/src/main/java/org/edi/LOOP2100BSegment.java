package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LOOP2100BSegment {
    @JsonProperty("NM101")
    private String nm101;

    @JsonProperty("NM108")
    private String nm108;

    @JsonProperty("NM109")
    private String nm109;

    @JsonProperty("N401")
    private String n401;

    @JsonProperty("N402")
    private String n402;

    @JsonProperty("N403")
    private String n403;

    @JsonProperty("PRV03")
    private String prv03;


    // Constructor
    public LOOP2100BSegment() {
    }

    //  Method to convert STSegment to EDI string format
    public String toEDIString()

    {
        return "NM1*" + nm101 + "*" + nm108 + "*" + nm109 + "*" + "N4*" + "*" + n401 + "*" + n402 + "*" + n403 + "PRV03" + "*" + prv03 + "~";
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

    public String getN401()
    {
        return n401;
    }
    public void setN401(String n401)
    {
        this.n401 = n401;
    }

    public String getN402()
    {
        return n402;
    }
    public void setN402(String n402)
    {
        this.n402 = n402;
    }

    public String getN403()
    {
        return n403;
    }
    public void setN403(String n403)
    {
        this.n403 = n403;
    }

    public String getPrv03()
    {
        return prv03;
    }
    public void setPrv03(String prv03)
    {
        this.prv03 = prv03;
    }


   // Constructor with parameters
    public LOOP2100BSegment(String nm101, String nm108, String nm109, String n401, String n402, String n403, String prv03) {
        this.nm101 = nm101;
        this.nm108 = nm108;
        this.nm109 = nm109;
        this.n401 = n401;
        this.n402 = n402;
        this.n403 = n403;
        this.prv03 = prv03;
    }

}
