package jscover.report;

import jscover.util.LocalEntityResolver;
import jscover.util.ReThrowingErrorHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XmlTestHelper {

    public static Document parseXml(String xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new LocalEntityResolver());
        //Turn on line below when XML DTD validation will pass.
        builder.setErrorHandler(new ReThrowingErrorHandler());
        return builder.parse(new ByteArrayInputStream(xml.getBytes()));
    }

    public static String getXPath(XPath xpath, Document document, String expression) throws Exception {
        return (String)xpath.evaluate(expression, document, XPathConstants.STRING);
    }
}
