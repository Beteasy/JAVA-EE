package com.dao;
import java.util.List;
import com.entity.JiaTiao;
import com.entity.KaoQin;
public interface TeacherDao {
	public List<KaoQin> searchAttenByClassId(Integer classId,String dateString,Integer courseNo);
	public List<KaoQin> searchAttenByStuNo(Integer stuNo, String dateString, Integer courseNo);
	public List<JiaTiao> getAllJiaTiao();
}
