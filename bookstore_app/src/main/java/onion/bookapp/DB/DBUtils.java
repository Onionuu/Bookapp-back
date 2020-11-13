package onion.bookapp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * mysql的连接获取和释放
 *
 */
public class DBUtils {
    //数据库的URL
    private static String BaseURL = "jdbc:mysql://localhost:3306/app?";
    //名称
    private static String UserName = "root";
    //密码
    private static String Password = "123456";
    //连接
    private static Connection connection = null;

    static {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("找不到驱动类");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            String link = BaseURL +
                    "user=" + UserName + "&password=" + Password + "&useSSL=false&serverTimezone=GMT";
            System.out.println("link:" + link);
            connection = DriverManager.getConnection(link);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        if (connection == null) {
            System.out.println("数据库连接为空，不能进行释放");
            return;
        }
        try {
            connection.close();
            System.out.println("数据库关闭完成");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 判断数据库连接是否存活
     */
    public static boolean isConnectionSurvivor(Connection connection) {
        return connection != null;
    }
}
