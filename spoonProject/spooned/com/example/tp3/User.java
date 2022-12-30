package com.example.tp3;
import org.slf4j.Logger;
public class User {
    private static Logger logger = LoggerFactory.getLogger(User.class.getName());

    private String ID;

    private String name;

    private String age;

    private String email;

    private String password;

    public User() {
        super();
    }

    public User(String iD, String name, String age, String email, String password) {
        super();
        ID = iD;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
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

    public String getAge() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getAge);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getAge");
        return age;
    }

    public void setAge(String age) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setAge);
        MDC.put("parameters",age.toString());
        logger.info("the event of setAge");
        this.age = age;
    }

    public String getEmail() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getEmail);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getEmail");
        return email;
    }

    public void setEmail(String email) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setEmail);
        MDC.put("parameters",email.toString());
        logger.info("the event of setEmail");
        this.email = email;
    }

    public String getPassword() {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",getPassword);
        "MDC.put("parameters", "no parameters given");
        logger.info("the event of getPassword");
        return password;
    }

    public void setPassword(String password) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",setPassword);
        MDC.put("parameters",password.toString());
        logger.info("the event of setPassword");
        this.password = password;
    }

    @Override
    public String toString() {
        return ((((((((("User [ID=" + ID) + ", name=") + name) + ", age=") + age) + ", email=") + email) + ", password=") + password) + "]";
    }
}