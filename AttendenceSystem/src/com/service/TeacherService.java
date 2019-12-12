package com.service;

import java.util.List;

import com.daoImpl.TeacherDaoImpl;
import com.entity.JiaTiao;
import com.entity.KaoQin;

public class TeacherService {
//CounselorDaoImpl counselorDaoImpl = new CounselorDaoImpl();
	static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
	public List<KaoQin> searchAttenByClassId(Integer classId,String dateString,Integer courseNo){
		List<KaoQin> kaoQinList = null;
		kaoQinList = teacherDaoImpl.searchAttenByClassId(classId, dateString, courseNo);
		return kaoQinList;
	}

	public static List<KaoQin> searchAttenByStuNo(Integer stuNo, String dateString, Integer courseNo) {
		// TODO Auto-generated method stub
		List<KaoQin> kaoQinList = null;
		kaoQinList = teacherDaoImpl.searchAttenByStuNo(stuNo, dateString, courseNo);
		return kaoQinList;
	}
	
	public List<JiaTiao> getAllJiaTiao(){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = teacherDaoImpl.getAllJiaTiao();
		return jiaTiaoList;
	}
	
	
}
