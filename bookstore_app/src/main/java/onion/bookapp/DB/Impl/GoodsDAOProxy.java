package onion.bookapp.DB.Impl;

import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.DB.DBUtils;
import onion.bookapp.mybean.data.Goods;

import java.sql.ResultSet;

/**
 * dao代理，用于生成impl实例
 */
public class GoodsDAOProxy implements GoodsDAO {
    private DBUtils dbUtils;
    private GoodsDAO dao=null;
    public GoodsDAOProxy() throws Exception{
        dbUtils=new DBUtils();
        dao=new GoodsDAOImpl(dbUtils.getConnection());
    }
    public boolean insert(Goods goods) {
        boolean flag=false;
        if(dao.insert(goods)){
            DBUtils.closeConnection();
            return true;
        }
        return false;
    }

    public ResultSet search(String keyword) {
        return dao.search(keyword);
    }
}
