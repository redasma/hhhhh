package com.example.tp3;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;

import java.util.Map;

public class CustomLogbackJsonLayout extends JsonLayout {

   
    public CustomLogbackJsonLayout() {
        this.setIncludeMDC(false);
    }

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
    	//read
        map.putAll(event.getMDCPropertyMap());
        super.addCustomDataToJsonMap(map, event);
    }


}