package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBUtils;
import com.dao.CounselorDao;
import com.entity.Counselor;
import com.entity.Course;
import com.entity.JiaTiao;
import com.entity.KaoQin;
import com.mysql.cj.Session;

public class CounselorDaoImpl implements CounselorDao{
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<KaoQin> searchAttenByGrade(Integer grade,String dateString,Integer courseNo) {
		// TODO Auto-generated method stub
		
		String sql = null;
		KaoQin kaoQin = null;
		List<KaoQin> kaoQinList = new ArrayList<KaoQin>();
		
//		sql = "select * from attendance where grade=? and arriveTime like ? and courNo=?";
		sql = "select * from attendance where grade=? and arriveTime like concat('%',?,'%') and courNo=?";
//		sql = "select * from attendance where grade=2 and arriveTime like '%2019-12-04%' and courNo=1";
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, grade);
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

	public List<KaoQin> searchAttenByStu(Integer stuNo, String dateString, Integer courseNo) {
		// TODO Auto-generated method stub
		String sql = null;
		KaoQin kaoQin = null;
		List<KaoQin> kaoQinList = new ArrayList<KaoQin>();

//		sql = "select * from attendance where grade=? and arriveTime like concat('%',?,'%') and courNo=?";
		
		try {
			connection = DBUtils.getConnection();
			
//			if (courseNo == 0) {
//
//				sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%')";
//				preparedStatement = connection.prepareStatement(sql);
//				preparedStatement.setInt(1, stuNo);
//				preparedStatement.setString(2, dateString);
//			}
//			else {
//
//				sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%') and courNo=?";
//				preparedStatement = connection.prepareStatement(sql);
//				preparedStatement.setInt(1, stuNo);
//				preparedStatement.setString(2, dateString);
//				preparedStatement.setInt(3, courseNo);
//			}
			if (courseNo == 0) {
				if (dateString.equals("")) {
					sql = "select * from attendance where stuNo=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, stuNo);
				}else {
					sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%')";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, stuNo);
					preparedStatement.setString(2, dateString);
				}
				
			}
			else {
				if (dateString.equals("")) {
					sql = "select * from attendance where stuNo=? and courNo=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, stuNo);
					preparedStatement.setInt(2, courseNo);
				}else {
					sql = "select * from attendance where stuNo=? and arriveTime like concat('%',?,'%') and courNo=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, stuNo);
					preparedStatement.setString(2, dateString);
					preparedStatement.setInt(3, courseNo);
				}
				
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

	@Override
	public List<JiaTiao> getAllJiaTiao(Integer grade) {
		// TODO Auto-generated method stub
		String sql = null;
		JiaTiao jiaTiao = null;
		List<JiaTiao> jiaTiaoList = new ArrayList<JiaTiao>();
		sql = "select * from dayoff where grade=?";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, grade);
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

	@Override
	public List<JiaTiao> getSanctionedJiaTiao(Integer grade) {
		// TODO Auto-generated method stub
		String sql = null;
		JiaTiao jiaTiao = null;
		List<JiaTiao> jiaTiaoList = new ArrayList<JiaTiao>();
		sql = "select * from dayoff where status=1 and grade=?";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, grade);
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

	@Override
	public List<JiaTiao> getUnSanctionedJiaTiao(Integer grade) {
		// TODO Auto-generated method stub
		String sql = null;
		JiaTiao jiaTiao = null;
		List<JiaTiao> jiaTiaoList = new ArrayList<JiaTiao>();
		sql = "select * from dayoff where status=0 and grade=?";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, grade);
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

	@Override
	public List<JiaTiao> getFailedJiaTiao(Integer grade) {
		// TODO Auto-generated method stub
		String sql = null;
		JiaTiao jiaTiao = null;
		List<JiaTiao> jiaTiaoList = new ArrayList<JiaTiao>();
		sql = "select * from dayoff where status=2 and grade=?";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, grade);
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
	
	public JiaTiao getJiaTiaoById(Integer id) {
		String sql = null;
		JiaTiao jiaTiao = null;
		sql = "select * from dayoff where JTNo=?";
		System.out.println("dao:"+id);
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao:"+jiaTiao.toString());
		return jiaTiao;
	}

	@Override
	public void updateJiaTiaoStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		String sql = null;
		int result = 0;
		if (status == 1) {
//			同意批假
			sql = "update dayoff set status=1 where JTNo=?";
		}else {
//			拒绝批假
			sql = "update dayoff set status=2 where JTNo=?";
		}
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao  result:"+result);
		
	}

	@Override
	public void updateAttenStatus(Integer StuNo, Integer status) {
		// TODO Auto-generated method stub
		String sql = null;
		int result = 0;
		if (status == 1) {
//			同意批假    更新学生的出勤状态为请假
			sql = "update attendance set status=3 where StuNo=?";
		}else {
//			拒绝批假    更新学生的出勤状态为旷课
			sql = "update attendance set status=2 where StuNo=?";
		}
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, StuNo);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao  result:"+result);
	}

	@Override
	public Counselor getCounselorInfo(Integer counNo) {
		// TODO Auto-generated method stub
		String sql = null;
		int result = 0;
		sql = "select * from counselor where counNo=?";
		Counselor counselor = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, counNo);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				counselor = new Counselor();
				counselor.setCounNo(resultSet.getInt("counNo"));
				counselor.setCounName(resultSet.getString("counName"));
				counselor.setGrade(resultSet.getInt("grade"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		System.out.println("dao  counselor:"+counselor);
		return counselor;
	}

	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		Course course = null;
		List<Course> courseList = new ArrayList<Course>();
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
//				System.out.println("Dao:"+resultSet.getInt("courNo"));
				course = new Course();
				course.setCourNo(resultSet.getInt("courNo"));
				course.setCourName(resultSet.getString("courName"));
//				System.out.println("DAO:"+course.toString());
				courseList.add(course);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtils.releaseResource(connection, preparedStatement, resultSet);
		}
		return courseList;
	}

}
