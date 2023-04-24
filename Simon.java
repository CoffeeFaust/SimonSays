import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Simon extends JPanel {

    private int width;
    private int height;
    public JPanel simon;

    public JLabel SimonSaysLabel;
    public JLabel oho;
    public ImageIcon SimonSays;
    public ImageIcon Original;
    public ImageIcon imagebutton;

    public BufferedImage img;

    public JButton red;

    public Simon(){
        width = 300;
        height = 300;
        setBackground(Color.GRAY);
        oho = new JLabel();

        ImageIcon imagebutton = new ImageIcon(new ImageIcon("SimonSaysOriginal.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        red = new JButton(imagebutton);
        red.setBounds(100,100,width,height);

        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.RED);
        //redpanel.setBounds(50,50,250,250);

        JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.BLUE);

        JPanel yellowpanel = new JPanel();
        yellowpanel.setBackground(Color.YELLOW);

        setLayout(new GridLayout(2,2,10,10));


        //redpanel.add(SimonSaysLabel);
        //bluepanel.add(SimonSaysLabel);
        add(redpanel);
        add(yellowpanel);
        add(bluepanel);
        add(red);
        //redpanel.setBounds(50,50,250,250);
       /*
        try { //remember this is for getting images in by labels :))
            //Original = new ImageIcon(getClass().getResource("SimonSaysOriginal.png"));
            ImageIcon Original = new ImageIcon(new ImageIcon("SimonSaysOriginal.png").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
            JLabel SimonSaysLabel = new JLabel(Original);
            
            redpanel.add(SimonSaysLabel);
            //bluepanel.add(SimonSaysLabel);
            add(redpanel);
            add(yellowpanel);
            add(bluepanel);
            //add(SimonSaysLabel);
            System.out.println(width);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("not found!");
            System.out.println(System.getProperty("user.dir"));
        }*/ 

 
    }

   /*  protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);	

        

    }
*/
}