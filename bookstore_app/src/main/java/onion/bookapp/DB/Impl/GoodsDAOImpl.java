package onion.bookapp.DB.Impl;

import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.mybean.data.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDAOImpl implements GoodsDAO {
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    public GoodsDAOImpl(Connection conn){this.conn=conn;}
    public boolean insert(Goods goods) {
        boolean flag=false;
        String sql="Insert into goods(goodsid,publisherid,images,publishTime,price,title,detail,sort)Values(?,?,?,?,?,?,?,?)";
        try {
            this.pstmt=this.conn.prepareStatement(sql);
            this.pstmt.setString(1,goods.getGoodsid());
            this.pstmt.setString(2,goods.getPublisherid());
            this.pstmt.setString(3,goods.getImages());
            this.pstmt.setString(4,goods.getPublishTime());
            this.pstmt.setString(5,goods.getTitle());
            this.pstmt.setString(6,goods.getDetail());
            this.pstmt.setString(7,goods.getSort());
            this.pstmt.setString(8,goods.getPrice());
            if (this.pstmt.executeUpdate()>0){
                flag=true;
            }
            this.pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ResultSet search(String keyword) {
        try{
            String sql = "select images,title,price from goods where title like ? or detail like ?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"%"+keyword+"%");
            pstmt.setString(2,"%"+keyword+"%");
            return pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
