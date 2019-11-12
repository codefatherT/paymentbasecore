package com.gaoyang.service.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


public class LogExceptionWapper {

    private LogExceptionWapper() {}

    /**
     * 获取完整栈轨迹
     *
     * @param aThrowable
     * @return
     */
    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }
}
