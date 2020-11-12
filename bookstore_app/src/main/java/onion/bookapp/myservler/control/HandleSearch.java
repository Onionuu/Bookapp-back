package onion.bookapp.myservler.control;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import onion.bookapp.DB.DBUtils;
import onion.bookapp.DB.Impl.GoodsDAOImpl;
import onion.bookapp.DB.Impl.GoodsDAOProxy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name ="SearchServlet",urlPatterns="/SearchServlet")
public class HandleSearch extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
        GoodsDAOProxy proxy = new GoodsDAOProxy();
        String keyword = req.getParameter("words");
        ResultSet rs=proxy.search(keyword);
        JSONArray array = new JSONArray();
           while (rs.next()){
               JSONObject json = new JSONObject();
               String imagePath = rs.getString("images");
               FileInputStream fin = new FileInputStream(new File(imagePath));
               byte[] bytes = new byte[fin.available()];
               fin.read(bytes);
               String title = rs.getString("title");
               String price = rs.getString("price");
               json.put("primaryImage",bytes);
               json.put("title",title);
               json.put("price",price);
               array.add(json);
           }
           resp.setContentType("application/json");
           resp.setCharacterEncoding("utf-8");
           PrintWriter out = resp.getWriter();
           out.write(array.toString());
           out.flush();
           out.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        doPost(request,response);
    }
}
