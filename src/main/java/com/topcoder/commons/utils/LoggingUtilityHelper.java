package com.topcoder.commons.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * This is a static helper class that provides log message generation
 * functionality for LoggingWrapperUtility and Log4jUtility.
 */
final class LoggingUtilityHelper {
    /**
     * Empty private constructor.
     */
    private LoggingUtilityHelper() {
    }

    /**
     * Retrieves the method entrance log message.
     *
     * @param signature the signature that uniquely identifies the method
     *                  (e.g. className#methodName)
     * @return the constructed method entrance message
     */
    static String getMethodEntranceMessage(final String signature) {
        return "Entering method [" + signature + "].";
    }

    /**
     * Retrieves the log message for the given input parameters. It's assumed
     * that paramNames and paramValues contain the same number of elements.
     *
     * @param paramValues the values of input parameters (not null)
     * @param paramNames  the names of input parameters (not null)
     * @return the constructed log message
     */
    static String getInputParametersMessage(final String[] paramNames,
                                            final Object[] paramValues) {
        StringBuilder sb = new StringBuilder("Input parameters [");
        for (int i = 0; i < paramNames.length; i++) {
            if (i != 0) {
                sb.append(" ,");
            }
            sb.append(paramNames[i]).append(":").append(paramValues[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Retrieves the method exit log message.
     *
     * @param entranceTimestamp the method entrance timestamp (null if not
     *                          available), is used for calculating method
     *                          execution time
     * @param signature         the signature that uniquely identifies the
     *                          method (e.g. className#methodName)
     * @return the constructed method exit message
     */
    static String getMethodExitMessage(final String signature,
                                       final Date entranceTimestamp) {
        StringBuilder sb = new StringBuilder("Exiting method [");
        sb.append(signature).append("]");
        if (entranceTimestamp != null) {
            sb.append(", time spent in the method: ")
                    .append(new Date().getTime() - entranceTimestamp.getTime())
                    .append(" milliseconds");
        }
        sb.append(".");
        return sb.toString();
    }

    /**
     * Retrieves the log message for the given method output value.
     *
     * @param value the value returned by the method
     * @return the constructed log message
     */
    static String getOutputValueMessage(final Object value) {
        return "Output parameter: " + value;
    }

    /**
     * Retrieves the exception log message.
     *
     * @param exception the exception to be logged (assumed to be not null)
     * @param signature the signature that uniquely identifies the method
     *                  (e.g. className#methodName)
     * @return the retrieved exception message
     */
    static String getExceptionMessage(final String signature,
                                      final Throwable exception) {
        StringBuilder sb = new StringBuilder("Error in method [");
        sb.append(signature).append("], details: ")
                .append(exception.getMessage());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        ps.println();
        exception.printStackTrace(ps);
        String stackTrace = out.toString();
        sb.append(stackTrace);
        return sb.toString();
    }
}

