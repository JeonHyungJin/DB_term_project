package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.activation.DataSource;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class memberdatabse {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private DataSource ds = null;
	private Statement stmt = null;

	public memberdatabse() {
	}

	public void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/moviesystem?useSSL=false", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<memberentity> getMemberList() {
		connect();
		ArrayList<memberentity> list = new ArrayList<memberentity>();

		String SQL = "select * from MOVIE_MEMBER"; // sql Äõ¸®
		try {
			pstmt = (PreparedStatement) con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				memberentity member = new memberentity();

				member.setId(rs.getString("ID"));
				member.setPasswd(rs.getString("PASSWORD"));
				member.setPhone_number(rs.getString("PHONE_NUMBER"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setDate(rs.getString("BIRTH_DAY"));
				member.setBuy_list(rs.getInt("BUY_LIST"));
				member.setPoint(rs.getInt("POINT"));

				list.add(member);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	public boolean InsertMember(String id, String password, String phone_number, String name, String address,
			String birth_day) {
		connect();

		String SQL = "insert into MOVIE_MEMBER values(?,?,?,?,?,?,?,?)"; // sql

		try {
			
			pstmt = (PreparedStatement) con.prepareStatement(SQL);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			pstmt.setString(3,phone_number);
			pstmt.setString(4,name);
			pstmt.setString(5,address);
			pstmt.setString(6,birth_day);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			
			pstmt.executeUpdate();       
			
			return true;
			
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}finally {
			disconnect();
		}
	}
}
