package com.example.tp3;
import org.slf4j.Logger;
public class ProductNotFoundException extends Exception {
    private static Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class.getName());

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
}