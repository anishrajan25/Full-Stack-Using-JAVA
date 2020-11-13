import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRecordManager extends JFrame implements ActionListener {

	List<Student> students;
	JTextField rollNoJTF, nameJTF, marksJTF;
	ButtonGroup bg;

	StudentRecordManager() {
		students = new ArrayList();
//		students.add(new Student(1310, "Anish", 9.8));
//		students.add(new Student(1054, "Vai", 9.9));
//		students.add(new Student(1302, "Parteek", 9.5));
		JLabel nameJL = new JLabel("Enter Student's Name:"), rollNoJL = new JLabel("Enter Student's Roll Number:"), marksJL = new JLabel("Enter Student's Marks:");
		rollNoJTF = new JTextField();
		nameJTF = new JTextField();
		marksJTF = new JTextField();
		// Layout -> roll number input
		rollNoJL.setBounds(20, 20, 250, 30);
		rollNoJL.setFont(new Font("Calibri", Font.BOLD, 20));
		rollNoJL.setForeground(Color.RED);
		add(rollNoJL);
		rollNoJTF.setBounds(300, 20, 260, 30);
		rollNoJTF.setFont(new Font("Calibri", Font.BOLD, 20));
		add(rollNoJTF);
		// Layout -> name input
		nameJL.setBounds(20, 60, 250, 30);
		nameJL.setFont(new Font("Calibri", Font.BOLD, 20));
		nameJL.setForeground(Color.RED);
		add(nameJL);
		nameJTF.setBounds(300, 60, 260, 30);
		nameJTF.setFont(new Font("Calibri", Font.BOLD, 20));
		add(nameJTF);
		// Layout -> marks input
		marksJL.setBounds(20, 100, 250, 30);
		marksJL.setFont(new Font("Calibri", Font.BOLD, 20));
		marksJL.setForeground(Color.RED);
		add(marksJL);
		marksJTF.setBounds(300, 100, 260, 30);
		marksJTF.setFont(new Font("Calibri", Font.BOLD, 20));
		add(marksJTF);
		
		// Sorting Options
		JLabel sortJL = new JLabel("Sort By :");
		sortJL.setBounds(50, 160, 120, 30);
		sortJL.setFont(new Font("Calibri", Font.BOLD, 25));
		add(sortJL);
		JRadioButton name = new JRadioButton("Name"), roll_no = new JRadioButton("Roll Number"), marks = new JRadioButton("Marks");
		name.setBounds(180, 162, 100, 20);
		name.setFont(new Font("Calibri", Font.BOLD, 17));
		name.setActionCommand("Name");
		add(name);
		roll_no.setBounds(290, 162, 140, 20);
		roll_no.setFont(new Font("Calibri", Font.BOLD, 17));
		roll_no.setActionCommand("Roll Number");
		add(roll_no);
		marks.setBounds(450, 162, 100, 20);
		marks.setFont(new Font("Calibri", Font.BOLD, 17));
		marks.setActionCommand("Marks");
		add(marks);
		bg = new ButtonGroup();
		bg.add(name);
		bg.add(roll_no);
		bg.add(marks);
		
		// Buttons
		JButton sortJB = new JButton("Sort"), insertJB = new JButton("Insert"), displayJB = new JButton("Display");
		insertJB.setBounds(20, 210, 167, 30);
		insertJB.setFont(new Font("Calibri",Font.BOLD,20));
		insertJB.addActionListener(this);
		add(insertJB);
		sortJB.setBounds(208, 210, 167, 30);
		sortJB.setFont(new Font("Calibri",Font.BOLD,20));
		sortJB.addActionListener(this);
		add(sortJB);
		displayJB.setBounds(396, 210, 167, 30);
		displayJB.setFont(new Font("Calibri",Font.BOLD,20));
		displayJB.addActionListener(this);
		add(displayJB);
		
		
		// Frame Initialization
		setSize(600, 300);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentRecordManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = ((JButton)e.getSource()).getText();
		if(button.equals("Insert")) {
			try {
				String roll_no = rollNoJTF.getText();
				String name = nameJTF.getText();
				String marks = marksJTF.getText();
				if(roll_no.equals("") || name.equals("") || marks.equals("")) throw new Exception();
				students.add(new Student(Integer.valueOf(roll_no), name, Double.valueOf(marks)));
				JOptionPane.showMessageDialog(this, "Added Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid Inputs : Try Again", "Alert", JOptionPane.ERROR_MESSAGE);
			} finally {
				rollNoJTF.setText("");
				nameJTF.setText("");
				marksJTF.setText("");
			}
		} else if(button.equals("Display")) {
			String res = new String();
			for(Student s : students) {
				res += s.toString() + "\n";
			}
			JOptionPane.showMessageDialog(this, res, "Results", JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				String order = bg.getSelection().getActionCommand();
				if(order.equals("Marks")) {
					Collections.sort(students, (a, b) -> Double.compare(b.getMarks(), a.getMarks()));
				}
				else if(order.equals("Name")) {
					Collections.sort(students, (a, b) -> a.getName().compareTo(b.getName()));
				} 
				else {
					Collections.sort(students, (a, b) -> a.getRollNumber() - b.getRollNumber());
				}
				JOptionPane.showMessageDialog(this, "Records sorted by " + order , "Alert", JOptionPane.INFORMATION_MESSAGE);
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(this,"Please Select a Parameter you want to Sort By.","Alert",JOptionPane.ERROR_MESSAGE);
			} finally {
				bg.clearSelection();
			}
		}	
	}
}
class Student {
	private int rollNumber;
	private String name;
	private double marks;
	
	Student(int rn, String n, double m) {
		this.rollNumber = rn;
		this.name = n;
		this.marks = m;
	}
	
	public int getRollNumber() {
		return this.rollNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMarks() {
		return this.marks;
	}
	
	public String toString() {
		return "{" + " Roll Number : " + this.rollNumber +", Name : " + this.name + ", Marks : " +  this.marks + " }";
	}
}
