package utils;

import java.util.logging.Logger;

public class LoggerUtils {
    private static final Logger logger =
            Logger.getLogger(
                    LoggerUtils.class.getName()
            );

    public static void info(String message){
        logger.info(message);
    }
}
