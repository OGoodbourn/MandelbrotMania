import javax.xml.soap.Detail;
import java.util.EventListener;

// an event listener interface defines the methods used by a component to dispatch events

public interface DetailListener extends EventListener {
    public void detailEventOccurred(DetailEvent event);
}
