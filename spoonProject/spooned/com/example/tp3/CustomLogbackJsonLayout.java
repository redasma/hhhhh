package com.example.tp3;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import java.util.Map;
import org.slf4j.Logger;
public class CustomLogbackJsonLayout extends JsonLayout {
    private static Logger logger = LoggerFactory.getLogger(CustomLogbackJsonLayout.class.getName());

    public CustomLogbackJsonLayout() {
        this.setIncludeMDC(false);
    }

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        MDC.put("userID", Tp3Application.getCurrentUser().getID());
        MDC.put("userInfo", Tp3Application.getCurrentUser().toString());
        MDC.put("Operation",addCustomDataToJsonMap);
        MDC.put("parameters",map.toString()+ ",MDC.put("parameters",event.toString());
        logger.info("the event of addCustomDataToJsonMap");
        // read
        map.putAll(event.getMDCPropertyMap());
        super.addCustomDataToJsonMap(map, event);
    }
}