package com.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlToPdf {

    public static void main(String[] args) throws IOException, DocumentException {
        HtmlToPdf.generatePDFFromHTML("src/input/PDF.html");
    }

    private static void generatePDFFromHTML(String filename) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("src/output/html.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(filename));
        document.close();
    }
}
