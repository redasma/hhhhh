package com.example.tp3;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
public class Repository {
    private static Logger logger = LoggerFactory.getLogger(Repository.class.getName());

    private String ID;

    private List<Product> products;

    public Repository() {
        super();
        this.products = new ArrayList<>();
    }

    public Repository(String iD, List<Product> products) {
        super();
        ID = iD;
        this.products = products;
    }

    public String getID() {
        // read
        return ID;
    }

    public void setID(String iD) {
        // write
        ID = iD;
    }

    public List<Product> getProducts() {
        // read
        return products;
    }

    public void setProducts(List<Product> products) {
        // write
        this.products = products;
    }

    public Product fetchProduct(String ID) throws ProductNotFoundException {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation","fetchProduct");
        MDC.put("parameters",ID.toString());
        logger.info("the event of fetchProduct");
        for (Product product : products) {
            if (product.getID().equals(ID)) {
                return product;
            }
        }
        throw new ProductNotFoundException("No product with the provided ID exists.");
    }

    public Product addProduct(Product product) throws ProductAlreadyExistException {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation","addProduct");
        MDC.put("parameters",product.toString());
        logger.info("the event of addProduct");
        // write
        try {
            this.fetchProduct(product.getID());
            throw new ProductAlreadyExistException("A product with the same ID already exists.");
        } catch (ProductNotFoundException e) {
            products.add(product);
            return product;
        }
    }

    public Product deleteProduct(String ID) throws ProductNotFoundException {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation","deleteProduct");
        MDC.put("parameters",ID.toString());
        logger.info("the event of deleteProduct");
        // write
        Product p = this.fetchProduct(ID);
        products.remove(p);
        return p;
    }

    public Product updateProduct(Product product) throws ProductNotFoundException, ProductAlreadyExistException {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation","updateProduct");
        MDC.put("parameters",product.toString());
        logger.info("the event of updateProduct");
        // write
        this.deleteProduct(product.getID());
        this.addProduct(product);
        return product;
    }

    public void diplayProducts() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation","diplayProducts");
        MDC.put("parameters", "no parameters given");
        logger.info("the event of diplayProducts");
        // read
        StringBuilder sb = new StringBuilder();
        sb.append("Printing products database :");
        sb.append('\n');
        for (Product product : products) {
            sb.append(product);
            sb.append('\n');
        }
        sb.append("End of printing.");
        System.out.println(sb.toString());
    }
}