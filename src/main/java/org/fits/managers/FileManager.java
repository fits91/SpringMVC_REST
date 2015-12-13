package org.fits.managers;


import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by developer on 13.12.2015.
 */
public class FileManager {

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
        is.close();
        return bytes;
    }

    public static String getBase64FromFile(File file) throws IOException {
        String strBase64 = Base64.encode(getBytesFromFile(file));
        return strBase64;
    }

    public static String getStrFromBase64(String strBase64) throws Base64DecodingException {
        return new String(Base64.decode(strBase64));
    }

    public static byte[] getBytesFromBase64(String strBase64) throws Base64DecodingException {
        return Base64.decode(strBase64);
    }

}
