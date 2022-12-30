package com.example.tp3;
import org.slf4j.Logger;
public class ProductAlreadyExistException extends Exception {
    private static Logger logger = LoggerFactory.getLogger(ProductAlreadyExistException.class.getName());

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ProductAlreadyExistException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductAlreadyExistException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
}