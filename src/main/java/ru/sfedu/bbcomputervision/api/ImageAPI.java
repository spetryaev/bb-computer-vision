package ru.sfedu.bbcomputervision.api;

import org.apache.log4j.Logger;
import org.opencv.imgcodecs.Imgcodecs;
import ru.sfedu.bbcomputervision.Constants;

public class ImageAPI {

    private static Logger log = Logger.getLogger(ImageAPI.class);

    public ImageAPI(){
        log.debug("Loading OpenCV dll library");
        try{
            System.load(Constants.getOpenCvPath());
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }


}
