import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel {

    private static Render displayedRender;
    private static int width = View.pixelsWide;
    private static int height = View.pixelsHigh;
    public static double clickedX = -0.5;
    public static double clickedY = 0.0;
    private static BufferedImage displayedBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);



    public ImagePanel() {
        Dimension size = getPreferredSize();
        size.height = height;
        size.width = width;
        setPreferredSize(size);


        ////  Render and show a standard first image upon loading//////////

        //Center the image on (-0.5, 0.0) with width 4 (the "real" width being 4 is handled in the view class) and set max iterations
        ComplexNumber centrePoint = new ComplexNumber(-0.5,0);
        View standardView = new View(centrePoint,1);
        Render standardRender = new Render(standardView,500);
        displayedRender = standardRender; // also need to set this as the current displayedRender


        // draw the standardRender on startup (also updates the displayedBufferedImage)
        this.redrawImage(standardRender);

        //write standardRender image file on startup
        this.storeImage();



        //// add a MouseAdapter to detect and act on mouse clicks
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // get the complex number clicked on by converting the coordinates of the pixel into the relevant floats.
                // Remember that for the imaginary part, we need to subtract to move down the image, not add!
                double stepSize = displayedRender.getRenderLocation().getRealWidth() / (double) View.pixelsWide;
                ImagePanel.clickedX = displayedRender.getRenderLocation().getLeftmostPoint() + (stepSize * e.getX());
                ImagePanel.clickedY = displayedRender.getRenderLocation().getTopmostPoint() - (stepSize * e.getY());
                System.out.println("User clicked on complex number (" + ImagePanel.clickedX + ", " + ImagePanel.clickedY + ").");
                super.mouseClicked(e);

                //update the view and repaint!
                ComplexNumber z = new ComplexNumber(clickedX,clickedY);
                displayedRender = new Render(new View(z,ImagePanel.getView().getMagnification() * 1.4), displayedRender.getMaxIterations());
                System.out.println("displayedRender has view " + displayedRender.getRenderLocation().toString());
                redrawImage(displayedRender);
                repaint();
            }
        });


    } // end of constructor




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(displayedBufferedImage, 0, 0, this);
        System.out.println("I painted the image!");  // TODO: remove this debugging message -- why does it paint twice when it loads at the moment?
    }


    public static View getView() {
        return ImagePanel.displayedRender.getRenderLocation();
    }


    // this updates the displayedBufferedImage using the passed render.
    private void redrawImage(Render render) {
        // apply colour to the pixels based on the render
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if (render.getIterationArray()[i][j] < render.getMaxIterations()) {
                    displayedBufferedImage.setRGB(i,j,(render.getIterationArray()[i][j] * 0x11111111) | 0xFF000000);
                    //displayedBufferedImage.setRGB(i,j,0xFFFFFFFF);   //set as white if escaped
                } else {
                    displayedBufferedImage.setRGB(i,j,0xFF000000);  //set as black if didn't escape
                }
            }
        }

    }


    // this writes the image to file
    private void storeImage() {
        try{
            File f = new File("C:\\Users\\Oliver\\IdeaProjects\\FractalExplorer\\output.png");
            ImageIO.write(displayedBufferedImage,"png",f);
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }

} // end of class
