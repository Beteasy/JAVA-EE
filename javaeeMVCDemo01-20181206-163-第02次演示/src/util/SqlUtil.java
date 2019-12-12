package util;

/**
 * 实现分页、多条件查询等工具类
 * @author fhzheng
 *
 */
public class SqlUtil {

	/**
	 * 分页查询控制子句参数
	 * @param page	当前页
	 * @param recordOfPage 每一页的记录数
	 * @return 查询的limit子句
	 */
	public static String getPageSql(int page,int recordOfPage) {
		
		return " limit "+((page-1)*recordOfPage)+" , "+recordOfPage;
	}
}
