package com.topcoder.commons.utils;
import java.io.File;
import java.lang.*;
import java.util.Collection;
import java.util.Map;

/**
 * This is a utility class that provides static methods for checking whether some arbitrary value meets specific criteria (not null, not empty, positive, negative, etc). If criteria is not met, this utility throws an exception of type specified by the caller.
*/
public class ValidationUtility {
/**
 * Empty private constructor.
*/
private ValidationUtility() {
}
/**
 * Checks whether the given value is not null. And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given value is null
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNotNull(Object value, String name, Class<T> exceptionClass) throws T,
        Exception {
    if (value == null) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not be null");
    }
}
/**
 * Checks whether the given string value is not empty (without trimming). And if this condition is not met, the specified exception is thrown. Note that if value is null, exception is not thrown.
 *
 * @throws T if the given value is empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNotEmpty(String value, String name, Class<T> exceptionClass) throws T,
        Exception {
    if (value != null && value.equals("")) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not be empty");
    }
}
/**
 * Checks whether the given string value is not empty (after trimming). And if this condition is not met, the specified exception is thrown. Note that if value is null, exception is not thrown.
 *
 * @throws T if the given value is empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNotEmptyAfterTrimming(String value, String name,
                                                                    Class<T> exceptionClass) throws T, Exception {
    if (value != null && value.trim().equals("")) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not be empty (trimmed)");
    }
}

/**
 * Checks whether the given string value is not null, nor empty (without trimming). And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given value is null or empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNotNullNorEmpty(String value, String name,
                                                              Class<T> exceptionClass) throws T, Exception {
    checkNotNull(value, name, exceptionClass);
    checkNotEmpty(value, name, exceptionClass);
}
/**
 * Checks whether the given string value is not null, nor empty (after trimming). And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given value is null or empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNotNullNorEmptyAfterTrimming(String value, String name,
                                                                           Class<T> exceptionClass) throws T, Exception {
        checkNotNull(value, name, exceptionClass);
        checkNotEmptyAfterTrimming(value, name, exceptionClass);
}
/**
 * Checks whether the given value is an instance of the specified type. And if this condition is not met, the specified exception is thrown. Note that if value is null, exception is thrown.
 *
 * @throws T if the given value is not an instance of the expected type
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param expectedType the expected type of the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkInstance(Object value, Class<?> expectedType, String name,
                                                       Class<T> exceptionClass) throws T, Exception {
    if(!expectedType.isInstance(value)) {
        throw ExceptionHelper.constructException(exceptionClass,
                name + " should be an instance of " + expectedType.getName());
    }
}
/**
 * Checks whether the given value is null or an instance of the specified type. And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given value is not null and not an instance of the expected type
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param expectedType the expected type of the value
 * @param value the value to be checked
*/
public static <T extends Throwable> void checkNullOrInstance(Object value, Class<?> expectedType, String name,
                                                             Class<T> exceptionClass) throws T, Exception {
    if(value != null && !expectedType.isInstance(value)) {
        throw ExceptionHelper.constructException(exceptionClass,
                name + " should be null or an instance of " + expectedType.getName());
    }
}
/**
 * Checks whether the given File instance points to an existing file or directory. And if this condition is not met, the specified exception is thrown. Note that if file is null, exception is not thrown.
 *
 * @throws T if the given file value represents a not existing file or directory
 * @param exceptionClass the exception class
 * @param file the File instance to be checked
 * @param name the name associated with the value
*/
public static <T extends Throwable> void checkExists(File file, String name, Class<T> exceptionClass) throws T,
        Exception {
    if(file != null && !file.exists()) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should point to an existing file or " +
                "directory");
    }
}
/**
 * Checks whether the given File instance points to an existing file. And if this condition is not met, the specified exception is thrown. Note that if file is null, exception is not thrown.
 *
 * @throws T if the given file value represents a not existing file
 * @param exceptionClass the exception class
 * @param file the File instance to be checked
 * @param name the name associated with the value
*/
public static <T extends Throwable> void checkIsFile(File file, String name, Class<T> exceptionClass) throws T,
    Exception {
    if(file != null && !file.isFile()) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should point to an existing file");
    }
}
/**
 * Checks whether the given File instance points to an existing directory. And if this condition is not met, the specified exception is thrown. Note that if file is null, exception is not thrown.
 *
 * @throws T if the given file value represents a not existing directory
 * @param exceptionClass the exception class
 * @param file the File instance to be checked
 * @param name the name associated with the value
*/
public static <T extends Throwable> void checkIsDirectory(File file, String name, Class<T> exceptionClass) throws T,
        Exception {
    if (file != null && !file.isDirectory()) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should point to an existing directory");
    }
}
/**
 * Checks whether the given collection is not empty. And if this condition is not met, the specified exception is thrown. Note that if collection is null, exception is not thrown.
 *
 * @throws T if the given collection is empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param collection the collection to be checked
*/
public static <T extends Throwable> void checkNotEmpty(Collection<?> collection, String name,
                                                        Class<T> exceptionClass) throws T, Exception {
    if(collection != null && collection.isEmpty()) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not be empty");
    }
}
/**
 * Checks whether the given collection is not null, nor empty. And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given collection is null or empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param collection the collection to be checked
*/
public static <T extends Throwable> void checkNotNullNorEmpty(Collection<?> collection, String name,
                                                              Class<T> exceptionClass) throws T, Exception {
        checkNotNull(collection, name, exceptionClass);
        checkNotEmpty(collection, name, exceptionClass);
}
/**
 * Checks whether the given map value is not empty. And if this condition is not met, the specified exception is thrown. Note that if map is null, exception is not thrown.
 *
 * @throws T if the given map is empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the map to be checked
*/
public static <T extends Throwable> void checkNotEmpty(Map<?,?> map, String name,
                                                       Class<T> exceptionClass) throws T, Exception {
    if(map != null && map.isEmpty()) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not be empty");
    }
}
/**
 * Checks whether the given map is not null, nor empty. And if this condition is not met, the specified exception is thrown.
 *
 * @throws T if the given map is null or empty
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the map to be checked
*/
public static <T extends Throwable> void checkNotNullNorEmpty(Map<?,?> map, String name,
                                                              Class<T> exceptionClass) throws T, Exception{
    checkNotNull(map, name, exceptionClass);
    checkNotEmpty(map, name, exceptionClass);
}
/**
 * Checks whether the given collection doesn't contain null elements. And if this condition is not met, the specified exception is thrown. Note that if collection is null, exception is not thrown.
 *
 * @throws T if the given collection contains null element
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param collection the collection to be checked
*/
public static <T extends Throwable> void checkNotNullElements(Collection<?> collection, String name,
                                                              Class<T> exceptionClass) throws T, Exception {
    if(collection == null) {
        return;
    }
    boolean containsNull = false;
    for(Object element : collection) {
        if(element == null) {
            containsNull = true;
            break;
        }
    }
    if(containsNull) {
        throw ExceptionHelper.constructException(exceptionClass, name + " should not contain null");
    }
}





