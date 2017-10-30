import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;


public class GUI {

    // just a class to hold the main method, which itself creates, sets up and shows a MainFrame object (which is a JFrame)
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("Fractal Explorer 5000 X-TREME edition 2.0");
                frame.setSize(1420,807);
                frame.setMinimumSize(new Dimension(1420, 807));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });




    }


}








//    // "Dragging" the mouse seems to be when one clicks, holds and moves the mouse.  Doing so also counts as "pressing";
//    // releasing the mouse is not part of dragging, but (typically!) happens afterwards, which does NOT then count as "clicking".
//    // To "click", it seems that the mouse pointer must not move between "press" and "release"
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        System.out.println("Mouse dragged");
//    }
//
//    // This one does something when the mouse is moved, so could be used, for instance, to make something follow the mouse pointer
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        System.out.println("Mouse moved");
//    }
//
//    // This one is called when the mouse button is pressed and released without movement (of the mouse pointer) in between (otherwise
//    // it would be "dragging"
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("Mouse clicked");
//    }
//
//    // This is called when the mouse button is depressed -- not to be confused with the compound action of "clicking"
//    @Override
//    public void mousePressed(MouseEvent e) {
//        System.out.println("Mouse pressed");
//    }
//
//    // This is called when the (previously depressed) mouse button is released.  If the mouse pointer was moved in the mean time, then
//    // "dragging" occurred; otherwise, a "click" occurred.
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        System.out.println("Mouse released");
//    }
//
//    // This is called when the mouse pointer is brought over the listened-to component (e.g. when the mouse is moved over the window, it calls this upon entering the "airspace" of the window
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println("Mouse entered");
//    }
//
//    // Same as "mouseEntered", but upon exiting
//    @Override
//    public void mouseExited(MouseEvent e) {
//        System.out.println("Mouse exited");
//    }


//    public static void main(String[] args) throws IOException {
//        //image dimension
//        int width = 1024;
//        int height = 768;
//        //Centering the image on (-0.5,0) with width 4 seems a good standard.
//        ComplexNumber centrePoint = new ComplexNumber(-0.5,0);
//        View standardView = new View(centrePoint,1);
//        Render standardRender = new Render(standardView,1000);
//
//        //try to create a fractal image.
//        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//
//        File f = null;
//
//        for(int i = 0; i < width; i++){
//            for (int j = 0; j < height; j++) {
//                if (standardRender.getIterationArray()[i][j] < standardRender.getMaxIterations()) {
//                    img.setRGB(i,j,(standardRender.getIterationArray()[i][j] * 0x11111111) | 0xFF000000);
//                    //img.setRGB(i,j,0xFFFFFFFF);   //set as white if escaped
//                } else {
//                    img.setRGB(i,j,0xFF000000);  //set as black if didn't escape
//                }
//            }
//        }
//
//        //write image
//        try{
//            f = new File("C:\\Users\\Oliver\\IdeaProjects\\FractalExplorer\\output.png");
//            ImageIO.write(img,"png",f);
//        }catch(IOException e){
//            System.out.println("Error: " + e);
//
//
//        }
//    }//main() ends here
//}//class ends here