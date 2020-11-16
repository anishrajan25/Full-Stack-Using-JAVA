import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Database {
	private Connection con;
	private Statement st;
	private PreparedStatement ps;

	Database() {
		con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","password");
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		try {
			ps = con.prepareStatement("create table prac_student(roll_no integer, sname varchar2(25), marks number(5,3))");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(int rno, String name, double m) {
		try {
			ps = con.prepareStatement("insert into prac_student values(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3, m);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMarks(int rno, double m) {
		try {
			ps = con.prepareStatement("update prac_student set marks=? where roll_no=?");
			ps.setDouble(1, m);
			ps.setInt(2, rno);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateName(int rno, String n) {
		try {
			ps = con.prepareStatement("update prac_student set sname=? where roll_no=?");
			ps.setString(1, n);
			ps.setInt(2, rno);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet display() {
		try {
			ResultSet rs = st.executeQuery("select * from prac_student");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteData(int rno) {
		try {
			ps = con.prepareStatement("delete from prac_student where roll_no=?");
			ps.setInt(1, rno);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void truncate() {
		try {
			ps = con.prepareStatement("truncate table prac_student");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dropTable() {
		try {
			st.execute("drop table prac_student");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
