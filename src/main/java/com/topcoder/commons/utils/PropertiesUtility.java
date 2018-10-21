package com.topcoder.commons.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

/**
 * This is a utility class that provides static methods for retrieving
 * properties of different types (String, Integer, Long, Double, Date, Class)
 * from Properties instance. This utility throws en exception specified by the
 * caller if required property is missing or cannot be parsed properly.
 * getSubConfiguration() method allows to extract inner configuration from
 * Properties instance (when "childConfigName.childPropertyName" format is used
 * for property keys).
 */
public final class PropertiesUtility {
    /**
     * Empty private constructor.
     */
    private PropertiesUtility() {
    }

    /**
     * Retrieves the string property from the given Properties instance.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved string property value (null if property is
     * optional and missing)
     * @throws T         if the property is required, but missing
     * @throws Exception if the property is required, but missing
     */
    public static <T extends Throwable> String getStringProperty(
            final Properties properties,
            final String key,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        return value;
    }

    /**
     * Retrieves the delimited strings property from the given Properties
     * instance.
     *
     * @param <T>            type of exception
     * @param delimiter      the delimiter regular expression pattern
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved strings values (null if property is optional
     * and missing)
     * @throws T         if the property is required, but missing
     * @throws Exception if the property is required, but missing
     */
    public static <T extends Throwable> String[] getStringsProperty(
            final Properties properties,
            final String key,
            final String delimiter,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        return value.split(delimiter, -1);
    }

    /**
     * Retrieves the integer property from the given Properties instance.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise (if
     *                       property is required, but missing, an exception
     *                       is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved integer property value (null if property is
     * optional and missing)
     * @throws T         if the property value has invalid format or is
     *                   required, but missing
     * @throws Exception if the property value has invalid format or is
     *                   required, but missing
     */
    public static <T extends Throwable> Integer getIntegerProperty(
            final Properties properties,
            final String key,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Integer result = Integer.valueOf(value);
            return result;
        } catch (NumberFormatException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be a valid integer", ex);
        }
    }

    /**
     * Retrieves the long integer property from the given Properties instance.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved long integer property value (null if property is
     * optional and missing)
     * @throws T         if the property value has invalid format or is
     *                   required, but missing
     * @throws Exception if the property value has invalid format
     *                   or is required, but missing
     */
    public static <T extends Throwable> Long getLongProperty(
            final Properties properties,
            final String key,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Long result = Long.valueOf(value);
            return result;
        } catch (NumberFormatException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be a valid"
                            + " long integer", ex);
        }
    }

    /**
     * Retrieves the double property from the given Properties instance.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved double property value (null if property is
     * optional and missing)
     * @throws T         if the property value has invalid format or is
     *                   required,but missing
     * @throws Exception if the property value has invalid format or is
     *                   required, but missing
     */
    public static <T extends Throwable> Double getDoubleProperty(
            final Properties properties,
            final String key,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Double result = (Double) NumberFormat.getInstance(Locale.US)
                    .parse(value, parsePosition);
            if (parsePosition.getIndex() != value.length()) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " should be a valid double");
            }
            return result;
        } catch (ParseException ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key)
                            + " should be a valid double", ex);
        }
    }

    /**
     * Retrieves the date/time property from the given Properties instance.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param format         the expected date/time format string
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved date/time property value (null if property is
     * optional and missing)
     * @throws T         if the property value has invalid format or is
     *                   required,  but missing
     * @throws Exception if the property value has invalid format or is
     *                   required, but missing
     */
    public static <T extends Throwable> Date getDateProperty(
            final Properties properties,
            final String key,
            final String format,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date result = new SimpleDateFormat(format, Locale.US)
                .parse(value, parsePosition);
        if (result == null || parsePosition.getIndex() != value.length()) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " should be in format ["
                            + format + "]");
        }
        return result;
    }

    /**
     * Retrieves the class property from the given Properties instance.
     * Property value is expected to contain a full class name.
     *
     * @param <T>            type of exception
     * @param exceptionClass the type of the exception to be thrown if some
     *                       error occurs
     * @param properties     the properties container
     * @param required       true if property is required, false otherwise
     *                       (if property is required, but missing, an
     *                       exception is thrown)
     * @param key            the key of the property to be retrieved
     * @return the retrieved class property value (null if property is
     * optional and missing)
     * @throws T         if the property value has invalid format or is
     *                   required, but missing
     * @throws Exception if the property value has invalid format or is
     *                   required, but missing
     */
    public static <T extends Throwable> Class<?> getClassProperty(
            final Properties properties,
            final String key,
            final boolean required,
            final Class<T> exceptionClass)
            throws T, Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            if (required) {
                throw ExceptionHelper.constructException(exceptionClass,
                        getPropertyTitle(key) + " is required");
            }
            return null;
        }
        try {
            Class<?> result = Class.forName(value);
            return result;
        } catch (Exception ex) {
            throw ExceptionHelper.constructException(exceptionClass,
                    getPropertyTitle(key) + " contains invalid full "
                            + "class name (" + value + ")", ex);
        }
    }

    /**
     * Retrieves the inner configuration from the configuration stored in
     * Properties container.
     *
     * @param configName the name of the inner configuration
     * @param properties the properties with the main configuration
     * @return the Properties container with the extracted inner configuration
     * (not null)
     */
    public static Properties getSubConfiguration(
            final Properties properties,
            final String configName) {
        String prefix = configName + ".";
        Properties result = new Properties();
        Enumeration en = properties.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            if (key.startsWith(prefix)) {
                String newKey = key.substring(prefix.length());
                String value = properties.getProperty(key);
                result.put(newKey, value);
            }
        }
        return result;
    }

    /**
     * Retrieves the property title to be used in exception message.
     *
     * @param key the property key
     * @return the constructed property title
     */
    private static String getPropertyTitle(final String key) {
        return "The property '" + key + "'";
    }
}

