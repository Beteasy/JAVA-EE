package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBUtils;
import com.dao.TeacherDao;
import com.entity.JiaTiao;
import com.entity.KaoQin;

public class TeacherDaoImpl implements TeacherDao{

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public List<KaoQin> searchAttenByClassId(Integer classId, String dateString, Integer courseNo) {
		String sql = null;
		KaoQin kaoQin = null;
		List<KaoQin> kaoQinList = new ArrayList<KaoQin>();
		sql = "select * from attendance where classId=? and arriveTime like concat('%',?,'%') and courNo=?";		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, classId);
			preparedStatement.setString(2, dateString);
			preparedStatement.setInt(3, courseNo);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				kaoQin = new KaoQin();
				kaoQin.setStuNo(resultSet.getInt("stuNo"));
				kaoQin.setStuName(resultSet.getString("stuName"));
				kaoQin.setGrade(resultSet.getInt("grade"));
				kaoQin.setClassId(resultSet.getInt("classId"));
				kaoQin.setCourNo(resultSet.getInt("courNo"));
				kaoQin.setDate(resultSet.getDate("arriveTime"));
				kaoQin.setStatus(resultSet.getInt("status"));
				kaoQinList.add(kaoQin);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		return kaoQinList;
	}

	public List<KaoQin> searchAttenByStuNo(Integer stuNo, String dateString, Integer courseNo) {
		// TODO Auto-generated method stub
		String sql = null;
		KaoQin kaoQin = null;
		List<KaoQin> kaoQinList = new ArrayList<KaoQin>();

		sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%') and courNo=?";
		
		try {
			connection = DBUtils.getConnection();
			if (courseNo == 0) {

				sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%')";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, stuNo);
				preparedStatement.setString(2, dateString);
			}
			else {

				sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%') and courNo=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, stuNo);
				preparedStatement.setString(2, dateString);
				preparedStatement.setInt(3, courseNo);
			}
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				kaoQin = new KaoQin();
				kaoQin.setStuNo(resultSet.getInt("stuNo"));
				kaoQin.setStuName(resultSet.getString("stuName"));
				kaoQin.setGrade(resultSet.getInt("grade"));
				kaoQin.setClassId(resultSet.getInt("classId"));
				kaoQin.setCourNo(resultSet.getInt("courNo"));
				kaoQin.setDate(resultSet.getDate("arriveTime"));
				kaoQin.setStatus(resultSet.getInt("status"));
				System.out.println("status"+resultSet.getInt("status"));
				kaoQinList.add(kaoQin);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao:"+kaoQinList.toString());
		return kaoQinList;
	}

	public List<JiaTiao> getAllJiaTiao() {
		// TODO Auto-generated method stub
		String sql = null;
		JiaTiao jiaTiao = null;
		List<JiaTiao> jiaTiaoList = new ArrayList<JiaTiao>();
		sql = "select * from dayoff";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				jiaTiao = new JiaTiao();
				jiaTiao.setId(resultSet.getInt("JTNo"));
				jiaTiao.setStuNo(resultSet.getInt("stuNo"));
				jiaTiao.setStuName(resultSet.getString("stuName"));
				jiaTiao.setGrade(resultSet.getInt("grade"));
				jiaTiao.setClassId(resultSet.getInt("classId"));
				jiaTiao.setCourNo(resultSet.getInt("courNo"));
				jiaTiao.setStartdate(resultSet.getDate("startdate"));
				jiaTiao.setEnddate(resultSet.getDate("enddate"));
				jiaTiao.setStatus(resultSet.getInt("status"));
				jiaTiao.setType(resultSet.getInt("type"));
				jiaTiao.setContent(resultSet.getString("content"));
				jiaTiaoList.add(jiaTiao);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao:"+jiaTiaoList.toString());
		return jiaTiaoList;
	}

	

}


