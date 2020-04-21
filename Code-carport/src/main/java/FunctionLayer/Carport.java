package FunctionLayer;

public class Carport {

    private int length;
    private int width;
    private int height;
    private boolean slope;
    private String roofType;
    private int slopeAngle;


    public Carport(int length, int width, int height, boolean slope, String roofType, int slopeAngle) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.slope = slope;
        this.roofType = roofType;
        this.slopeAngle = slopeAngle;
    }

    public Carport(int length, int width, int height, boolean slope) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.slope = slope;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSlope() {
        return slope;
    }

    public void setSlope(boolean slope) {
        this.slope = slope;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public int getSlopeAngle() {
        return slopeAngle;
    }

    public void setSlopeAngle(int slopeAngle) {
        this.slopeAngle = slopeAngle;
    }
}
