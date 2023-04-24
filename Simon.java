import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Simon extends JPanel implements ActionListener {

    private int width;
    private int height;

    private JPanel backpanel;

    public JLabel SimonSaysLabel;
    public ImageIcon SimonSays;
    public ImageIcon Original;
    public ImageIcon imagebutton;

    public BufferedImage img;

    public JButton red;
    public JButton redd;
    public JButton green;
    public JButton orange;
    public JButton blue;

    public Simon(){
        
        setLayout(new GridLayout(1,1,10,10));
        backpanel = new JPanel();
        backpanel.setBackground(Color.GRAY);
        backpanel.setLayout(new GridLayout(2,2,10,10));

        red = new JButton();
        red.setBackground(Color.RED);
        red.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                if(e.getSource()==red){
                    System.out.println("reached");
                }
                    }  
        });  
        //red.addActionListener(this);

        orange = new JButton();
        orange.setBackground(Color.ORANGE);


        green = new JButton();
        green.setBackground(Color.GREEN);


        blue = new JButton();
        blue.setBackground(Color.BLUE);


        backpanel.add(red);
        backpanel.add(blue);
        backpanel.add(green);
        backpanel.add(orange);

        add(backpanel);



        width = 300;
        height = 300;
        setBackground(Color.GRAY);

        ImageIcon imagebutton = new ImageIcon(new ImageIcon("SimonSaysOriginal.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        redd = new JButton(imagebutton);
        //redd.setBounds(100,100,width,height);

        /* 

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
        add(red);*/
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
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