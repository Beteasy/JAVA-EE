package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DBUtils.DBUtils;
import com.entity.KaoQin;

public class StuKaoqinDaoImpl {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	
	public KaoQin getKaoqin(int stuNo,int courNo,Date date) {
		KaoQin kaoqin = new KaoQin();
		return kaoqin;
	}
	public List<KaoQin> getKaoqintByCourNo(int stuNo,int courNo){
		List<KaoQin> kaoqinList = new ArrayList<KaoQin>();
		return kaoqinList;
	}
	public List<KaoQin> getKaoqintByDate(int stuNo,Date date){
		List<KaoQin> kaoqinList = new ArrayList<KaoQin>();
		return kaoqinList;
	}
	
	public List<KaoQin> getAllKaoqin(int stuNo){
		String sql = "select * from attendance where stuNo="+stuNo;
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
				kaoqin.setClassId(res.getInt("classId"));
				kaoqin.setCourNo(res.getInt("courNo"));
				kaoqin.setGrade(res.getInt("grade"));
				kaoqin.setDate(res.getDate("arriveTime"));
				kaoqin.setStatus(res.getInt("status"));
				kaoqinList.add(kaoqin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.releaseResource(conn, pre, res);
		}
		System.out.print(kaoqinList.toString());
		return kaoqinList;
		
	}
}
