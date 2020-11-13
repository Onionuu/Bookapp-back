import onion.bookapp.DB.DAO.GoodsDAO;
import onion.bookapp.DB.Impl.GoodsDAOProxy;
import onion.bookapp.mybean.data.Goods;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class daotest {
    @Test
    public void test() throws Exception {
        FileInputStream fin = new FileInputStream(new File("C:\\Users\\ccaihuixin\\Pictures\\icon.jpg"));
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        inputStream2File(new ByteArrayInputStream(bytes),"./picture.jpg");
    }

    public static void main(String[] args) throws Exception {
        Goods goods=new Goods("goodsidtest","publisheridtest","imagestest","publishTimetest","titletest","detailtest","sorttest","pricetest");
        GoodsDAO dao= new GoodsDAOProxy();
        dao.insert(goods);
    }

    public static void inputStream2File(InputStream is, String savePath)
            throws Exception {
        System.out.println("the file path is  :" + savePath);
        File file = new File(savePath);
        InputStream inputSteam = is;
        BufferedInputStream fis = new BufferedInputStream(inputSteam);
        FileOutputStream fos = new FileOutputStream(file);
        int f;
        while ((f = fis.read()) != -1) {
            fos.write(f);
        }
        fos.flush();
        fos.close();
        fis.close();
        inputSteam.close();
    }
}
