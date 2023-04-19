/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prx301_xml;

/**
 *
 * @author atbgl
 */

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PDFFile {
	public static void exportToPDF(String xmlFileName, String pdfFileName) throws FileNotFoundException, XPathExpressionException {
		xmlFileName = "employee.xml";
                pdfFileName = "employee.pdf";

        try {
            // Parse the XML data
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse("employee.xml");
            doc.getDocumentElement().normalize();

            // Create a new PDF document
            PdfWriter writer = new PdfWriter(pdfFileName);
            PdfDocument pdf = new PdfDocument(writer);
            XPath xp = XPathFactory.newInstance().newXPath();
            Document document = new Document(pdf);

            // Add the XML data to the PDF document
            NodeList nodeList = (NodeList) xp.compile("//Employee").evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                String data = nodeList.item(i).getTextContent();
                document.add(new Paragraph(data));
            }

            // Close the PDF document
            document.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
