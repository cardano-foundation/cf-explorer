package util;

//import com.google.common.io.BaseEncoding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import rp.com.google.common.io.BaseEncoding;

public class LogHelper {

    private static LogHelper instance = null;


    private LogHelper() {
    }

    public static LogHelper getInstance() {
        if (instance == null )
        {
            instance = new LogHelper();
        }
        return instance;
    }

    public static Logger getLogger() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        /*
         * stackTrace[0] is for Thread.currentThread().getStackTrace() stackTrace[1] is for this method log()
         */
        String className = stackTrace[1].getClassName();
        return LogManager.getLogger(className);
    }

    public void info(String var1) {
        getLogger().info(var1);
    }

    public void warn(String var1) {
        getLogger().warn(var1);
    }

//    public void log(byte[] bytes, String message) {
//        getLogger().info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64().encode(bytes), message);
//    }

    public void logBase64(String base64, String message) {
        getLogger().info("RP_MESSAGE#BASE64#{}#{}", base64, message);
    }
}
