import java.util.EventObject;

// This seems to be about creating a new type of event object, so that our special listeners can be passed these.  Events hold all the necessary info for a
// listener to figure out WHAT happened and to WHOM.

public class DetailEvent extends EventObject {

    private View view;

    public DetailEvent(Object source, View view){
        super(source);    // super() calls the parent constructor with no arguments.  super.aMethod calls the method aMethod from the parent

        this.view = view;
    }

    public View getView() {
        return view;
    }
}
