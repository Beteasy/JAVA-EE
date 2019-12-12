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

public interface StuKaoqinDao {
	public KaoQin getKaoqin(int stuNo,int courNo,Date date);
	public List<KaoQin> getKaoqintByCourNo(int stuNo,int courNo);
	public List<KaoQin> getKaoqintByDate(int stuNo,Date date);
	public List<KaoQin> getAllKaoqint(int stuNo);
}
