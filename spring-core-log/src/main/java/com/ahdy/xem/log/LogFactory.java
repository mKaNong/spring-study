package com.ahdy.xem.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFactory {

    public static Logger getBusLogger() {
        return LoggerFactory.getLogger(LogEnum.valueOf("BUSSINESS").getCategory());
    }

    public static Logger getPlatformLogger(){
        return LoggerFactory.getLogger(LogEnum.valueOf("PLATFORM").getCategory());
    }

    public static Logger getDbLogger(){
        return LoggerFactory.getLogger(LogEnum.valueOf("DB").getCategory());
    }

    public static Logger getExceptionLogger(){
        return LoggerFactory.getLogger(LogEnum.valueOf("EXCEPTION").getCategory());
    }

}
