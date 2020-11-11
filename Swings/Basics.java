import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Basics extends JFrame implements ActionListener {
	
	private JTextField tf;
	private int c;
	
	Basics() {
		super("Basics");
		
		JLabel l = new JLabel("Learning Basics");
		l.setBounds(108, 20, 200, 100);
		add(l);
		
		JButton b = new JButton("Click Me!!");
		b.addActionListener(this);
		b.setBounds(50, 150, 200, 100);
		add(b);
		c = 0;
		
		tf = new JTextField();
		tf.setBounds(50, 300, 200, 100);
		add(tf);
		setSize(350, 500);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Basics();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tf.setText("You Clicked The Button " + ++c + " times");
	}
}
