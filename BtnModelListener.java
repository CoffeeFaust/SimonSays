import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class BtnModelListener implements ChangeListener {

    public Simon simon;

    public boolean pressed;

    public BtnModelListener(){
        pressed = false;// holds the last pressed state of the button

    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();

        // if the current state differs from the previous state
        if (model.isPressed() != pressed) {
            
            System.out.println("bruh");
            pressed = model.isPressed();
        }
    }

    //public String color(String color){
      //  return color;
    //}
}
