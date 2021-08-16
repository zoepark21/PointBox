package dao;

import java.sql.*;
import java.util.ArrayList;

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

	public ArrayList<PointboxDTO> getAllInfo() {
		String sql ="select * from pointbox";
		ArrayList<PointboxDTO> getAllInfo = new ArrayList<PointboxDTO>();
		PointboxDTO pDto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pDto = new PointboxDTO();
				pDto.setStclass(rs.getString("stclass"));
				pDto.setStname(rs.getString("stname"));
				pDto.setScore(rs.getInt("score"));
				
				getAllInfo.add(pDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllInfo;
	}
}