/**
 * Checks whether the given collection doesn't contain empty elements (strings, collections, maps). And if this condition is not met, the specified exception is thrown. Note that if collection is null, exception is not thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * collection - the collection to be checked
 * trimStrings - true if strings should be trimmed before emptiness check, false otherwise
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given collection contains an empty element (string, collection or map)
 *
 * Implementation Notes:
 * 1. If collection == null then return;
 * 2. boolean containsEmpty = false;
 * 3. For each element:Object from collection do:
 *      3.1. If element is an instance of String then
 *              3.1.1. String str = (String) element;
 *              3.1.2. If trimStrings then
 *                         3.1.2.1. str = str.trim();
 *              3.1.3. If str.equals("") then
 *                         3.1.3.1. containsEmpty = true;
 *                         3.1.3.2. break;
 *      3.2. Else if element is an instance of Collection then
 *              3.2.1. If ((Collection) element).isEmpty() then
 *                         3.2.1.1. containsEmpty = true;
 *                         3.2.1.2. break;
 *      3.3. Else if element is an instance of Map then
 *              3.3.1. If ((Collection) element).isEmpty() then
 *                         3.3.1.1. containsEmpty = true;
 *                         3.3.1.2. break;
 * 4. If containsEmpty then
 *      4.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not contain empty elements");
 * @throws T if the given collection contains an empty element (string, collection or map)
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
 * @param collection the collection to be checked
*/
public static <T extends Throwable> void checkNotEmptyElements(Collection<?> collection,
                                                               boolean trimStrings, String name,
                                                               Class<T> exceptionClass) throws T, Exception {
        if(collection == null) {
            return;
        }
        boolean containsEmpty = false;
        for(Object element : collection) {
            if(element.instanceof())
        }
}
/**
 * Checks whether the given map doesn't contain a null key. And if this condition is not met, the specified exception is thrown. Note that if map is null, exception is not thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * map - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given map contains null key
 *
 * Implementation Notes:
 * 1. If map != null and map.containsKey(null) then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not contain null key");
 * @throws T if the given map contains null key
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the value to be checked
*/
public static void checkNotNullKeys<T extends Throwable>(Map<?,?> map, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given map doesn't contain a null value. And if this condition is not met, the specified exception is thrown. Note that if map is null, exception is not thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * map - the map to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given map contains null value
 *
 * Implementation Notes:
 * 1. If map != null and map.containsValue(null) then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not contain null value");
 * @throws T if the given map contains null value
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the map to be checked
*/
public static void checkNotNullValues<T extends Throwable>(Map<?,?> map, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given map doesn't contain empty keys (strings, collection, maps). And if this condition is not met, the specified exception is thrown. Note that if map is null, exception is not thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * map - the map to be checked
 * trimStrings - true if strings should be trimmed before emptiness check, false otherwise
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given map contains an empty key (string, collection or map)
 *
 * Implementation Notes:
 * 1. If map == null then return;
 * 2. boolean containsEmpty = false;
 * 3. For each key:Object from map.keySet() do:
 *      3.1. If key is an instance of String then
 *              3.1.1. String str = (String) key;
 *              3.1.2. If trimStrings then
 *                         3.1.2.1. str = str.trim();
 *              3.1.3. If str.equals("") then
 *                         3.1.3.1. containsEmpty = true;
 *                         3.1.3.2. break;
 *      3.2. Else if key is an instance of Collection then
 *              3.2.1. If ((Collection) key).isEmpty() then
 *                         3.2.1.1. containsEmpty = true;
 *                         3.2.1.2. break;
 *      3.3. Else if key is an instance of Map then
 *              3.3.1. If ((Map) key).isEmpty() then
 *                         3.3.1.1. containsEmpty = true;
 *                         3.3.1.2. break;
 * 4. If containsEmpty then
 *      4.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not contain empty keys");
 * @throws T if the given map contains an empty key (string, collection or map)
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the map to be checked
 * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
*/
public static void checkNotEmptyKeys<T extends Throwable>(Map<?,?> map, boolean trimStrings, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given map doesn't contain empty values (strings, collection, maps). And if this condition is not met, the specified exception is thrown. Note that if map is null, exception is not thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * map - the map to be checked
 * trimStrings - true if strings should be trimmed before emptiness check, false otherwise
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given map contains an empty value (string, collection or map)
 *
 * Implementation Notes:
 * 1. If map == null then return;
 * 2. boolean containsEmpty = false;
 * 3. For each value:Object from map.values() do:
 *      3.1. If value is an instance of String then
 *              3.1.1. String str = (String) value;
 *              3.1.2. If trimStrings then
 *                         3.1.2.1. str = str.trim();
 *              3.1.3. If str.equals("") then
 *                         3.1.3.1. containsEmpty = true;
 *                         3.1.3.2. break;
 *      3.2. Else if value is an instance of Collection then
 *              3.2.1. If ((Collection) value).isEmpty() then
 *                         3.2.1.1. containsEmpty = true;
 *                         3.2.1.2. break;
 *      3.3. Else if value is an instance of Map then
 *              3.3.1. If ((Map) value).isEmpty() then
 *                         3.3.1.1. containsEmpty = true;
 *                         3.3.1.2. break;
 * 4. If containsEmpty then
 *      4.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not contain empty values");
 * @throws T if the given map contains an empty value (string, collection or map)
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param map the map to be checked
 * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
*/
public static void checkNotEmptyValues<T extends Throwable>(Map<?,?> map, boolean trimStrings, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is negative. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not negative
 *
 * Implementation Notes:
 * 1. If value >= 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be negative");
 * @throws T if the given value is not negative
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNegative<T extends Throwable>(double value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is positive. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not positive
 *
 * Implementation Notes:
 * 1. If value <= 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be positive");
 * @throws T if the given value is not positive
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkPositive<T extends Throwable>(double value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not negative. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is negative
 *
 * Implementation Notes:
 * 1. If value < 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be not negative");
 * @throws T if the given value is negative
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotNegative<T extends Throwable>(double value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not positive. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is positive
 *
 * Implementation Notes:
 * 1. If value > 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be not positive");
 * @throws T if the given value is positive
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotPositive<T extends Throwable>(double value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not equal to zero. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is equal to 0
 *
 * Implementation Notes:
 * 1. If value == 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not be equal to 0");
 * @throws T if the given value is equal to 0
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotZero<T extends Throwable>(double value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is greater than (greater than or equal to, if inclusive is true) than the specified number. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * number - the number the value should be compared to
 * inclusive - true if "greater than or equal to" check should be performed, false if "greater than" check should be performed
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not greater than (not greater than and not equal to, if inclusive is true) than the specified number
 *
 * Implementation Notes:
 * 1. If inclusive then
 *      1.1. If value < number then
 *              1.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be greater than or equal to " + number);
 * 2. Else
 *      2.1. If value <= number then
 *              2.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be greater than " + number);
 * @throws T if the given value is not greater than (not greater than and not equal to, if inclusive is true) than the specified number
 * @param inclusive true if "greater than or equal to" check should be performed, false if "greater than" check should be performed
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param number the number the value should be compared to
*/
public static void checkGreaterThan<T extends Throwable>(double value, double number, boolean inclusive, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is less than (less than or equal to, if inclusive is true) than the specified number. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * number - the number the value should be compared to
 * inclusive - true if "less than or equal to" check should be performed, false if "less than" check should be performed
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not less than (not less than and not equal to, if inclusive is true) than the specified number
 *
 * Implementation Notes:
 * 1. If inclusive then
 *      1.1. If value > number then
 *              1.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be less than or equal to " + number);
 * 2. Else
 *      2.1. If value >= number then
 *              2.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be less than " + number);
 * @throws T if the given value is not less than (not less than and not equal to, if inclusive is true) than the specified number
 * @param inclusive true if "less than or equal to" check should be performed, false if "less than" check should be performed
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param number the number the value should be compared to
*/
public static void checkLessThan<T extends Throwable>(double value, double number, boolean inclusive, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is in the specified range. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * from - the start value of the range
 * to - the end value of the range
 * fromInclusive - true if start value is included into the range, false otherwise
 * toInclusive - true if end value is included into the range, false otherwise
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is out of the specified range
 *
 * Implementation Notes:
 * 1. boolean valid;
 * 2. If fromInclusive then
 *      2.1. valid = (value >= from);
 * 3. Else
 *      3.1. valid = (value > from);
 * 4. If valid then
 *      4.1. If toInclusive then
 *              4.1.1. valid = (value <= to);
 *      4.2. Else
 *              4.2.1. valid = (value < to);
 * 5. If not valid then
 *      5.1. String message = name + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (toInclusive ? "]" : ")");
 *      5.2. Throw ExceptionHelper.constructException(exceptionClass, message).
 * @throws T if the given value is out of the specified range
 * @param to the end value of the range
 * @param exceptionClass the exception class
 * @param fromInclusive true if start value is included into the range, false otherwise
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param toInclusive true if end value is included into the range, false otherwise
 * @param from the start value of the range
*/
public static void checkInRange<T extends Throwable>(double value, double from, double to, boolean fromInclusive, boolean toInclusive, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is negative. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not negative
 *
 * Implementation Notes:
 * 1. If value >= 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be negative");
 * @throws T if the given value is not negative
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNegative<T extends Throwable>(long value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is positive. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not positive
 *
 * Implementation Notes:
 * 1. If value <= 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be positive");
 * @throws T if the given value is not positive
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkPositive<T extends Throwable>(long value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not negative. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is negative
 *
 * Implementation Notes:
 * 1. If value < 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be not negative");
 * @throws T if the given value is negative
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotNegative<T extends Throwable>(long value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not positive. And if this condition is not met, the specified exception is thrown.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is positive
 *
 * Implementation Notes:
 * 1. If value > 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be not positive");
 * @throws T if the given value is positive
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotPositive<T extends Throwable>(long value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is not equal to zero. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is equal to 0
 *
 * Implementation Notes:
 * 1. If value == 0 then
 *      1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should not be equal to 0");
 * @throws T if the given value is equal to 0
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
*/
public static void checkNotZero<T extends Throwable>(long value, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is greater than (greater than or equal to, if inclusive is true) than the specified number. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * number - the number the value should be compared to
 * inclusive - true if "greater than or equal to" check should be performed, false if "greater than" check should be performed
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not greater than (not greater than and not equal to, if inclusive is true) than the specified number
 *
 * Implementation Notes:
 * 1. If inclusive then
 *      1.1. If value < number then
 *              1.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be greater than or equal to " + number);
 * 2. Else
 *      2.1. If value <= number then
 *              2.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be greater than " + number);
 * @throws T if the given value is not greater than (not greater than and not equal to, if inclusive is true) than the specified number
 * @param inclusive true if "greater than or equal to" check should be performed, false if "greater than" check should be performed
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param number the number the value should be compared to
*/
public static void checkGreaterThan<T extends Throwable>(long value, long number, boolean inclusive, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is less than (less than or equal to, if inclusive is true) than the specified number. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * number - the number the value should be compared to
 * inclusive - true if "less than or equal to" check should be performed, false if "less than" check should be performed
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is not less than (not less than and not equal to, if inclusive is true) than the specified number
 *
 * Implementation Notes:
 * 1. If inclusive then
 *      1.1. If value > number then
 *              1.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be less than or equal to " + number);
 * 2. Else
 *      2.1. If value >= number then
 *              2.1.1. Throw ExceptionHelper.constructException(exceptionClass, name + " should be less than " + number);
 * @throws T if the given value is not less than (not less than and not equal to, if inclusive is true) than the specified number
 * @param inclusive true if "less than or equal to" check should be performed, false if "less than" check should be performed
 * @param exceptionClass the exception class
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param number the number the value should be compared to
*/
public static void checkLessThan<T extends Throwable>(long value, long number, boolean inclusive, String name, Class<T> exceptionClass) {
}
/**
 * Checks whether the given value is in the specified range. And if this condition is not met, the specified exception is thrown.
 * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating point numbers. Inclusive comparison is recommended to be used with integral types only.
 *
 * Generic Parameters:
 * T - the type of the exception to be thrown when validation fails
 *
 * Parameters:
 * value - the value to be checked
 * from - the start value of the range
 * to - the end value of the range
 * fromInclusive - true if start value is included into the range, false otherwise
 * toInclusive - true if end value is included into the range, false otherwise
 * name - the name associated with the value
 * exceptionClass - the exception class
 *
 * Throws:
 * T if the given value is out of the specified range
 *
 * Implementation Notes:
 * 1. boolean valid;
 * 2. If fromInclusive then
 *      2.1. valid = (value >= from);
 * 3. Else
 *      3.1. valid = (value > from);
 * 4. If valid then
 *      4.1. If toInclusive then
 *              4.1.1. valid = (value <= to);
 *      4.2. Else
 *              4.2.1. valid = (value < to);
 * 5. If not valid then
 *      5.1. String message = name + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (toInclusive ? "]" : ")");
 *      5.2. Throw ExceptionHelper.constructException(exceptionClass, message).
 * @throws T if the given value is out of the specified range
 * @param to the end value of the range
 * @param exceptionClass the exception class
 * @param fromInclusive true if start value is included into the range, false otherwise
 * @param name the name associated with the value
 * @param value the value to be checked
 * @param toInclusive true if end value is included into the range, false otherwise
 * @param from the start value of the range
*/
public static void checkInRange<T extends Throwable>(long value, long from, long to, boolean fromInclusive, boolean toInclusive, String name, Class<T> exceptionClass) {
}
}

