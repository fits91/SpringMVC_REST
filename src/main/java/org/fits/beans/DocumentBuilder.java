package org.fits.beans;

import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.imageio.ImageIO;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by developer on 13.12.2015.
 */
@XmlRootElement
public class DocumentBuilder {
    public String reg_id;
    public String sid;
    public String formatType;
    public int docType;
    public String clDeskExtId;
    public String stickerSer;
    public String stickerNum;
    public String customerSign;

    @Override
    public String toString() {
        return "DocumentBuilder{" +
                "reg_id='" + reg_id + '\'' +
                ", sid='" + sid + '\'' +
                ", formatType='" + formatType + '\'' +
                ", docType=" + docType +
                ", clDeskExtId='" + clDeskExtId + '\'' +
                ", stickerSer='" + stickerSer + '\'' +
                ", stickerNum='" + stickerNum + '\'' +
                ", customerSign='" + customerSign + '\'' +
                '}';
    }
}
