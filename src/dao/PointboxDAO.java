package dao;

import java.sql.*;

import dto.PointboxDTO;

public class PointboxDAO {
	private static PointboxDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static PointboxDAO getInstance() {
		if(dao==null) {
			dao = new PointboxDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public void AddStu(PointboxDTO pDto) {
		String sql = "INSERT INTO POINTBOX VALUES(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pDto.getStclass());
			pstmt.setString(2, pDto.getStname());
			pstmt.setInt(3, pDto.getScore());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
