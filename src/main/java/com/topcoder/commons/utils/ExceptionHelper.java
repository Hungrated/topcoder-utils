package com.topcoder.commons.utils;

import java.lang.reflect.Constructor;

/**
 * This is a static helper class that provides methods for constructing
 * exception instances using reflection. It is used by ValidationUtility,
 * PropertiesUtility and JDBCUtility.
 */
final class ExceptionHelper {
    /**
     * Empty private constructor.
     */
    private ExceptionHelper() {
    }

    /**
     * Constructs an exception of the specified type with the given message.
     *
     * @param <T>            type of exception
     * @param message        the message
     * @param exceptionClass the exception class
     * @return the constructed exception instance (not null)
     * @throws Exception if any error occurred when using the reflection
     */
    static <T extends Throwable> T constructException(
            final Class<T> exceptionClass, final String message)
            throws Exception {
        Constructor<T> constructor = exceptionClass
                .getConstructor(String.class);
        T result = (T) constructor.newInstance(message);
        return result;
    }

    /**
     * Constructs an exception of the specified type with the given message and
     * cause.
     *
     * @param <T>            type of exception
     * @param message        the message
     * @param cause          the exception cause
     * @param exceptionClass the exception class
     * @return the constructed exception instance (not null)
     * @throws Exception if any error occurred when using the reflection
     */
    static <T extends Throwable> T
    constructException(final Class<T> exceptionClass, final String message,
                       final Throwable cause)
            throws Exception {
        Constructor<T> constructor =
                exceptionClass.getConstructor(String.class, Throwable.class);
        T result = (T) constructor.newInstance(message, cause);
        return result;
    }
}

