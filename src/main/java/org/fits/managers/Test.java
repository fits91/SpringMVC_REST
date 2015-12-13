package org.fits.managers;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.fits.beans.DocumentBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Created by developer on 13.12.2015.
 */
public class Test {
    public static void main(String[] args) throws IOException, Base64DecodingException, DocumentException {
        DocumentBuilder docB = new DocumentBuilder();
        File imageSign       = new File("E:\\developer\\IdeaProjects\\images\\podpis.png");
        Gson json            = new Gson();

        docB.sid            = "sidxzcxvasdfKLjdafs";
        docB.reg_id         = "NCV1324567999";
        docB.formatType     = "pdf";
        docB.docType        = 1;
        docB.customerSign   = FileManager.getBase64FromFile(imageSign);

        String objJson    = json.toJson(docB);


        PDFmanager.addImgToDPF(FileManager.getBytesFromBase64(docB.customerSign));

//        String str  = "fits";
//        byte[] bstr = str.getBytes();
//
//        String encode = Base64.encode(bstr);
//        byte[] decode = Base64.decode(encode.getBytes());
//
//        System.out.println(encode);
//        System.out.println(new String(decode));

    }
}
