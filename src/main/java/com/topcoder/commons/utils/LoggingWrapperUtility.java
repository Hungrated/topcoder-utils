package com.topcoder.commons.utils;
import java.util.*;
import com.topcoder.util.log.*;
import java.lang.*;
/**
 * This is a utility class that provides static methods for logging method entrance, method exit and exception using Logging Wrapper component. It allows to optionally log method input/output parameters, method execution time and timestamps. Exceptions are logged together with stack traces. Default level for method entrance/exit message is DEBUG, for exceptions - ERROR; but both can be overridden.
 * 
 * Thread Safety:
 * This class is immutable and thread safe when array parameters passed to it are used by the caller in thread safe manner.
*/
public class LoggingWrapperUtility {
/**
 * The format of timestamps to be put to log messages. Is initialized during class loading and never changed after that. Is used in logEntrance(), logExit() and logException().
*/
private static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
/**
 * Empty private constructor.
 * 
 * Implementation Notes:
 * Do nothing.
*/
private LoggingWrapperUtility() {
}
/**
 * Logs the method entrance together with input parameters (if present). It's assumed that paramNames and paramValues contain the same number of elements.
 * When this method is used, timestamp is not logged explicitly and DEBUG level is used.
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName)
 * paramNames - the names of input parameters (null of method doesn't accept any parameters)
 * paramValues - the values of input parameters
 * 
 * Implementation Notes:
 * 1. logEntrance(log, signature, paramNames, paramValues, false, Level.DEBUG);
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param paramValues the values of input parameters
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
 * @param paramNames the names of input parameters (null of method doesn't accept any parameters)
*/
public static void logEntrance(Log log, String signature, String[] paramNames, Object[] paramValues) {
}
/**
 * Logs the method entrance together with input parameters (if present) and timestamp (optionally). It's assumed that paramNames and paramValues contain the same number of elements.
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName)
 * paramNames - the names of input parameters (null of method doesn't accept any parameters)
 * paramValues - the values of input parameters
 * addTimestamp - true if timestamp must be added to the logged message, false otherwise
 * level - the logging level to be used
 * 
 * Implementation Notes:
 * 1. If log == null then return;
 * 2. String message = (addTimestamp ? TIMESTAMP_FORMAT.format(new Date()) : "") + LoggingUtilityHelper.getMethodEntranceMessage(signature);
 * 3. log.log(level, message);
 * 4. If paramNames != null then
 *      4.1. log.log(level, LoggingUtilityHelper.getInputParametersMessage(paramNames, paramValues));
 * @param addTimestamp true if timestamp must be added to the logged message, false otherwise
 * @param level the logging level to be used
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param paramValues the values of input parameters
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
 * @param paramNames the names of input parameters (null of method doesn't accept any parameters)
*/
public static void logEntrance(Log log, String signature, String[] paramNames, Object[] paramValues, boolean addTimestamp, Level level) {
}
/**
 * Logs the method exit together with the returned value (if present).
 * When this method is used, timestamp is not logged explicitly, method execution time is not logged and DEBUG level is used.
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName)
 * value - the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * 
 * Implementation Notes:
 * 1. logExit(log, signature, value, null);
 * @param value the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
*/
public static void logExit(Log log, String signature, Object[] value) {
}
/**
 * Logs the method exit together with the returned value (if present) and method execution time.
 * When this method is used, timestamp is not logged explicitly and DEBUG level is used.
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName)
 * value - the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * entranceTimestamp - the method entrance timestamp (null if not available), is used for calculating method execution time
 * 
 * Implementation Notes:
 * 1. logExit(log, signature, value, entranceTimestamp, false, Level.DEBUG);
 * @param value the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * @param entranceTimestamp the method entrance timestamp (null if not available), is used for calculating method execution time
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
*/
public static void logExit(Log log, String signature, Object[] value, Date entranceTimestamp) {
}
/**
 * Logs the method exit together with the returned value (if present) and method execution time.
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName)
 * value - the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * entranceTimestamp - the method entrance timestamp (null if not available), is used for calculating method execution time
 * addTimestamp - true if timestamp must be added to the logged message, false otherwise
 * level - the logging level to be used
 * 
 * Implementation Notes:
 * 1. If log == null then return;
 * 2. String message = (addTimestamp ? TIMESTAMP_FORMAT.format(new Date()) : "") + LoggingUtilityHelper.getMethodExitMessage(signature, entranceTimestamp);
 * 3. log.log(level, message);
 * 4. If value != null then
 *      4.1. log.log(level, LoggingUtilityHelper.getOutputValueMessage(value[0]));
 * @param addTimestamp true if timestamp must be added to the logged message, false otherwise
 * @param level the logging level to be used
 * @param value the value returned from the method (should contain 1 element with the returned value, or should be null if the method returns void)
 * @param entranceTimestamp the method entrance timestamp (null if not available), is used for calculating method execution time
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
*/
public static void logExit(Log log, String signature, Object[] value, Date entranceTimestamp, boolean addTimestamp, Level level) {
}
/**
 * Logs the given exception.
 * When this method is used, timestamp is not logged explicitly and ERROR level is used.
 * 
 * Generic Parameters:
 * T - the type of the exception to be logged and returned
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName) where the exception is logged
 * exception - the exception to be logged (assumed to be not null)
 * 
 * Returns:
 * the logged exception
 * 
 * Implementation Notes:
 * 1. Return logException(log, signature, exception, false, Level.ERROR).
 * @param exception the exception to be logged (assumed to be not null)
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName) where the exception is logged
 * @return the logged exception
*/
public static T logException<T extends Throwable>(Log log, String signature, T exception) {
    return null;
}
/**
 * Logs the given exception together with timestamp (optionally).
 * 
 * Generic Parameters:
 * T - the type of the exception to be logged and returned
 * 
 * Parameters:
 * log - the logger to be used (null if logging is not required to be performed)
 * signature - the signature that uniquely identifies the method (e.g. className#methodName) where the exception is logged
 * exception - the exception to be logged (assumed to be not null)
 * addTimestamp - true if timestamp must be added to the logged message, false otherwise
 * level - the logging level to be used
 * 
 * Returns:
 * the logged exception
 * 
 * Implementation Notes:
 * 1. If log == null then return;
 * 2. String message = (addTimestamp ? TIMESTAMP_FORMAT.format(new Date()) : "") + LoggingUtilityHelper.getExceptionMessage(signature, exception);
 * 3. log.log(level, message);
 * 4. Return exception.
 * @param addTimestamp true if timestamp must be added to the logged message, false otherwise
 * @param level the logging level to be used
 * @param exception the exception to be logged (assumed to be not null)
 * @param log the logger to be used (null if logging is not required to be performed)
 * @param signature the signature that uniquely identifies the method (e.g. className#methodName) where the exception is logged
 * @return the logged exception
*/
public static T logException<T extends Throwable>(Log log, String signature, T exception, boolean addTimestamp, Level level) {
    return null;
}
}

