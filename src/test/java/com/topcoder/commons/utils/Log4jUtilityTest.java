package com.topcoder.commons.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;

import java.util.Date;


public class Log4jUtilityTest {

    private Logger logger;
    private Logger nullLogger;
    private String signature;
    private String[] paramNames;
    private String[] nullParamNames;
    private Object[] paramValues;
    private Object[] value;
    private Object[] nullValue;
    private Exception exception;

    public Log4jUtilityTest() {
        // empty
    }

    @Before
    public void setUp() {
        this.logger = Logger.getLogger(Log4jUtilityTest.class);
        this.nullLogger = null;
        this.signature = "className#methodName";
        this.paramNames = new String[]{"param1", "param2", "param3"};
        this.nullParamNames = null;
        this.paramValues = new Object[]{"value1", "value2", "value3"};
        this.value = new Object[]{"value1", "value2", "value3"};
        this.nullValue = null;
        this.exception = new Exception();
    }

    @After
    public void tearDown() {
        // empty
    }

    @Test
    public void testLogEntrance() {
        Log4jUtility.logEntrance(logger, signature, paramNames, paramValues);
        Log4jUtility.logEntrance(nullLogger, signature, paramNames, paramValues);
        Log4jUtility.logEntrance(logger, signature, nullParamNames, paramValues);
        Log4jUtility.logEntrance(nullLogger, signature, nullParamNames, paramValues);
    }

    @Test
    public void testLogExit() {
        Log4jUtility.logExit(logger, signature, value);
        Log4jUtility.logExit(nullLogger, signature, value);
        Log4jUtility.logExit(logger, signature, nullValue);
        Log4jUtility.logExit(nullLogger, signature, nullValue);
        Log4jUtility.logExit(logger, signature, value, new Date());
    }

    @Test
    public void testLogException() {
        Log4jUtility.logException(logger, signature, exception);
        Log4jUtility.logException(nullLogger, signature, exception);
    }
}
