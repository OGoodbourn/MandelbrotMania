public class View {
    private double magnification;
    private ComplexNumber centre;
    public static int pixelsWide = 1024;  // How many pixels wide the image is going to be.
    public static int pixelsHigh = 768;  // ...and how many high.

    public View(ComplexNumber centre, double magnification) {
        this.magnification = magnification;
        this.centre = centre;
    }

    public double getMagnification() {
        return magnification;
    }

    public void setMagnification(double magnification) {
        this.magnification = magnification;
    }

    public ComplexNumber getCentre() {
        return centre;
    }

    public void setCentre(ComplexNumber centre) {
        this.centre = centre;
    }

    public double getRealWidth() {
        double width;
        width = this.getRightmostPoint() - this.getLeftmostPoint();
        return width;
    }

    public double getRealHeight() {
        double height;
        height = this.getTopmostPoint() - this.getBottommostPoint();
        return height;
    }

    // In this method we are implicitly deciding on the width and height of an image at magnification 1 -- might
    // want to change that at some point, but it doesn't seem to be something the user should tamper with.
    public double getLeftmostPoint() {
        double left;
        left = centre.getRealPart() - ((1.0 / this.magnification) * 2);
        return left;
    }

    public double getRightmostPoint() {
        double right;
        right = centre.getRealPart() + ((1.0 / this.magnification) * 2);
        return right;
    }

    public double getTopmostPoint() {
        double top;
        top = centre.getImaginaryPart() + ((1.0 / this.magnification) * 1.5);
        return top;
    }

    public double getBottommostPoint() {
        double bottom;
        bottom = centre.getImaginaryPart() - ((1.0 / this.magnification) * 1.5);
        return bottom;
    }


    public String toString() {
        return "(" + this.centre.getRealPart() + "," + this.centre.getImaginaryPart() + "), " + this.magnification;
    }
}
