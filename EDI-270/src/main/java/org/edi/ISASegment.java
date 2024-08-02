package edi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ISASegment {

    @JsonProperty("ISA01")
    private String isa01;

    @JsonProperty("ISA02")
    private String isa02;

    @JsonProperty("ISA03")
    private String isa03;

    @JsonProperty("ISA04")
    private String isa04;

    @JsonProperty("ISA05")
    private String isa05;

    @JsonProperty("ISA06")
    private String isa06;

    @JsonProperty("ISA07")
    private String isa07;

    @JsonProperty("ISA08")
    private String isa08;

    @JsonProperty("ISA09")
    private String isa09;

    @JsonProperty("ISA10")
    private String isa10;

    @JsonProperty("ISA11")
    private String isa11;

    @JsonProperty("ISA12")
    private String isa12;

    @JsonProperty("ISA13")
    private String isa13;

    @JsonProperty("ISA14")
    private String isa14;

    @JsonProperty("ISA15")
    private String isa15;

    @JsonProperty("ISA16")
    private String isa16;

    public String getIsa01()
    {
        return isa01;
    }

    // Constructor
    public ISASegment() {

    }

    // Constructor with parameters
    public ISASegment(String isa01, String isa02, String isa03, String isa04, String isa05, String isa06, String isa07, String isa08, String isa09, String isa10, String isa11, String isa12, String isa13, String isa14, String isa15, String isa16) {
        this.isa01 = isa01;
        this.isa02 = isa02;
        this.isa03 = isa03;
        this.isa04 = isa04;
        this.isa05 = isa05;
        this.isa06 = isa06;
        this.isa07 = isa07;
        this.isa08 = isa08;
        this.isa09 = isa09;
        this.isa10 = isa10;
        this.isa11 = isa11;
        this.isa12 = isa12;
        this.isa13 = isa13;
        this.isa14 = isa14;
        this.isa15 = isa15;
        this.isa16 = isa16;

    }

    //  Method to convert STSegment to EDI string format
    public String toEDIString() {
        return String.format("*%s*%s", isa01, isa02);
    }

    public void setIsa01(String isa01) {

        this.isa01 = isa01;

    }

    public String getIsa02() {

        return isa02;

    }

    public void setIsa02(String isa02) {

        this.isa02 = isa02;

    }

    public String getIsa03() {

        return isa03;

    }

    public void setIsa03(String isa03) {

        this.isa03 = isa03;

    }

    public String getIsa04() {

        return isa04;

    }

    public void setIsa04(String isa04) {

        this.isa04 = isa04;

    }

    public String getIsa05() {

        return isa05;

    }

    public void setIsa05(String isa05) {

        this.isa05 = isa05;

    }

    public String getIsa06() {

        return isa06;

    }

    public void setIsa06(String isa06) {

        this.isa06 = isa06;

    }

    public String getIsa07() {

        return isa07;

    }

    public void setIsa07(String isa07) {

        this.isa07 = isa07;

    }

    public String getIsa08() {

        return isa08;

    }

    public void setIsa08(String isa08) {

        this.isa08 = isa08;

    }

    public String getIsa09() {

        return isa09;

    }

    public void setIsa09(String isa09) {

        this.isa09 = isa09;

    }

    public String getIsa10() {

        return isa10;

    }

    public void setIsa10(String isa10) {

        this.isa10 = isa10;

    }

    public String getIsa11() {

        return isa11;

    }

    public void setIsa11(String isa11) {

        this.isa11 = isa11;

    }

    public String getIsa12() {

        return isa12;

    }

    public void setIsa12(String isa12) {

        this.isa12 = isa12;

    }

    public String getIsa13() {

        return isa13;

    }

    public void setIsa13(String isa13) {

        this.isa13 = isa13;

    }

    public String getIsa14() {

        return isa14;

    }

    public void setIsa14(String isa14) {

        this.isa14 = isa14;

    }

    public String getIsa15() {

        return isa15;

    }

    public void setIsa15(String isa15) {

        this.isa15 = isa15;

    }

    public String getIsa16() {

        return isa16;

    }

    public void setIsa16(String isa16) {

        this.isa16 = isa16;

    }
}



