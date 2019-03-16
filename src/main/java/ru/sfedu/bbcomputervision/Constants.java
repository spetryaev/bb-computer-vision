package ru.sfedu.bbcomputervision;

import ru.sfedu.bbcomputervision.util.ConfigurationUtil;
import sun.awt.OSInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import org.apache.log4j.Logger;

public class Constants {

    private static Logger log = Logger.getLogger(Constants.class);

    private static final String OS_TYPE = System.getProperty("os.name", "generic").toUpperCase(Locale.ENGLISH);

    public static final String OPENCV_LIB_PATH = getProperty("OPENCV_LIB_PATH");

    public static OSInfo.OSType getOperatingSystemType(){
        log.debug("OS TYPE: " + OS_TYPE);
        switch (OS_TYPE){
            case "MAC":
            case "DARWIN": {
                return OSInfo.OSType.MACOSX;
            }
            case "NUX":{
                return OSInfo.OSType.LINUX;
            }
            case "WIN":{
                return OSInfo.OSType.WINDOWS;
            }
            default:{
                return OSInfo.OSType.UNKNOWN;
            }
        }
    }


    public static String getOpenCvPath() throws FileNotFoundException {
        if (isFileExist(OPENCV_LIB_PATH)){
            return OPENCV_LIB_PATH;
        } else {
            throw new FileNotFoundException("Cannot find OpenCV library file. Check path variable");
        }
    }

    private static boolean isFileExist(String path){
        File file = new File(path);
        if ( file.exists() ) {
            log.debug("\"isFileExists\" => file exists");
            return true;
        }
        else {
            return false;
        }
    }

    private static String getProperty(String key){
        ConfigurationUtil config = new ConfigurationUtil("/config.properties");
        log.debug("Obtaining progerty: " + key);
        return config.readConfig(key);
    }
}
