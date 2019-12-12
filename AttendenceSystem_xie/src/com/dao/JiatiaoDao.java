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

	public class JiatiaoDao {
		
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;

		public JiaTiao getJiatiao(int stuNo,int courNo,String content,int type,Date startdate,Date enddate) {

			JiaTiao jiatiao = new JiaTiao();
			int id = 1;
			
			try {
				Connection conn = DBUtils.getConnection();
				String sql = "select * from dayoff";
				pre = conn.prepareStatement(sql);
				res = pre.executeQuery();
				while (res.next()) {
					id++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Connection conn = DBUtils.getConnection();
				String sql = "select * from student where stuNo="+stuNo;
				pre = conn.prepareStatement(sql);
				res = pre.executeQuery();
				while (res.next()) {
					jiatiao.setId(id);
					jiatiao.setStuNo(stuNo);
					jiatiao.setStuName(res.getString("stuName"));
					jiatiao.setCourNo(courNo);
					jiatiao.setClassId(res.getInt("classId"));
					jiatiao.setGrade(res.getInt("grade"));
					jiatiao.setType(type);
					jiatiao.setContent(content);
					jiatiao.setStatus(0);
					jiatiao.setStartdate(startdate);
					jiatiao.setEnddate(enddate);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jiatiao;
		}
		
		public List<JiaTiao> getAlljiatiao(int stuNo) {
			// TODO Auto-generated method stub
			String sql = "select * from dayoff where stuNo="+stuNo;
			JiaTiao jiatiao = null;
			List<JiaTiao> jiatiaoList = new ArrayList<JiaTiao>();
			
			try {
				conn = DBUtils.getConnection();
				pre = conn.prepareStatement(sql);
				res = pre.executeQuery();
				while (res.next()) {
					jiatiao = new JiaTiao();
					jiatiao.setId(res.getInt("JTNo"));
					jiatiao.setStuNo(res.getInt("stuNo"));
					jiatiao.setStuName(res.getString("stuName"));
					jiatiao.setCourNo(res.getInt("courNo"));
					jiatiao.setClassId(res.getInt("classId"));
					jiatiao.setGrade(res.getInt("grade"));
					jiatiao.setType(res.getInt("type"));;
					jiatiao.setContent(res.getString("content"));
					jiatiao.setStatus(res.getInt("status"));
					jiatiao.setStartdate(res.getDate("startdate"));
					jiatiao.setEnddate(res.getDate("enddate"));
					jiatiaoList.add(jiatiao);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.releaseResource(conn, pre, res);
			}
			return jiatiaoList;
		}
	}

