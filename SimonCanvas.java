import java.awt.*;
import javax.swing.*;

public class SimonCanvas extends JComponent{
    
    //private Simon simon;

    public SimonCanvas(){

        setPreferredSize(new Dimension(1920,1080));

    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);	
        //simon.draw(g2d);

    }

}
