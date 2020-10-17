import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.DB.DBUtils;
import onion.bookapp.DB.Impl.GoodsDAOImpl;
import onion.bookapp.mybean.data.Goods;

public class daotest {
    public static void main(String[] args) {
        Goods goods=new Goods(123,456,"",23.5);
        GoodsDAOImpl goodsdaoinmpl=new GoodsDAOImpl(DBUtils.getConnection());
        goodsdaoinmpl.insert(goods);
    }
}
