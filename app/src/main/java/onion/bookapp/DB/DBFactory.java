package onion.bookapp.DB;

import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.DB.Impl.GoodsDAOImpl;
import onion.bookapp.DB.Impl.GoodsDAOProxy;

public class DBFactory {

    public static GoodsDAO getInstance(){
        GoodsDAO dao=null;
        try{
            dao=new GoodsDAOProxy();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dao;
    }
}
