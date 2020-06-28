package cydemotwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
	
	 public static Connection getConnection() throws SQLException {
	        Connection conn = null;
	        String url = ConstantsUtils.DRIVER_URL + "user=" + ConstantsUtils.USERNAME + "&password=" + ConstantsUtils.PASSWORD + "&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
	            System.out.println("成功加载MySQL驱动程序");
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

}
