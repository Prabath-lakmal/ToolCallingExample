package com.spring_AI.ToolCallingExample.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleDateTimeTool {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //Information -> tool
    @Tool(description = "Get the current date and time in users zone.")
    public String getLocalDateTIme(){
        this.logger.info("Tool Calling");
        this.logger.info("Get the current date and time in users zone.");
        return LocalDateTime.now()
                .atZone(LocaleContextHolder.getTimeZone().toZoneId())
                .toString();
    }

    //Action tool -> that i can take actions
    @Tool(description = "Set the alarm for given time.")
    void setAlarm(@ToolParam(description = "Time in ISO-8601 format") String time){
        var dateTime =LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        this.logger.info("Set the alarm for given time. {}", dateTime);
    }

}
