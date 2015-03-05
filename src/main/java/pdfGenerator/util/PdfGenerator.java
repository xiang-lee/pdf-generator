package pdfGenerator.util;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class PdfGenerator {
	/**  
     * Output a pdf to the specified outputstream  
     *   
     * @param htmlStr is the htmlstr  
     * @param out is the specified outputstream  
     * @throws Exception  
     */  
	
	
	public static void generate(String htmlStr, OutputStream out)     
            throws Exception {     
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();     
        Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes()));     
        ITextRenderer renderer = new ITextRenderer();     
        renderer.setDocument(doc, null);     
        renderer.layout();     
        renderer.createPDF(out);     
        out.close();
        System.out.println("PDF generated successfully..");
    }     
}
