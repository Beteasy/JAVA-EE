package com.service;

import java.util.ArrayList;
import java.util.*;

import com.daoImpl.*;
import com.dao.*;
import com.entity.JiaTiao;
import com.entity.KaoQin;
import com.entity.Student;

public class StuService {

	public List<JiaTiao> getAllQingjia(Integer stuNo){
		List<JiaTiao> jiatiaoList = null;
		JiatiaoDao jd = new JiatiaoDao();
		jiatiaoList = jd.getAlljiatiao(stuNo);
		return jiatiaoList;
	}
	public List<KaoQin> getAllKaoqin(Integer stuNo){
		List<KaoQin> kaoqinList = null;
		StuKaoqinDaoImpl jd = new StuKaoqinDaoImpl();
		kaoqinList = jd.getAllKaoqin(stuNo);
		return kaoqinList;
	}
}
