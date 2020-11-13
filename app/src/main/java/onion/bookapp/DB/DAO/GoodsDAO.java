package onion.bookapp.DB.DAO;

import onion.bookapp.mybean.data.Goods;

public interface GoodsDAO {
    //插入商品
    public  boolean insert(Goods goods) throws Exception;
}
