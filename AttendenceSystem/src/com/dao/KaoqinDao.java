package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.DBUtils.DBUtils;
import com.entity.*;

public class KaoqinDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	
	public KaoQin getKaoqom(int stuNo,int courNo,Date date) {

		KaoQin kaoqin = new KaoQin();
		
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "select * from attendence where stuNo="+stuNo;
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				kaoqin.setStuNo(stuNo);
				kaoqin.setStuName(res.getString("stuName"));
				kaoqin.setCourNo(courNo);
				kaoqin.setClassId(res.getInt("classId"));
				kaoqin.setStatus(res.getInt("status"));
				kaoqin.setDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kaoqin;
	}
	
	public List<KaoQin> getAllKaoqin(int stuNo) {
		// TODO Auto-generated method stub
		String sql = "select * from attendence where stuNo="+stuNo;
		KaoQin kaoqin = null;
		List<KaoQin> kaoqinList = new ArrayList<KaoQin>();
		
		try {
			conn = DBUtils.getConnection();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				kaoqin = new KaoQin();
				kaoqin.setStuNo(stuNo);
				kaoqin.setStuName(res.getString("stuName"));
				kaoqin.setCourNo(res.getInt("courNo"));
				kaoqin.setClassId(res.getInt("classId"));
				kaoqin.setStatus(res.getInt("status"));
				kaoqin.setDate(res.getDate("arriveTime"));
				kaoqinList.add(kaoqin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.releaseResource(conn, pre, res);
		}
		return kaoqinList;
	}
}
