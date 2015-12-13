package org.fits.managers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by developer on 13.12.2015.
 */
public class PDFmanager {

    public static void addImgToDPF(byte[] image) throws DocumentException, IOException {
        Document document   = new Document(PageSize.A4); // create new doc

        Image image2 = Image.getInstance(image); // get image
        image2.scaleToFit(200,200);

        PdfReader reader    = new PdfReader("E:\\developer\\IdeaProjects\\pdf\\file.pdf"); // read pdf
        PdfWriter writer    = PdfWriter.getInstance(document, new FileOutputStream("E:\\developer\\IdeaProjects\\pdf\\file_modern.pdf")); // create pdf writer

        int numberOfPages   = reader.getNumberOfPages(); // count of pages file

        image2.setAbsolutePosition(90f, 220f);

        document.open();

        PdfContentByte cb = writer.getDirectContent();
        PdfImportedPage page = null;

        for(int i=1; i<=numberOfPages; i++ ) {

            page = writer.getImportedPage(reader, i); // get (i) page from pdf document

            document.newPage(); // create new page
            cb.addTemplate(page, 0, 0);

            if(i>1) image2.setAbsolutePosition(110f, 85f);

            document.add(image2);
        }

        document.close();

    }
}

