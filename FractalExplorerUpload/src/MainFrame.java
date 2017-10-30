import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;
    private ImagePanel imagePanel;


    public MainFrame(String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing components
        JTextArea textArea = new JTextArea();
        detailsPanel = new DetailsPanel();
        imagePanel = new ImagePanel();


        // add a listener to the panel created above.  In the DetailsPanel class we have the corresponding
        // addDetailsListener method, which is called here.  It takes a DetailListener object, which it adds to a list
        // of event listeners (in also in the DetailsPanel class).  The type of listener, DetailListener, is created
        // here as an anonymous class (as it is only used here), and it implements the DetailListener interface; that
        // just says it has to implement the method detailEventOccurred.
//        detailsPanel.addDetailListener(new DetailListener() {
//
//            public void detailEventOccurred(DetailEvent event) {
//                View view = event.getView();
//
//                textArea.append(view.getCentre().getRealPart() + " + " + view.getCentre().getImaginaryPart() + "i \n");
//
//            }
//
//        });


        // Add Swing components to content pane

//         note: it seems that if one adds two of the same sort of item (e.g. two JPanels), then the one added FIRST
//         will (upon resizing the window) move OVER the one drawn second.  So adding a JPanel on the left then adding
//         another on the right, then dragging the corner of the frame to make it smaller will (possibly) result in the
//         one on the left covering part of the one on the right.
        Container c = getContentPane();


        c.add(detailsPanel, BorderLayout.WEST);
        c.add(imagePanel, BorderLayout.EAST);
        c.add(textArea, BorderLayout.CENTER);





    }
}
