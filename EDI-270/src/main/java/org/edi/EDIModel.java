package edi;

public class EDIModel {
    private ISASegment isaSegment;
    private GSSegment gsSegment;
    private STSegment stSegment;
    private BHTSegment bhtSegment;
    private LOOP2000ASegment loop2000ASegment;



    // Constructor
    public EDIModel() {
        this.isaSegment = isaSegment;
        this.gsSegment = gsSegment;
        this.stSegment = stSegment;
        this.bhtSegment = bhtSegment;

    }

    // Getters and Setters
    public ISASegment getIsaSegment() {
        return isaSegment;
    }

    public void setIsaSegment(ISASegment isaSegment) {
        this.isaSegment = isaSegment;
    }

    public GSSegment getGsSegment() {
        return gsSegment;
    }

    public void setGsSegment(GSSegment gsSegment) {
        this.gsSegment = gsSegment;
    }

    public STSegment getStSegment() {
        return stSegment;
    }

    public void setStSegment(STSegment stSegment) {
        this.stSegment = stSegment;
    }

    public BHTSegment getBhtSegment() {
        return bhtSegment;
    }

    public void setBhtSegment(BHTSegment bhtSegment) {
        this.bhtSegment = bhtSegment;
    }

    // Additional methods to process EDI data can be added here
}

