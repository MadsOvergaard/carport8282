package FunctionLayer;

public class Carport {

    private int length;
    private int width;
    private int height;
    private boolean slope;
    private String roofType;
    private int slopeAngle;
    private boolean shack;
    private int shackLength;
    private int shackWidth;
    private String carportCladding;
    private String shackCladding;

    public Carport(int length, int width, int height, boolean slope, String roofType, int slopeAngle, boolean shack, int shackLength, int shackWidth, String carportCladding, String shackCladding) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.slope = slope;
        this.roofType = roofType;
        this.slopeAngle = slopeAngle;
        this.shack = shack;
        this.shackLength = shackLength;
        this.shackWidth = shackWidth;
        this.carportCladding = carportCladding;
        this.shackCladding = shackCladding;
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

    public boolean isShack() {
        return shack;
    }

    public void setShack(boolean shack) {
        this.shack = shack;
    }

    public int getShackLength() {
        return shackLength;
    }

    public void setShackLength(int shackLength) {
        this.shackLength = shackLength;
    }

    public int getShackWidth() {
        return shackWidth;
    }

    public void setShackWidth(int shackWidth) {
        this.shackWidth = shackWidth;
    }

    public String getCarportCladding() {
        return carportCladding;
    }

    public void setCarportCladding(String carportCladding) {
        this.carportCladding = carportCladding;
    }

    public String getShackCladding() {
        return shackCladding;
    }

    public void setShackCladding(String shackCladding) {
        this.shackCladding = shackCladding;
    }
}
