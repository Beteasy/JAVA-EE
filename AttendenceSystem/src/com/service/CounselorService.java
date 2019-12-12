package com.service;

import java.util.List;

import com.daoImpl.CounselorDaoImpl;
import com.entity.Counselor;
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
	
	public List<JiaTiao> getAllJiaTiao(){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getAllJiaTiao();
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getSanctionedJiaTiao(){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getSanctionedJiaTiao();
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getUnSanctionedJiaTiao(){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getUnSanctionedJiaTiao();
		return jiaTiaoList;
	}
	
	public List<JiaTiao> getFailedJiaTiao(){
		List<JiaTiao> jiaTiaoList = null;
		jiaTiaoList = counselorDaoImpl.getFailedJiaTiao();
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
}
