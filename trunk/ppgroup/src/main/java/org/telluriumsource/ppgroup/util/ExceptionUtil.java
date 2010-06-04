package org.telluriumsource.ppgroup.util;

import java.lang.reflect.UndeclaredThrowableException;

/**
 *
 * @author Jian Fang (John.Jian.Fang@gmail.com)
 *
 */
public class ExceptionUtil {
    
    public static String describeException(Exception exception) {
        StringBuilder sb = new StringBuilder("\n");
        if (exception != null) {
            StackTraceElement[] stackTrace = exception.getStackTrace();
            String exceptionMessage = "";
            if (exception instanceof UndeclaredThrowableException) {
                exceptionMessage = exception.getCause().getMessage();
            } else {
                exceptionMessage = exception.getMessage();
            }
            sb.append(exceptionMessage + "\n");

            for (StackTraceElement st : stackTrace) {
                sb.append(st.toString() + "\n\t\t");
            }
        }

        return sb.toString();
    }
}
