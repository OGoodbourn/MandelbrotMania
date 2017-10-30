import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class DetailsPanel extends JPanel {

    private EventListenerList listenerList = new EventListenerList();



    public static int currentMaxIterations = 500;



    public static double perClickMagnification = 1.5;


    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Fractal details"));

        JLabel coordinatesLabel = new JLabel("Coordinates: ");
        JTextField realPartField = new JTextField("-0.5",5);
        JLabel plusLabel = new JLabel(" + ");
        JTextField imagPartField = new JTextField("0.0",5);
        JLabel iLabel = new JLabel("i");
        JLabel magnificationLabel = new JLabel("Magnification: ");
        JTextField magnificationField = new JTextField("1",2);
        JButton listButton = new JButton("Add view to list.");
        JLabel iterationsLabel = new JLabel("Maximum iterations: ");
        JTextField iterationsField = new JTextField(Integer.toString(currentMaxIterations),3);
        JLabel perClickMagLabel = new JLabel("Mag. per click: ");
        JTextField perClickMagField = new JTextField(Double.toString(perClickMagnification),2);

        //TODO: add functionality (and more buttons)

        listButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });


//        listButton.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                View currentView = ImagePanel.getView();
//                fireDetailEvent(new DetailEvent(this,currentView));
//            }
//
//        });

        add(coordinatesLabel, BorderLayout.NORTH);
        add(realPartField, BorderLayout.LINE_START);
        add(plusLabel, BorderLayout.CENTER);
        add(imagPartField, BorderLayout.CENTER);
        add(iLabel, BorderLayout.LINE_END);
        add(magnificationLabel, BorderLayout.SOUTH);
        add(magnificationField, BorderLayout.SOUTH);
        add(iterationsLabel, BorderLayout.SOUTH);
        add(iterationsField, BorderLayout.SOUTH);
        add(perClickMagLabel, BorderLayout.SOUTH);
        add(perClickMagField, BorderLayout.SOUTH);
        add(listButton, BorderLayout.SOUTH);

    } //end of constructor



    public int getCurrentMaxIterations() {
        return currentMaxIterations;
    }

    public void setCurrentMaxIterations(int currentMaxIterations) {
        this.currentMaxIterations = currentMaxIterations;
    }

    public double getPerClickMagnification() {
        return perClickMagnification;
    }

    public void setPerClickMagnification(double perClickMagnification) {
        this.perClickMagnification = perClickMagnification;
    }


//
//    // This is the code to deal with firing off DetailEvents
//    public void fireDetailEvent(DetailEvent event) {
//        Object[] listeners = listenerList.getListenerList();
//
//        for(int i = 0; i < listeners.length; i += 2) {
//            if(listeners[i] == DetailListener.class) {
//                ((DetailListener)listeners[i+1]).detailEventOccurred(event);
//            }
//        }
//    }
//
//
//    public void addDetailListener(DetailListener listener) {
//        listenerList.add(DetailListener.class, listener);
//    }
//
//    public void removeDetailListener(DetailListener listener) {
//        listenerList.remove(DetailListener.class, listener);
//    }
//

} //end of class
