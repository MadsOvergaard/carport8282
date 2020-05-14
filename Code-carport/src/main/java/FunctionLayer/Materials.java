package FunctionLayer;

public class Materials {

    private String matType;
    private int matLength;
    private int matWidth;
    private int matHeight;
    private String matDetail;
    private double matPrice;

    public Materials(String matType, int matLength, int matWidth, int matHeight, String matDetail, double matPrice) {
        this.matType = matType;
        this.matLength = matLength;
        this.matWidth = matWidth;
        this.matHeight = matHeight;
        this.matDetail = matDetail;
        this.matPrice = matPrice;
    }

    public String getMatType() {
        return matType;
    }

    public void setMatType(String matType) {
        this.matType = matType;
    }

    public int getMatLength() {
        return matLength;
    }

    public void setMatLength(int matLength) {
        this.matLength = matLength;
    }

    public int getMatWidth() {
        return matWidth;
    }

    public void setMatWidth(int matWidth) {
        this.matWidth = matWidth;
    }

    public int getMatHeight() {
        return matHeight;
    }

    public void setMatHeight(int matHeight) {
        this.matHeight = matHeight;
    }

    public String getMatDetail() {
        return matDetail;
    }

    public void setMatDetail(String matDetail) {
        this.matDetail = matDetail;
    }

    public double getMatPrice() {
        return matPrice;
    }

    public void setMatPrice(double matPrice) {
        this.matPrice = matPrice;
    }
}
