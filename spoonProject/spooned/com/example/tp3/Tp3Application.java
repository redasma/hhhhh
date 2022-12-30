package com.example.tp3;
import java.util.Scanner;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Tp3Application {
    private static Logger logger = LoggerFactory.getLogger(Tp3Application.class.getName());

    static User user = new User();

    static Repository r = new Repository();

    static Scanner s;

    public static final String QUIT = "q";

    public static void main(String[] args) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",main);
        MDC.put("parameters",args.toString());
        logger.info("the event of main");
        System.out.println("welcome to my product stock application");
        s = new Scanner(System.in);
        String input = "";
        System.out.println("Please, insert these informations to register : ");
        CreateUser();
        Product p1 = new Product("0", "fresh ground steak", "20.0", "11/11/26");
        Product p2 = new Product("1", "cheese omelette", "10.0", "11/11/27");
        Product p3 = new Product("2", "baguette", "1.0", "11/11/28");
        Product p4 = new Product("3", "croissant", "2.0", "11/11/29");
        Product p5 = new Product("4", "pain aux chocolat", "2.5", "11/12/01");
        try {
            r.addProduct(p1);
            r.addProduct(p2);
            r.addProduct(p3);
            r.addProduct(p4);
            r.addProduct(p5);
        } catch (ProductAlreadyExistException e) {
            System.out.println("Exception : ");
            System.out.println(e.getMessage());
        }
        do {
            menu();
            input = s.nextLine();
            processInput(input);
        } while (input.equals(QUIT) );
        s.close();
    }

    private static void processInput(String input) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",processInput);
        MDC.put("parameters",input.toString());
        logger.info("the event of processInput");
        switch (input) {
            case "dp" :
                {
                    r.diplayProducts();
                    break;
                }
            case "f" :
                {
                    System.out.println("ID : ");
                    String id = s.nextLine();
                    try {
                        System.out.println(r.fetchProduct(id));
                    } catch (ProductNotFoundException e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                    break;
                }
            case "a" :
                {
                    System.out.println("Product ID :");
                    String id = s.nextLine();
                    System.out.println("Product name :");
                    String name = s.nextLine();
                    System.out.println("Product price :");
                    String price = s.nextLine();
                    System.out.println("Product expiration Date :");
                    String date = s.nextLine();
                    Product p = new Product(id, name, price, date);
                    try {
                        r.addProduct(p);
                    } catch (ProductAlreadyExistException e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                    break;
                }
            case "d" :
                {
                    System.out.println("ID :");
                    String id = s.nextLine();
                    try {
                        r.deleteProduct(id);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                }
            case "u" :
                {
                    System.out.println("Product ID :");
                    String id = s.nextLine();
                    System.out.println("Product name :");
                    String name = s.nextLine();
                    System.out.println("Product price :");
                    String price = s.nextLine();
                    System.out.println("Product expiration Date :");
                    String date = s.nextLine();
                    Product p = new Product(id, name, price, date);
                    try {
                        r.updateProduct(p);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Exception : " + e.getMessage());
                    } catch (ProductAlreadyExistException e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                    break;
                }
            case QUIT :
                System.out.println("end...");
                return;
            default :
                System.err.println("Sorry, wrong input. Please check the menu and try again.");
                return;
        }
    }

    private static void menu() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",menu);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of menu");
        StringBuilder sb = new StringBuilder();
        sb.append("You can do the following actions :");
        sb.append('\n');
        String[] actions = new String[]{ "display products -> tap dp ", "fetch a product by ID -> tap f ", "add a new Product -> tap a ", "delete a product by ID -> tap d", "update a Product Info -> tap u" };
        for (int i = 0; i < actions.length; i++) {
            sb.append(i);
            sb.append(". ");
            sb.append(actions[i]);
            sb.append('\n');
        }
        sb.append(("\n" + QUIT) + ". To quit.");
        System.out.println(sb.toString());
    }

    private static void CreateUser() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",CreateUser);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of CreateUser");
        System.out.println("ID:");
        String id = s.nextLine();
        System.out.println("name :");
        String name = s.nextLine();
        System.out.println("age :");
        String age = s.nextLine();
        System.out.println("email :");
        String email = s.nextLine();
        System.out.println("password :");
        String password = s.nextLine();
        user.setID(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
    }

    public static User getCurrentUser() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getCurrentUser);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getCurrentUser");
        return user;
    }
}