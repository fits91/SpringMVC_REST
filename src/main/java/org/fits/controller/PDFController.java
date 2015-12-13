package org.fits.controller;

import com.itextpdf.text.DocumentException;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.fits.beans.DocumentBuilder;
import org.fits.managers.FileManager;
import org.fits.managers.PDFmanager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by developer on 13.12.2015.
 */
@RequestMapping("/pdf")
@Controller
public class PDFController {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String getDocument(@RequestBody DocumentBuilder docBuilder) throws Base64DecodingException, IOException, DocumentException {

        if (docBuilder.customerSign != null) {
            PDFmanager.addImgToDPF(FileManager.getBytesFromBase64(docBuilder.customerSign));
            return "document created";
        }
        return null;
    }

}
