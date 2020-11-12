import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.DB.Impl.GoodsDAOProxy;
import onion.bookapp.mybean.data.Goods;

public class daotest {
    public static void main(String[] args) throws Exception {
        Goods goods=new Goods("goodsidtest","publisheridtest","imagestest","publishTimetest","titletest","detailtest","sorttest","pricetest");
        GoodsDAO dao= new GoodsDAOProxy();
        dao.insert(goods);
    }
}
