package com.topcoder.commons.utils;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * This is a utility class that provides static methods for checking whether
 * some arbitrary value meets specific criteria (not null, not empty, positive,
 * negative, etc). If criteria is not met, this utility throws an exception
 * of type specified by the caller.
 */
public final class ValidationUtility {
    /**
     * Empty private constructor.
     */
    private ValidationUtility() {
    }

    /**
     * Checks whether the given value is not null. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is null
     * @throws Exception if the given value is null
     */
    public static <T extends Throwable> void checkNotNull(
            final Object value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value == null) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should not be null");
        }
    }

    /**
     * Checks whether the given string value is not empty (without trimming).
     * And if this condition is not met, the specified exception is thrown.
     * Note that if value is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is empty
     * @throws Exception if the given value is empty
     */
    public static <T extends Throwable> void checkNotEmpty(
            final String value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value != null && value.equals("")) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not be empty");
        }
    }

    /**
     * Checks whether the given string value is not empty (after trimming).
     * And if this condition is not met, the specified exception is thrown.
     * Note that if value is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is empty
     * @throws Exception if the given value is empty
     */
    public static <T extends Throwable> void checkNotEmptyAfterTrimming(
            final String value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value != null && value.trim().equals("")) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not be empty (trimmed)");
        }
    }

    /**
     * Checks whether the given string value is not null, nor empty (without
     * trimming). And if this condition is not met, the specified exception
     * is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is null or empty
     * @throws Exception if the given value is null or empty
     */
    public static <T extends Throwable> void checkNotNullNorEmpty(
            final String value,
            final String name,
            final Class<T> exceptionClass) throws T, Exception {
        checkNotNull(value, name, exceptionClass);
        checkNotEmpty(value, name, exceptionClass);
    }

    /**
     * Checks whether the given string value is not null, nor empty (after
     * trimming). And if this condition is not met, the specified exception
     * is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is null or empty
     * @throws Exception if the given value is null or empty
     */
    public static <T extends Throwable> void checkNotNullNorEmptyAfterTrimming(
            final String value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        checkNotNull(value, name, exceptionClass);
        checkNotEmptyAfterTrimming(value, name, exceptionClass);
    }

    /**
     * Checks whether the given value is an instance of the specified type.
     * And if this condition is not met, the specified exception is thrown.
     * Note that if value is null, exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param expectedType   the expected type of the value
     * @param value          the value to be checked
     * @throws T         if the given value is not an instance of the
     *                   expected type
     * @throws Exception if the given value is not an instance of the
     *                   expected type
     */
    public static <T extends Throwable> void checkInstance(
            final Object value,
            final Class<?> expectedType,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (!expectedType.isInstance(value)) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be an instance of "
                            + expectedType.getName());
        }
    }

    /**
     * Checks whether the given value is null or an instance of the specified
     * type. And if this condition is not met, the specified exception is
     * thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param expectedType   the expected type of the value
     * @param value          the value to be checked
     * @throws T         if the given value is not null and not an instance
     *                   of the expected type
     * @throws Exception if the given value is not null and not an instance
     *                   of the expected type
     */
    public static <T extends Throwable> void checkNullOrInstance(
            final Object value,
            final Class<?> expectedType,
            final String name,
            final Class<T> exceptionClass) throws T, Exception {
        if (value != null && !expectedType.isInstance(value)) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be null or an instance of "
                            + expectedType.getName());
        }
    }

    /**
     * Checks whether the given File instance points to an existing file or
     * directory. And if this condition is not met, the specified exception
     * is thrown. Note that if file is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param file           the File instance to be checked
     * @param name           the name associated with the value
     * @throws T         if the given file value represents a not existing
     *                   file or directory
     * @throws Exception if the given file value represents a not existing
     *                   file or directory
     */
    public static <T extends Throwable> void checkExists(
            final File file,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (file != null && !file.exists()) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should point to an existing file or directory");
        }
    }

    /**
     * Checks whether the given File instance points to an existing file. And
     * if this condition is not met, the specified exception is thrown. Note
     * that if file is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param file           the File instance to be checked
     * @param name           the name associated with the value
     * @throws T         if the given file value represents a not existing file
     * @throws Exception if the given file value represents a not existing file
     */
    public static <T extends Throwable> void checkIsFile(
            final File file,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (file != null && !file.isFile()) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should point to an existing file");
        }
    }

    /**
     * Checks whether the given File instance points to an existing directory.
     * And if this condition is not met, the specified exception is thrown.
     * Note that if file is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param file           the File instance to be checked
     * @param name           the name associated with the value
     * @throws T         if the given file value represents a not existing
     *                   directory
     * @throws Exception if the given file value represents a not existing
     *                   directory
     */
    public static <T extends Throwable> void checkIsDirectory(
            final File file,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (file != null && !file.isDirectory()) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should point to an existing directory");
        }
    }

    /**
     * Checks whether the given collection is not empty. And if this
     * condition is not met, the specified exception is thrown. Note that
     * if collection is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param collection     the collection to be checked
     * @throws T         if the given collection is empty
     * @throws Exception if the given collection is empty
     */
    public static <T extends Throwable> void checkNotEmpty(
            final Collection<?> collection,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (collection != null && collection.isEmpty()) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should not be empty");
        }
    }

    /**
     * Checks whether the given collection is not null, nor empty. And if
     * this condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param collection     the collection to be checked
     * @throws T         if the given collection is null or empty
     * @throws Exception if the given collection is null or empty
     */
    public static <T extends Throwable> void checkNotNullNorEmpty(
            final Collection<?> collection,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        checkNotNull(collection, name, exceptionClass);
        checkNotEmpty(collection, name, exceptionClass);
    }

    /**
     * Checks whether the given map value is not empty. And if this condition
     * is not met, the specified exception is thrown. Note that if map is
     * null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the map to be checked
     * @throws T         if the given map is empty
     * @throws Exception if the given map is empty
     */
    public static <T extends Throwable> void checkNotEmpty(
            final Map<?, ?> map,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (map != null && map.isEmpty()) {
            throw ExceptionHelper.constructException(exceptionClass, name
                    + " should not be empty");
        }
    }

    /**
     * Checks whether the given map is not null, nor empty. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the map to be checked
     * @throws T         if the given map is null or empty
     * @throws Exception if the given map is null or empty
     */
    public static <T extends Throwable> void checkNotNullNorEmpty(
            final Map<?, ?> map,
            final String name,
            final Class<T> exceptionClass) throws T, Exception {
        checkNotNull(map, name, exceptionClass);
        checkNotEmpty(map, name, exceptionClass);
    }

    /**
     * Checks whether the given collection doesn't contain null elements. And
     * if this condition is not met, the specified exception is thrown. Note
     * that if collection is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param collection     the collection to be checked
     * @throws T         if the given collection contains null element
     * @throws Exception if the given collection contains null element
     */
    public static <T extends Throwable> void checkNotNullElements(
            final Collection<?> collection,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (collection == null) {
            return;
        }
        boolean containsNull = false;
        for (Object element : collection) {
            if (element == null) {
                containsNull = true;
                break;
            }
        }
        if (containsNull) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain null");
        }
    }

    /**
     * Checks whether the given collection doesn't contain empty elements
     * (strings, collections, maps). And if this condition is not met, the
     * specified exception is thrown. Note that if collection is null,
     * exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param trimStrings    true if strings should be trimmed before
     *                       emptiness check, false otherwise
     * @param collection     the collection to be checked
     * @throws T         if the given collection contains an empty element
     *                   (string, collection or map)
     * @throws Exception if the given collection contains an empty element
     *                   (string, collection or map)
     */
    public static <T extends Throwable> void checkNotEmptyElements(
            final Collection<?> collection,
            final boolean trimStrings,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (collection == null) {
            return;
        }
        boolean containsEmpty = false;
        for (Object element : collection) {
            if (element instanceof String) {
                String str = (String) element;
                if (trimStrings) {
                    str = str.trim();
                }
                if (str.equals("")) {
                    containsEmpty = true;
                    break;
                }
            } else if (element instanceof Collection) {
                if (((Collection) element).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            } else if (element instanceof Map) {
                if (((Map) element).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            }
        }
        if (containsEmpty) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain empty elements");
        }
    }

    /**
     * Checks whether the given map doesn't contain a null key. And if this
     * condition is not met, the specified exception is thrown. Note that
     * if map is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the value to be checked
     * @throws T         if the given map contains null key
     * @throws Exception if the given map contains null key
     */
    public static <T extends Throwable> void checkNotNullKeys(
            final Map<?, ?> map,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (map != null && map.containsKey(null)) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain null key");
        }
    }

    /**
     * Checks whether the given map doesn't contain a null value. And if this
     * condition is not met, the specified exception is thrown. Note that if
     * map is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the map to be checked
     * @throws T         if the given map contains null value
     * @throws Exception if the given map contains null value
     */
    public static <T extends Throwable> void checkNotNullValues(
            final Map<?, ?> map,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (map != null && map.containsValue(null)) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain null value");
        }
    }

    /**
     * Checks whether the given map doesn't contain empty keys (strings,
     * collection, maps). And if this condition is not met, the specified
     * exception is thrown. Note that if map is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the map to be checked
     * @param trimStrings    true if strings should be trimmed before
     *                       emptiness check, false otherwise
     * @throws T         if the given map contains an empty key
     *                   (string, collection or map)
     * @throws Exception if the given map contains an empty key
     *                   (string, collection or map)
     */
    public static <T extends Throwable> void checkNotEmptyKeys(
            final Map<?, ?> map,
            final boolean trimStrings,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (map == null) {
            return;
        }
        boolean containsEmpty = false;
        for (Object key : map.keySet()) {
            if (key instanceof String) {
                String str = (String) key;
                if (trimStrings) {
                    str = str.trim();
                }
                if (str.equals("")) {
                    containsEmpty = true;
                    break;
                }
            } else if (key instanceof Collection) {
                if (((Collection) key).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            } else if (key instanceof Map) {
                if (((Map) key).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            }
        }
        if (containsEmpty) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain empty keys");
        }
    }

    /**
     * Checks whether the given map doesn't contain empty values (strings,
     * collection, maps). And if this condition is not met, the specified
     * exception is thrown. Note that if map is null, exception is not thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param map            the map to be checked
     * @param trimStrings    true if strings should be trimmed before
     *                       emptiness check, false otherwise
     * @throws T         if the given map contains an empty value
     *                   (string, collection or map)
     * @throws Exception if the given map contains an empty value
     *                   (string, collection or map)
     */
    public static <T extends Throwable> void checkNotEmptyValues(
            final Map<?, ?> map,
            final boolean trimStrings,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (map == null) {
            return;
        }
        boolean containsEmpty = false;
        for (Object value : map.values()) {
            if (value instanceof String) {
                String str = (String) value;
                if (trimStrings) {
                    str = str.trim();
                }
                if (str.equals("")) {
                    containsEmpty = true;
                    break;
                }
            } else if (value instanceof Collection) {
                if (((Collection) value).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            } else if (value instanceof Map) {
                if (((Map) value).isEmpty()) {
                    containsEmpty = true;
                    break;
                }
            }
        }
        if (containsEmpty) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not contain empty values");
        }
    }

    /**
     * Checks whether the given value is negative. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is not negative
     * @throws Exception if the given value is not negative
     */
    public static <T extends Throwable> void checkNegative(
            final double value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value >= 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be negative");
        }
    }

    /**
     * Checks whether the given value is positive. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is not positive
     * @throws Exception if the given value is not positive
     */
    public static <T extends Throwable> void checkPositive(
            final double value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value <= 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be positive");
        }
    }

    /**
     * Checks whether the given value is not negative. And if this condition
     * is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is negative
     * @throws Exception if the given value is negative
     */
    public static <T extends Throwable> void checkNotNegative(
            final double value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value < 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be not negative");
        }
    }

    /**
     * Checks whether the given value is not positive. And if this condition
     * is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is positive
     * @throws Exception if the given value is positive
     */
    public static <T extends Throwable> void checkNotPositive(
            final double value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value > 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be not positive");
        }
    }

    /**
     * Checks whether the given value is not equal to zero. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is equal to 0
     * @throws Exception if the given value is equal to 0
     */
    public static <T extends Throwable> void checkNotZero(
            final double value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value == 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not be equal to 0");
        }
    }

    /**
     * Checks whether the given value is greater than (greater than or equal
     * to, if inclusive is true) than the specified number. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param inclusive      true if "greater than or equal to" check should
     *                       be performed, false if "greater than" check
     *                       should be performed
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param number         the number the value should be compared to
     * @throws T         if the given value is not greater
     *                   than (not greater than and not equal to, if inclusive
     *                   is true) than the specified number
     * @throws Exception if the given value is not greater
     *                   than (not greater than and not equal to, if inclusive
     *                   is true) than the specified number
     */
    public static <T extends Throwable> void checkGreaterThan(
            final double value,
            final double number,
            final boolean inclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (inclusive) {
            if (value < number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be greater than or equal to "
                                + number);
            }
        } else {
            if (value <= number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be greater than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is less than (less than or equal to, if
     * inclusive is true) than the specified number. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param inclusive      true if "less than or equal to" check should be
     *                       performed, false if "less than" check should be
     *                       performed
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param number         the number the value should be compared to
     * @throws T         if the given value is not less than (not less than
     *                   and not equal to, if inclusive is true) than the
     *                   specified number
     * @throws Exception if the given value is not less than (not less than
     *                   and not equal to, if inclusive is true) than the
     *                   specified number
     */
    public static <T extends Throwable> void checkLessThan(
            final double value,
            final double number,
            final boolean inclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (inclusive) {
            if (value > number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be less than or equal to " + number);
            }
        } else {
            if (value >= number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be less than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is in the specified range. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param to             the end value of the range
     * @param exceptionClass the exception class
     * @param fromInclusive  true if start value is included into the range,
     *                       false otherwise
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param toInclusive    true if end value is included into the range,
     *                       false otherwise
     * @param from           the start value of the range
     * @throws T         if the given value is out of the specified range
     * @throws Exception if the given value is out of the specified range
     */
    public static <T extends Throwable> void checkInRange(
            final double value,
            final double from,
            final double to,
            final boolean fromInclusive,
            final boolean toInclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        boolean valid;
        if (fromInclusive) {
            valid = (value >= from);
        } else {
            valid = (value > from);
        }
        if (valid) {
            if (toInclusive) {
                valid = (value <= to);
            } else {
                valid = (value < to);
            }
        }
        if (!valid) {
            String fromBracket = "(";
            String toBracket = ")";
            if (fromInclusive) {
                fromBracket = "[";
            }
            if (toInclusive) {
                toBracket = "]";
            }
            String message = name + " should be in the range "
                    + fromBracket + from + ", " + to + toBracket;
            throw ExceptionHelper.constructException(exceptionClass, message);
        }
    }

    /**
     * Checks whether the given value is negative. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is not negative
     * @throws Exception if the given value is not negative
     */
    public static <T extends Throwable> void checkNegative(
            final long value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value >= 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be negative");
        }
    }

    /**
     * Checks whether the given value is positive. And if this condition is
     * not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is not positive
     * @throws Exception if the given value is not positive
     */
    public static <T extends Throwable> void checkPositive(
            final long value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value <= 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be positive");
        }
    }

    /**
     * Checks whether the given value is not negative. And if this condition
     * is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is negative
     * @throws Exception if the given value is negative
     */
    public static <T extends Throwable> void checkNotNegative(
            final long value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value < 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be not negative");
        }
    }

    /**
     * Checks whether the given value is not positive. And if this condition
     * is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is positive
     * @throws Exception if the given value is positive
     */
    public static <T extends Throwable> void checkNotPositive(
            final long value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value > 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should be not positive");
        }
    }

    /**
     * Checks whether the given value is not equal to zero. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @throws T         if the given value is equal to 0
     * @throws Exception if the given value is equal to 0
     */
    public static <T extends Throwable> void checkNotZero(
            final long value,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (value == 0) {
            throw ExceptionHelper.constructException(exceptionClass,
                    name + " should not be equal to 0");
        }
    }

    /**
     * Checks whether the given value is greater than (greater than or equal
     * to, if inclusive is true) than the specified number. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param inclusive      true if "greater than or equal to" check should
     *                       be performed, false if "greater than" check
     *                       should be performed
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param number         the number the value should be compared to
     * @throws T         if the given value is not greater
     *                   than (not greater than and not equal to, if
     *                   inclusive is true) than the specified number
     * @throws Exception if the given value is not greater
     *                   than (not greater than and not equal to, if
     *                   inclusive is true) than the specified number
     */
    public static <T extends Throwable> void checkGreaterThan(
            final long value,
            final long number,
            final boolean inclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (inclusive) {
            if (value < number) {
                throw ExceptionHelper.constructException(exceptionClass, name
                        + " should be greater than or equal to "
                        + number);
            }
        } else {
            if (value <= number) {
                throw ExceptionHelper.constructException(exceptionClass, name
                        + " should be greater than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is less than (less than or equal to,
     * if inclusive is true) than the specified number. And if this condition
     * is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param inclusive      true if "less than or equal to" check should be
     *                       performed, false if "less than" check should be
     *                       performed
     * @param exceptionClass the exception class
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param number         the number the value should be compared to
     * @throws T         if the given value is not less
     *                   than (not less than and not equal to, if
     *                   inclusive is true) than the specified number
     * @throws Exception if the given value is not less
     *                   than (not less than and not equal to, if
     *                   inclusive is true) than the specified number
     */
    public static <T extends Throwable> void checkLessThan(
            final long value,
            final long number,
            final boolean inclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        if (inclusive) {
            if (value > number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be less than or equal to " + number);
            }
        } else {
            if (value >= number) {
                throw ExceptionHelper.constructException(exceptionClass,
                        name + " should be less than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is in the specified range. And if this
     * condition is not met, the specified exception is thrown.
     *
     * @param <T>            type of exception
     * @param to             the end value of the range
     * @param exceptionClass the exception class
     * @param fromInclusive  true if start value is included into the range,
     *                       false otherwise
     * @param name           the name associated with the value
     * @param value          the value to be checked
     * @param toInclusive    true if end value is included into the range,
     *                       false otherwise
     * @param from           the start value of the range
     * @throws T         if the given value is out of the specified range
     * @throws Exception if the given value is out of the specified range
     */
    public static <T extends Throwable> void checkInRange(
            final long value,
            final long from,
            final long to,
            final boolean fromInclusive,
            final boolean toInclusive,
            final String name,
            final Class<T> exceptionClass)
            throws T, Exception {
        boolean valid;
        if (fromInclusive) {
            valid = (value >= from);
        } else {
            valid = (value > from);
        }
        if (valid) {
            if (toInclusive) {
                valid = (value <= to);
            } else {
                valid = (value < to);
            }
        }
        if (!valid) {
            String fromBracket = "(";
            String toBracket = ")";
            if (fromInclusive) {
                fromBracket = "[";
            }
            if (toInclusive) {
                toBracket = "]";
            }
            String message = name + " should be in the range "
                    + fromBracket + from + ", " + to + toBracket;
            throw ExceptionHelper.constructException(exceptionClass, message);
        }
    }
}

