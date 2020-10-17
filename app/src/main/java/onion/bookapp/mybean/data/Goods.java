package onion.bookapp.mybean.data;

public class Goods {
    private int goodsid;
    private int publisherid;
    private String images;
    private double price;

    public Goods(){}
    public Goods(int goodsid,int publisherid,String images,double price){
        super();
        this.goodsid=goodsid;
        this.publisherid=publisherid;
        this.images=images;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    }
