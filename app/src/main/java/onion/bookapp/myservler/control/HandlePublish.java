package onion.bookapp.myservler.control;

import onion.bookapp.DB.DBUtils;
import onion.bookapp.DB.Impl.GoodsDAOImpl;
import onion.bookapp.mybean.data.Goods;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HandlePublish extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int goodsid=Integer.parseInt(req.getParameter("goodsid"));
        int publisherid=Integer.parseInt(req.getParameter("publisherid"));
        double price=Double.parseDouble(req.getParameter("price"));
        Goods goods=new Goods();
        GoodsDAOImpl impl=new GoodsDAOImpl(DBUtils.getConnection());
        resp.setContentType("application/json");
        PrintWriter writer=resp.getWriter();
        Map<String,String> map=new HashMap<String, String>();
        if (impl.insert(goods)){
            map.put("status","success");
        }
        else{
            map.put("status","fail");
        }
        writer.write(map.toString());
    }

}
