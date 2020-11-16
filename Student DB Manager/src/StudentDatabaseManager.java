import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentDatabaseManager extends JFrame implements ActionListener {

    List<Student> students;
    Database db;
    JTextField rollNoJTF, nameJTF, marksJTF, update_rno_tf, updated_value_tf, delete_rno_tf;
    ButtonGroup bg, field;
    JComboBox cb;
    JPanel insert, update, delete, display;
    JTable table;
    
    public StudentDatabaseManager() {
        super("Student Database Manager");
        db = new Database();
        db.createTable();
        students = new ArrayList();
        
        // INSERT PANEL
        insert = new JPanel();
        insert.setLayout(null);
        insert.setBounds(20, 70, 800, 500);
        
        JLabel nameJL = new JLabel("Enter Student's Name:"), rollNoJL = new JLabel("Enter Student's Roll Number:"), marksJL = new JLabel("Enter Student's Marks:");
        rollNoJTF = new JTextField();
        nameJTF = new JTextField();
        marksJTF = new JTextField();
        // Layout -> roll number input
        rollNoJL.setBounds(20, 20, 250, 30);
        rollNoJL.setFont(new Font("Calibri", Font.BOLD, 20));
        rollNoJL.setForeground(Color.RED);
        insert.add(rollNoJL);
        rollNoJTF.setBounds(400, 20, 260, 30);
        rollNoJTF.setFont(new Font("Calibri", Font.BOLD, 20));
        insert.add(rollNoJTF);
        // Layout -> name input
        nameJL.setBounds(20, 80, 250, 30);
        nameJL.setFont(new Font("Calibri", Font.BOLD, 20));
        nameJL.setForeground(Color.RED);
        insert.add(nameJL);
        nameJTF.setBounds(400, 80, 260, 30);
        nameJTF.setFont(new Font("Calibri", Font.BOLD, 20));
        insert.add(nameJTF);
        // Layout -> marks input
        marksJL.setBounds(20, 140, 250, 30);
        marksJL.setFont(new Font("Calibri", Font.BOLD, 20));
        marksJL.setForeground(Color.RED);
        insert.add(marksJL);
        marksJTF.setBounds(400, 140, 260, 30);
        marksJTF.setFont(new Font("Calibri", Font.BOLD, 20));
        insert.add(marksJTF);
        JButton insertJB = new JButton("Insert");
        insertJB.setBounds(250, 210, 150, 30);
        insertJB.setFont(new Font("Calibri",Font.BOLD,20));
        insertJB.addActionListener(this);
        insert.add(insertJB);
//      add(insert);
        
        
        // UPDATE PANEL
        update = new JPanel();
        update.setLayout(null);
        update.setBounds(20, 70, 600, 280);
        JLabel updated_value = new JLabel("Enter Updated Value:"), update_rno = new JLabel("Enter Student's Roll Number:");
        update_rno_tf = new JTextField();
        updated_value_tf = new JTextField();
        // Layout -> roll number input
        update_rno.setBounds(20, 20, 250, 30);
        update_rno.setFont(new Font("Calibri", Font.BOLD, 20));
        update_rno.setForeground(Color.RED);
        update.add(update_rno);
        update_rno_tf.setBounds(400, 20, 260, 30);
        update_rno_tf.setFont(new Font("Calibri", Font.BOLD, 20));
        update.add(update_rno_tf);
        // Radio Button select Field
        JLabel select_field = new JLabel("Select the field to be updated: ");
        select_field.setBounds(20, 80, 260, 30);
        select_field.setFont(new Font("Calibri", Font.BOLD, 17));
        field = new ButtonGroup();
        JRadioButton update_name = new JRadioButton("Name"), update_marks = new JRadioButton("Marks");
        update_name.setBounds(400, 80, 100, 30);
        update_name.setFont(new Font("Calibri", Font.BOLD, 17));
        update_name.setActionCommand("Name");
        update_marks.setBounds(480, 80, 100, 30);
        update_marks.setFont(new Font("Calibri", Font.BOLD, 17));
        update_marks.setActionCommand("Marks");
        field.add(update_marks);
        field.add(update_name);
        update.add(update_marks);
        update.add(select_field);
        update.add(update_name);
        // Layout -> updated input
        updated_value.setBounds(20, 125, 250, 30);
        updated_value.setFont(new Font("Calibri", Font.BOLD, 20));
        updated_value.setForeground(Color.RED);
        update.add(updated_value);
        updated_value_tf.setBounds(400, 125, 260, 30);
        updated_value_tf.setFont(new Font("Calibri", Font.BOLD, 20));
        update.add(updated_value_tf);
        JButton updateJB = new JButton("Update");
        updateJB.setFont(new Font("Calibri",Font.BOLD,20));
        updateJB.setBounds(250, 200, 150, 30);
        updateJB.addActionListener(this);
        update.add(updateJB);
        

        // DELETE PANEL
        delete = new JPanel();
        delete.setLayout(null);
        delete.setBounds(20, 70, 600, 280);
        JLabel delete_rno = new JLabel("Enter Student's Roll Number:", JLabel.CENTER);
        delete_rno_tf = new JTextField();
        // Layout -> roll number input
        delete_rno.setBounds(200, 20, 250, 30);
        delete_rno.setFont(new Font("Calibri", Font.BOLD, 20));
        delete_rno.setForeground(Color.RED);
        delete.add(delete_rno);
        delete_rno_tf.setBounds(200, 80, 250, 30);
        delete_rno_tf.setFont(new Font("Calibri", Font.BOLD, 20));
        delete.add(delete_rno_tf);
        JButton deleteJB = new JButton("Delete");
        deleteJB.setFont(new Font("Calibri",Font.BOLD,20));
        deleteJB.setBounds(250, 150, 150, 30);
        deleteJB.addActionListener(this);
        delete.add(deleteJB);
        
        
        // DISPLAY PANEL
        display = new JPanel();
        display.setBounds(20, 70, 400, 400);
        display.setLayout(null);
        JButton disp = new JButton("Display");
        disp.setFont(new Font("Calibri",Font.BOLD,20));
        disp.setBounds(20, 200, 120, 30);
        disp.addActionListener(this);
        this.displayTable(null);
        
        // Sorting Options
        JLabel sortJL = new JLabel("Sort By :");
        sortJL.setBounds(20, 20, 100, 30);
        sortJL.setFont(new Font("Calibri", Font.BOLD, 20));
        display.add(sortJL);
        JRadioButton name = new JRadioButton("Name"), roll_no = new JRadioButton("Roll Number"), marks = new JRadioButton("Marks");
        name.setBounds(25, 60, 100, 20);
        name.setFont(new Font("Calibri", Font.BOLD, 17));
        name.setActionCommand("Name");
        display.add(name);
        roll_no.setBounds(25, 90, 140, 20);
        roll_no.setFont(new Font("Calibri", Font.BOLD, 17));
        roll_no.setActionCommand("Roll Number");
        display.add(roll_no);
        marks.setBounds(25, 120, 100, 20);
        marks.setFont(new Font("Calibri", Font.BOLD, 17));
        marks.setActionCommand("Marks");
        display.add(marks);
        bg = new ButtonGroup();
        bg.add(name);
        bg.add(roll_no);
        bg.add(marks);
        display.add(disp);

        // TABBED PANE
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0, 0, 685, 461);
        tp.add("Insert", insert);
        tp.add("Update", update);
        tp.add("Delete", delete);
        tp.add("Display", display);
        add(tp);
        // Frame Initialization
        setSize(700, 500);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new StudentDatabaseManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String clicked = ((JButton)e.getSource()).getText();
        if(clicked.equals("Select")) {
            String panel = String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
            if(panel.equals("Delete")) {
                remove(insert);
                remove(update);
                remove(display);
                add(delete);
            } else if(panel.equals("Update")) {
                remove(insert);
                remove(delete);
                remove(display);
                add(update);
            } else if(panel.equals("Display")) {
                remove(insert);
                remove(update);
                remove(delete);
                add(display);
            } else {
                remove(delete);
                remove(update);
                remove(display);
                add(insert);
            }
//          setVisible(false);
//          setVisible(true);
            setSize(700, 499);
            setSize(700, 500);
        }
        else if(clicked.equals("Insert")) {
            try {
                String roll_no = rollNoJTF.getText();
                String name = nameJTF.getText();
                String marks = marksJTF.getText();
                if(roll_no.equals("") || name.equals("") || marks.equals("")) throw new Exception();
                db.insertData(Integer.valueOf(roll_no), name , Double.valueOf(marks));
                JOptionPane.showMessageDialog(this, "Added Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Inputs : Try Again", "Alert", JOptionPane.ERROR_MESSAGE);
            } finally {
                rollNoJTF.setText("");
                nameJTF.setText("");
                marksJTF.setText("");
            }
        }
        else if(clicked.equals("Delete")) {
            try {
                String rno = delete_rno_tf.getText();
                if(rno.equals("")) throw new Exception();
                db.deleteData(Integer.valueOf(rno));
                JOptionPane.showMessageDialog(this, "Deleted Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Inputs : Try Again", "Alert", JOptionPane.ERROR_MESSAGE);
            } finally {
                delete_rno_tf.setText("");
            }
        }
        else if(clicked.equals("Update")) {
            try {
                String rno = update_rno_tf.getText();
                String update = updated_value_tf.getText();
                String col = field.getSelection().getActionCommand();
                if(rno.equals("") || update.equals("") || col == null || col.equals("")) throw new Exception();
                if(col.equals("Name")) {
                    db.updateName(Integer.valueOf(rno), update);
                } else {
                    db.updateMarks(Integer.valueOf(rno), Double.valueOf(update));
                }
                JOptionPane.showMessageDialog(this, "Updated " + col + " Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Inputs : Try Again", "Alert", JOptionPane.ERROR_MESSAGE);
            } finally {
                update_rno_tf.setText("");
                updated_value_tf.setText("");
                field.clearSelection();
            }
        }
        else if(clicked.equals("Display")) {
        	
        }
    }
    
    private void displayTable(String order) {
        
    }
}
