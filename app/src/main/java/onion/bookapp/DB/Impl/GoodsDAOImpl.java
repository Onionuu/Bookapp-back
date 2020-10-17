package onion.bookapp.DB.Impl;

import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.mybean.data.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GoodsDAOImpl implements GoodsDAO {
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    public GoodsDAOImpl(Connection conn){this.conn=conn;}
    public boolean insert(Goods goods) {
        boolean flag=false;
        String sql="Insert into goods(goodsid,publisherid,images,timestamp,price)Values(?,?,?,?,?)";
        try {
            this.pstmt=this.conn.prepareStatement(sql);
            this.pstmt.setInt(1,goods.getGoodsid());
            this.pstmt.setInt(2,goods.getPublisherid());
            this.pstmt.setString(3,goods.getImages());
            this.pstmt.setLong(4,System.currentTimeMillis());
            this.pstmt.setDouble(5,goods.getPrice());
            if (this.pstmt.executeUpdate()>0){
                flag=true;
            }
            this.pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

}
