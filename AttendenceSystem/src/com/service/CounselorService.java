package com.service;

import java.util.List;

import com.daoImpl.CounselorDaoImpl;
import com.entity.Counselor;
import com.entity.Course;
import com.entity.JiaTiao;
import com.entity.KaoQin;

public class CounselorService {
	CounselorDaoImpl counselorDaoImpl = new CounselorDaoImpl();
	
	public List<KaoQin> searchAttenByGrade(Integer grade,String dateString,Integer courseNo){
		List<KaoQin> kaoQinList = null;
		kaoQinList = counselorDaoImpl.searchAttenByGrade(grade, dateString, courseNo);
		return kaoQinList;
	}

	public List<KaoQin> searchAttenByStu(Integer stuNo, String dateString, Integer courseNo) {
		// TODO Auto-generated method stub
		List<KaoQin> kaoQinList = null;
		kaoQinList = counselorDaoImpl.searchAttenByStu(stuNo, dateString, courseNo);
		return kaoQinList;
	}
	
	public List<JiaTiao> getAllJiaTiao(Integer grade){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getAllJiaTiao(grade);
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getSanctionedJiaTiao(Integer grade){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getSanctionedJiaTiao(grade);
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getUnSanctionedJiaTiao(Integer grade){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getUnSanctionedJiaTiao(grade);
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getFailedJiaTiao(Integer grade){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getFailedJiaTiao(grade);
		return jiaTiaoList;
	}
	
	public JiaTiao getJiaTiaoById(Integer id) {
		JiaTiao jiaTiao = null;
		jiaTiao = counselorDaoImpl.getJiaTiaoById(id);
		return jiaTiao;
	}

	public void updateJiaTiaoStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		counselorDaoImpl.updateJiaTiaoStatus(id, status);
	}
	
	public void updateAttenStatus(Integer StuNo, Integer status) {
		// TODO Auto-generated method stub
		counselorDaoImpl.updateAttenStatus(StuNo, status);
	}
	
	public Counselor getCounselorInfo(Integer counNo) {
		Counselor counselor = null;
		counselor = counselorDaoImpl.getCounselorInfo(counNo);
		return counselor;
	}

	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		List<Course> courseList = null;
		courseList = counselorDaoImpl.getCourse();
		return courseList;
	}
}
