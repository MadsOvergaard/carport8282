package FunctionLayer;

public class Svg {

    private double width;
    private double height;
    private String viewbox;
    private double x;
    private double y;
    private StringBuilder svg = new StringBuilder();
    private final String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"%s\" width=\"%s\" viewbox\"%s\" preserveAspectRatio=\"xMinY;om\">";
    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"Stroke:#000000; fill: #ffffff\" />";
    //private final String arrowTemplate = "<SVG width=\"25%\" viewBox=\"0 0 150 40\"> <defs> <marker id=\"beginArrow\"markerWidth=\"12\"markerHeight=\"12\"refX=\"0\"refY=\"6\"orient=\"auto\"><path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" /></marker><markerid=\"endArrow\"markerWidth=\"12\"markerHeight=\"12\"refX=\"12\"refY=\"6\"orient=\"auto\"><path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" /></marker></defs><line x1=\"130\"  y1=\"10\" x2=\"12\"   y2=\"35\"style=\"stroke: #006600;marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/></SVG>";

    /**
     * Instantiates a new Svg.
     * construktor til svg tegning
     * svg.append
     *
     * @param width   the width
     * @param height  the height
     * @param viewbox the viewbox
     * @param x       the x
     * @param y       the y
     */
    public Svg(double width, double height, String viewbox, double x, double y) {
        this.width = width;
        this.height = height;
        this.viewbox = viewbox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewbox));

    }


    public void addRect(double x, double y, double height, double width){
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getViewbox() {
        return viewbox;
    }

    public void setViewbox(String viewbox) {
        this.viewbox = viewbox;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}
