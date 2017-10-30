public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double re, double im) {
        this.realPart = re;
        this.imaginaryPart = im;
    }

    public ComplexNumber() {
        this.realPart = 0;
        this.imaginaryPart = 0;
    }

    public ComplexNumber(ComplexNumber x) {         // made this because wasn't sure how to instantiate complex numbers neatly in some cases
        this.realPart = x.getRealPart();
        this.imaginaryPart = x.getImaginaryPart();
    }

    public static ComplexNumber multiply(ComplexNumber x, ComplexNumber y) {
        ComplexNumber result = new ComplexNumber();
        result.setRealPart((x.getRealPart() * y.getRealPart()) - (x.getImaginaryPart() * y.getImaginaryPart()));
        result.setImaginaryPart((x.getRealPart() * y.getImaginaryPart()) + (x.getImaginaryPart() * y.getRealPart()));
        return result;
    }

    public static ComplexNumber raiseToPower(ComplexNumber z, int y) {
        ComplexNumber result = z;
        for (int i = 1; i < y; i++){            // z is already z to the power 1; for z^2, iterate once.
            result = ComplexNumber.multiply(result,z);
        }

        return result;
    }

    public static ComplexNumber add(ComplexNumber x, ComplexNumber y) {
        //TODO: do what was done here for the other methods
        return new ComplexNumber(x.getRealPart() + y.getRealPart(),x.getImaginaryPart() + y.getImaginaryPart());
    }

    public static ComplexNumber divide(ComplexNumber x, ComplexNumber y) {
        ComplexNumber result = new ComplexNumber();
        ComplexNumber xybar = new ComplexNumber(ComplexNumber.multiply(x,y.getConjugate()));
        double yybar = (ComplexNumber.multiply(y,y.getConjugate())).getRealPart();        // yybar is real!
        if (yybar != 0) {
            result.setRealPart(xybar.getRealPart()/yybar);
            result.setImaginaryPart(xybar.getImaginaryPart()/yybar);
            return result;
        } else {  //you done fucked up somewhere.
            return x;
        }

    }

    public double getAbsoluteValue() {
        double result;
        result = Math.sqrt(Math.pow(this.getRealPart(),2) + Math.pow(this.getImaginaryPart(),2));
        return result;
    }

    public ComplexNumber getConjugate() {
        ComplexNumber result = new ComplexNumber();
        result.setRealPart(this.getRealPart());
        result.setImaginaryPart( -this.getImaginaryPart());
        return result;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
}
