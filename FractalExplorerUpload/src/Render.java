import java.util.*;

//TODO: work out how to write these as files, so that they can be stored in a folder in the containing folder, perhaps named according to their date.
//TODO: work out some way to avoid doing the calculations for points known to be in the set.

// A render stores the iteration data for a given picture (rather than the picture itself).  This way we can create
// different pictures from the same data, say by changing the colour palette.
public class Render {

    private View renderLocation;    // this records "where" the render is showing.
    private int[][] iterationArray;   // This stores the number of iterations each point/pixel took.
    private Date date;             // when this render was created.
    private long timeTaken;           // the time taken to create the render, in milliseconds.
    private int maxIterations;      // what was the maximal number of iterations allowed?  Maybe this will be able to be changed on a per render basis.

    public Render(View renderLocation, int maxIterations) {
        long startTime;
        ComplexNumber z;
        ComplexNumber c;
        ComplexNumber zero = new ComplexNumber(); //create a complex number 0 to be used in the iteration below (again and again)
        int iterations;
        double stepSize = renderLocation.getRealWidth() / (double) View.pixelsWide; // the step size is the same for both the real and imaginary axes.

        this.iterationArray = new int[View.pixelsWide][View.pixelsHigh];
        startTime = System.currentTimeMillis();

        for (int i = 0; i < View.pixelsWide; i++ ) {
            for (int j = 0; j < View.pixelsHigh; j++) {
                // work out where you are: fix c for this, the i,jth point.
                c = new ComplexNumber(renderLocation.getLeftmostPoint() + (i * stepSize),
                       renderLocation.getTopmostPoint() - (j * stepSize));
                // set z back to the complex number 0
                z = zero;
                iterations = 0;
                while ((iterations <= maxIterations) && (Math.pow(z.getRealPart(),2) + Math.pow(z.getImaginaryPart(),2) < 2*2)) {  // the second condition means that if
                    z = ComplexNumber.add(ComplexNumber.raiseToPower(z,2), c);                                                  // z's abs val ever gets as big as 2, stop iterating
                    iterations++;                                                                                                  // Could have used .getAbsoluteValue, but that uses a sqrt too.
                }
                iterationArray[i][j] = iterations;
            }
        }
        this.timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Creating the render took " + this.getTimeTaken() + " milliseconds.");

        // store the given view object
        this.renderLocation = renderLocation;
        // store the date and time the render was completed
        this.date = Calendar.getInstance().getTime();
        // store what the maximum number of allowed iterations was for this render
        this.maxIterations = maxIterations;
    }


    public View getRenderLocation() {
        return renderLocation;
    }

    public void setRenderLocation(View renderLocation) {
        this.renderLocation = renderLocation;
    }


    public int[][] getIterationArray() {
        return iterationArray;
    }

    public void setIterationArray(int[][] iterationArray) { this.iterationArray = iterationArray; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }
}




