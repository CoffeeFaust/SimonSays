import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimonFrame extends JFrame{

    private JFrame f;
    private SimonCanvas sc;
    private Timer timer;
	private Simon simon;
	private JPanel panel;

    public SimonFrame(){
        simon = new Simon();
        sc = new SimonCanvas();
		f = new JFrame();

        		//this is the timer for the animation to pace itself
		timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				sc.repaint();
				//this method so its a continuous animation
			}
		});

		timer.start();
		

    }

	public void setUpGUI(){
		
		JPanel mainpanel = new JPanel();
        mainpanel.setBackground(Color.GRAY);
		mainpanel.setPreferredSize(new Dimension(1000, 800));

		JPanel orangepanel = new JPanel();
        orangepanel.setBackground(Color.ORANGE);

		JPanel pinkpanel = new JPanel();
        pinkpanel.setBackground(Color.PINK);

		JPanel greenpanel = new JPanel();
        greenpanel.setBackground(Color.GREEN);

		JPanel purplepanel = new JPanel();
        purplepanel.setBackground(Color.WHITE);


		
		//f.setLayout(new GridLayout(2,3, 10, 10));
		mainpanel.setLayout(new GridLayout(2,3, 10, 10));
		//panel.add(simon);
		f.add(sc);
		//f.add(simon);
		mainpanel.add(simon);
		mainpanel.add(orangepanel);
		mainpanel.add(pinkpanel);
		mainpanel.add(greenpanel);
		mainpanel.add(purplepanel);

		f.add(mainpanel);
		


		//f.add(simon.SimonSaysLabel);

		f.setTitle("Simon Says");
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}    

}
