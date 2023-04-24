import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Simon extends JPanel implements ActionListener {

    private int width;
    private int height;
    public int flashed;
    public int indexPattern;
    public ArrayList<Integer> currentPattern;

    public JPanel backpanel;
    public Random randomizer;
    private Timer timer;
    public JLabel SimonSaysLabel;
    public ImageIcon SimonSays;
    public ImageIcon Original;
    public ImageIcon imagebutton;

    public BufferedImage img;
    
    public boolean makePattern;

    public JButton red;
    public JButton redd;
    public JButton green;
    public JButton yellow;
    public JButton blue;

    public Simon(){
        makePattern = true;
        //flashed = 1;
        setLayout(new GridLayout(1,1,10,10));
        backpanel = new JPanel();
        backpanel.setBackground(Color.GRAY);
        backpanel.setLayout(new GridLayout(2,2,10,10));
        start();
        
        timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				backpanel.repaint();
				//this method so its a continuous animation
			}
		});

		timer.start();
        
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

        yellow = new JButton();
        yellow.setBackground(Color.YELLOW);


        green = new JButton();
        green.setBackground(Color.GREEN);


        blue = new JButton();
        blue.setBackground(Color.BLUE);


        backpanel.add(red);
        backpanel.add(blue);
        backpanel.add(green);
        backpanel.add(yellow);
        add(backpanel);

        //next set of if statements are for the flashing

        if(flashed == 1){
            red.setBackground(Color.RED);
        }else{
            red.setBackground(Color.RED.darker());
        }

        if(flashed == 2){
            yellow.setBackground(Color.YELLOW);
        }else{
            yellow.setBackground(Color.YELLOW.darker());
        }

        if(flashed == 3){
            green.setBackground(Color.GREEN);
        }else{
            green.setBackground(Color.GREEN.darker());
        }

        if(flashed == 4){
            blue.setBackground(Color.BLUE);
        }else{
            blue.setBackground(Color.BLUE.darker());
        }

//note to self to implement later. Glowing button when hovered and press glowtime 25.30 in the video when it is not creating a pattern

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

    public void start(){
        randomizer = new Random();
        currentPattern = new ArrayList<Integer>();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(makePattern){
            flashed = randomizer.nextInt(3) + 1;
            currentPattern.add(flashed);
       }
       backpanel.repaint();
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