package assignment8;
/**
* @author Rexus 
* @version Build Time：Nov 9, 2018 3:28:46 AM
* @Explain
*/

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class StudentsApplication extends JFrame {

	private JTable studentsTable;
	private JPanel addPanel;
	private JLabel addLabel;
	private JButton add;
	private JScrollPane jsp;

	public StudentsApplication(Students students) {
		StudentsTableModel model = new StudentsTableModel(students);
		studentsTable = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(studentsTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel addNewStudentPanel = new JPanel(new FlowLayout());
		
		JTextField ID = new JTextField("ID:");
		JTextField fn = new JTextField("FirstName:");
		JTextField ln = new JTextField("LastName:");
		JTextField gender = new JTextField("Gender: M/F");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
	
		JLabel label1 = new JLabel("ID:");
		p1.add(label1);
		p1.add(ID);
		
		JLabel label2 = new JLabel("First name:");
		p1.add(label2);
		p1.add(fn);
		
		JLabel label3 = new JLabel("Last name:");
		p1.add(label3);
		p1.add(ln);
		
		JLabel label4 = new JLabel("Gender: M/F");
		p1.add(label4);
		p1.add(gender);
		
		addNewStudentPanel.add(p1);
		addNewStudentPanel.add(p2);
		addNewStudentPanel.add(p3);
		addNewStudentPanel.add(p4);
		
		
		
		add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(ID.getText());
				String firstname = fn.getText();
				String lastname = ln.getText();
				boolean isMale = false;
				if(gender.getText() == "M") 
					isMale = true;
				else if(gender.getText() == "F")
					isMale = false;
				
				Student s = new Student(roll, firstname, lastname, isMale);
				students.addStudent(s);
				studentsTable.validate();
				studentsTable.updateUI();
			}
		});
		addNewStudentPanel.add(add);
		
		JFrame frame = new JFrame("Students Info Management System");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jsp, BorderLayout.CENTER);
        frame.add(addNewStudentPanel, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setLocation(150, 150);
        frame.pack();
        frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Students s = new Students();
		s.addStudent(new Student(100, "Divya", "Sharma", true));
		s.addStudent(new Student(101, "Mihir", "Salunke", false));
		new StudentsApplication(s);

	}

}

class Students {
	private Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;

	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}

class Student {
	int roll;
	String first;
	String last;
	boolean gender = false;

	public Student(int roll, String first, String last, boolean gender) {
		this.roll = roll;
		this.first = first;
		this.last = last;
		this.gender = gender;
	}
}

class StudentsTableModel implements TableModel {

	private Students students;

	public StudentsTableModel(Students students) {
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ROLL";
		}
		if (columnIndex == 1) {
			return "First";
		}
		if (columnIndex == 2)
			return "Last";
		if (columnIndex == 3)
			return "Gender";
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 3) {
			return Boolean.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.roll + "";
				}
				if (columnIndex == 1) {
					return student.first;
				}
				if (columnIndex == 2) {
					return student.last;
				}
				if (columnIndex == 3) {
					return student.gender;
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}

class NewStudentPanel {
	
	
	private Student student;
	private Students students;
	public NewStudentPanel(Students students) {
		this.students = students;
		JPanel addNewStudentPanel = new JPanel(new FlowLayout());
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JTextField ID = new JTextField();
		ID.setBounds(new Rectangle(200, 15, 200, 15));
		JTextField fn = new JTextField();
		fn.setBounds(new Rectangle(200, 15, 200, 15));
		JTextField ln = new JTextField();
		ln.setBounds(new Rectangle(200, 15, 200, 15));
		JTextField gender = new JTextField();
		gender.setBounds(new Rectangle(200, 15, 200, 15));
		
		JPanel p1 = new JPanel();
		p1.setBounds(220,15,200,15);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel label1 = new JLabel("ID:");
		p1.add(label1);
		p1.add(ID);
		
		JLabel label2 = new JLabel("First name:");
		p1.add(label2);
		p1.add(fn);
		
		JLabel label3 = new JLabel("Last name:");
		p1.add(label3);
		p1.add(ln);
		
		JLabel label4 = new JLabel("Gender:");
		p1.add(label4);
		p1.add(gender);
		
		addNewStudentPanel.add(p1);
		addNewStudentPanel.add(p2);
		addNewStudentPanel.add(p3);
		addNewStudentPanel.add(p4);
		addNewStudentPanel.add(add);
		
	}
	/*
	public Object getValue() {
		int roll = Integer.parseInt(ID.getText);
		String fn = fn.getText;
		String ln = ln.getText;
		boolean gender;
		if(gender.getText == "M") 
			gender = true;
		else if(gender.getText == "F")
			gender = false;
		else 
			throw new warning("Wrong gender input;");
		student s = new Student(roll, fn, ln, gender);
		return student;
	}
	*/
}



