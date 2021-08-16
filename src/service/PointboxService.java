package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PointboxDAO;
import dto.PointboxDTO;

import static db.JdbcUtil.getConnection;

public class PointboxService {

	public void AddStu(PointboxDTO pDto) {
		System.out.println(pDto);
		PointboxDAO pDao = PointboxDAO.getInstance();
		Connection con = getConnection();
		pDao.setConnection(con);
		
		pDao.AddStu(pDto);
		commit(con);
		
	}

	private void commit(Connection con) {
		// TODO Auto-generated method stub
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<PointboxDTO> getAllInfo() {
		 PointboxDAO pDao = PointboxDAO.getInstance();
		 Connection con = getConnection();
		 pDao.setConnection(con);
		 
		 ArrayList<PointboxDTO> getAllInfo = pDao.getAllInfo();
		 
		return getAllInfo;
	}

}
