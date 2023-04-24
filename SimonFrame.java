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

		JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.BLUE);

        JPanel yellowpanel = new JPanel();
        yellowpanel.setBackground(Color.YELLOW);

		JPanel redpanel = new JPanel();
        bluepanel.setBackground(Color.RED);

        JPanel greenpanel = new JPanel();
        yellowpanel.setBackground(Color.GREEN);
		
		//f.setLayout(new GridLayout(2,3, 10, 10));
		mainpanel.setLayout(new GridLayout(2,3, 10, 10));
		//panel.add(simon);
		f.add(sc);
		//f.add(simon);
		mainpanel.add(simon);
		mainpanel.add(redpanel);
		mainpanel.add(bluepanel);
		mainpanel.add(yellowpanel);
		mainpanel.add(greenpanel);
		f.add(mainpanel);
		


		//f.add(simon.SimonSaysLabel);

		f.setTitle("Simon Says");
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}    

}
