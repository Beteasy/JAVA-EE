package com.dao;

import java.util.List;

import com.entity.Counselor;
import com.entity.JiaTiao;
import com.entity.KaoQin;

public interface CounselorDao {
	public List<KaoQin> searchAttenByGrade(Integer grade,String dateString,Integer courseNo);
	public List<KaoQin> searchAttenByStu(Integer stuNo, String dateString, Integer courseNo);
	
	public List<JiaTiao> getAllJiaTiao();
	public List<JiaTiao> getSanctionedJiaTiao();
	public List<JiaTiao> getUnSanctionedJiaTiao();
	public List<JiaTiao> getFailedJiaTiao();
	
	public void updateJiaTiaoStatus(Integer id, Integer status);
	public void updateAttenStatus(Integer StuNo, Integer status);
	
	public Counselor getCounselorInfo(Integer counNo);
}
