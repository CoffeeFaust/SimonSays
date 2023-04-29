import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Simon extends JPanel implements ActionListener, ChangeListener {

    public int flashed, ticks, dark;
    public int indexPattern;
    public ArrayList<Integer> currentPattern = new ArrayList<Integer>();

    public JPanel backpanel;
    public Random random;
    public Timer timer;
    public Timer numtimer;
    public JLabel SimonSaysLabel;

    //all of the images for the colors
    public ImageIcon redimage;
    public ImageIcon reddark;
    public ImageIcon yellowimage;
    public ImageIcon yellowdark;
    public ImageIcon blueimage;
    public ImageIcon bluedark;
    public ImageIcon greenimage;
    public ImageIcon greendark;

    public BufferedImage img;
    
    public boolean makePattern;
    public boolean pressed;
    public boolean SimonStrike;

    public JButton red;
    public JButton green;
    public JButton yellow;
    public JButton blue;

    public Simon(){

        indexPattern = 0;
        dark = 2;
        flashed = 0;
        ticks = 0;
        random = new Random();
        makePattern = true;
        pressed = false;
        setLayout(new GridLayout(1,1,10,10));
        backpanel = new JPanel();
        backpanel.setBackground(Color.GRAY);
        backpanel.setLayout(new GridLayout(2,2,10,10));
       
        
        timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e){
                
				backpanel.repaint();
            
				//this method so its a continuous animation
			}
		});

        numtimer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e){
                ticks++;

                // Progression loop where 1 then 12 then 123 then 1234
                if(flashed != 0 && !makePattern){
                    if(indexPattern != currentPattern.size()){
                        makePattern = true;
                        dark = 2;
                        indexPattern = 0;
                    }else if(currentPattern.get(indexPattern)==flashed){
                        indexPattern++;
                    }
                }
                flashed = 0;

                if(makePattern){
                    if(dark <=0){
                        if(indexPattern>=currentPattern.size()){
                            flashed = random.nextInt(40) % 4 + 1;
                            System.out.println(flashed);
                            currentPattern.add(flashed);
                            indexPattern = 0;
                            makePattern = false;
                        }else{
                            flashed = currentPattern.get(indexPattern);
                            indexPattern++;
                        }
                        dark = 2;
                    }
                    else{
                        dark--;
                    }
                }


                /* for the random pattern flashes
                if(makePattern && dark <= 0){
                    if(indexPattern == currentPattern.size()){
                        flashed = random.nextInt(40) % 4 + 1;
                        System.out.println(flashed);
                        currentPattern.add(flashed);
                        makePattern = false;
                    }
                    else{
                        flashed = currentPattern.get(indexPattern);
                        indexPattern++;
                    }
                    dark = 2;
                }               

                dark--;*/
                //buttons(flashed);
                System.out.println(flashed);
                if(flashed == 1){
                    red.setIcon(redimage);
                }else{
                    red.setIcon(reddark);
                }
        
                if(flashed == 2){
                    yellow.setIcon(yellowimage);
                        
                    
                }else{
                    yellow.setIcon(yellowdark);
                        
                }
        
                if(flashed == 3){
                    green.setIcon(greenimage);
                        
                }else{
                    green.setIcon(greendark);
                    
                }
        
                if(flashed == 4){
                    blue.setIcon(blueimage);
                        
                }else{
                    blue.setIcon(bluedark);
                        
                }
                //buttons(flashed);
                
				//this method so its a continuous animation
			}
            
		});
        
       
        //the images used for the buttons
        redimage = new ImageIcon("red.png");
        reddark = new ImageIcon("reddark.png");
        yellowimage = new ImageIcon("yellow.png");
        yellowdark = new ImageIcon("yellowdark.png");
        greenimage = new ImageIcon("green.png");
        greendark = new ImageIcon("greendark.png");
        blueimage = new ImageIcon("blue.png");
        bluedark = new ImageIcon("darkblue.png");


        //next set of if statements are for the flashing
        numtimer.start();
		timer.start();
        setBackground(Color.GRAY);
        buttons(flashed);
        backpanel.add(red);
        backpanel.add(blue);
        backpanel.add(green);
        backpanel.add(yellow);
        add(backpanel);
    
     } 

    

       /*  if(makePattern){
            flashed = random.nextInt(3) + 1;
            currentPattern.add(flashed);
            System.out.println(flashed);
            for(int i = 0; i < currentPattern.size(); i++) {   
                System.out.print(currentPattern.get(i));
            }  
        }
       backpanel.repaint();*/





//note to self to implement later. Glowing button when hovered and press glowtime 25.30 in the video when it is not creating a pattern

    //@Override
    public void buttons(int fleshing){

                //this is the one that can supposedly change the size of the image within the button incase you need it (really worked! tried and tested!)
        //bluedark = new ImageIcon(new ImageIcon("bluedark.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    flashed = fleshing;
    
        red = new JButton(redimage);
        red.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                   red.setIcon(reddark);
                    }  
        });  
        red.getModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                ButtonModel model = (ButtonModel) e.getSource();

                // if the current state differs from the previous state
                if (model.isPressed() != pressed) {
                    red.setIcon(redimage);
                    
                    if(!makePattern && currentPattern.get(indexPattern) == flashed){
                        indexPattern++;
                        System.out.println(flashed);
                        System.out.println("red reached");
                    }
                    ticks = 1;
                    pressed = model.isPressed();
                    pressed = false;
                    
                }              
          }
        });

    

        yellow = new JButton(yellowimage);
        yellow.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                yellow.setIcon(yellowdark);
                    }  
        });  
        yellow.getModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                ButtonModel model = (ButtonModel) e.getSource();

                // if the current state differs from the previous state
                if (model.isPressed() != pressed) {
                    yellow.setIcon(yellowimage);
                    ticks = 1;
                    pressed = model.isPressed();
                    pressed = false;
                    
                }              
          }
        });

        

        green = new JButton(greenimage);
        green.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                green.setIcon(greendark);
                    }  
        });  
        green.getModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                ButtonModel model = (ButtonModel) e.getSource();

                // if the current state differs from the previous state
                if (model.isPressed() != pressed) {
                    green.setIcon(greenimage);
                    ticks = 1;
                    pressed = model.isPressed();
                    pressed = false;
                    
                }              
          }
        });


        blue = new JButton(blueimage);
        blue.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                blue.setIcon(bluedark);
                
                    }  
        });  
        blue.getModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                ButtonModel model = (ButtonModel) e.getSource();

                // if the current state differs from the previous state
                if (model.isPressed() != pressed) {
                    blue.setIcon(blueimage);
                    ticks = 1;
                    pressed = model.isPressed();
                    pressed = false;
                    
                }              
          }
        });

    /*for(int x:currentPattern){
        int current = currentPattern.get(x);
        System.out.println(current);
        if(current == 0){
            currentPattern.remove(x);
        }
        
    }*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("hoe");

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }


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