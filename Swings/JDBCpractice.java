import java.sql.*;

public class JDBCpractice {
	private Connection con;
	private Statement st;
	private PreparedStatement ps;

	JDBCpractice() {
		con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBCpractice","Anish@2708");
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(int rno, String name, double m) {
		try {
			ps = con.prepareStatement("insert into practiceStudent values(?,?,?)");
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
			ps = con.prepareStatement("update practiceStudent set marks=? where roll_no=?");
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
			ps = con.prepareStatement("update practiceStudent set sname=? where roll_no=?");
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
			ResultSet rs = st.executeQuery("select * from practiceStudent");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
			System.out.println();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteData(int rno) {
		try {
			ps = con.prepareStatement("delete from practiceStudent where roll_no=?");
			ps.setInt(1, rno);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCpractice db = new JDBCpractice();
		db.insertData(1, "Anish", 9.89);
		db.insertData(2, "Parteek", 89);
		db.insertData(3, "Anni", 75);
		db.display();
		db.updateMarks(2, 96);
		db.display();
		db.deleteData(3);
		db.display();
	}
}
