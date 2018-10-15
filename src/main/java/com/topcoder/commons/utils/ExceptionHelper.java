package com.topcoder.commons.utils;

import java.lang.*;
import java.lang.reflect.Constructor;

/**
 * This is a static helper class that provides methods for constructing exception instances using reflection. It is used by ValidationUtility, PropertiesUtility and JDBCUtility. *
 */
class ExceptionHelper {
    /**
     * Empty private constructor.
     */
    private ExceptionHelper() {
    }

    /**
     * Constructs an exception of the specified type with the given message.
     *
     * @param message        the message
     * @param exceptionClass the exception class
     * @return the constructed exception instance (not null)
     * @throws Exception if any error occurred when using the reflection
     */
    static <T extends Throwable> T constructException(Class<T> exceptionClass, String message) throws Exception {
        Constructor<T> constructor = exceptionClass.getConstructor(String.class);
        T result = constructor.newInstance(message);
        return result;
    }

    /**
     * Constructs an exception of the specified type with the given message and cause.
     *
     * @param message        the message
     * @param cause          the exception cause
     * @param exceptionClass the exception class
     * @return the constructed exception instance (not null)
     * @throws Exception if any error occurred when using the reflection
     */
    static <T extends Throwable> T constructException(Class<T> exceptionClass, String message, Throwable cause)
            throws Exception {
        Constructor<T> constructor = exceptionClass.getConstructor(String.class, Throwable.class);
        T result = constructor.newInstance(message, cause);
        return result;
    }
}

