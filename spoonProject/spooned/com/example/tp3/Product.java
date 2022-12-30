package com.example.tp3;
import org.slf4j.Logger;
public class Product {
    private static Logger logger = LoggerFactory.getLogger(Product.class.getName());

    private String ID;

    private String name;

    private String price;

    private String expirationDate;

    public Product(String iD, String name, String price, String expirationString) {
        super();
        ID = iD;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationString;
    }

    public Product() {
        super();
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getName);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getName");
        return name;
    }

    public void setName(String name) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setName);
        MDC.put("parameters",name.toString());
        logger.info("the event of setName");
        this.name = name;
    }

    public String getPrice() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getPrice);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getPrice");
        return price;
    }

    public void setPrice(String price) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setPrice);
        MDC.put("parameters",price.toString());
        logger.info("the event of setPrice");
        this.price = price;
    }

    public String getExpirationString() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getExpirationString);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getExpirationString");
        return expirationDate;
    }

    public void setExpirationString(String expirationString) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setExpirationString);
        MDC.put("parameters",expirationString.toString());
        logger.info("the event of setExpirationString");
        this.expirationDate = expirationString;
    }

    @Override
    public String toString() {
        return ((((((("Product [ID=" + ID) + ", name=") + name) + ", price=") + price) + ", expirationString=") + expirationDate) + "]";
    }
}