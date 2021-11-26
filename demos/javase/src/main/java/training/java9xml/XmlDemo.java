package training.java9xml;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.catalog.CatalogFeatures;
import javax.xml.catalog.CatalogManager;
import javax.xml.catalog.CatalogResolver;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;


public class XmlDemo {

    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";


    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
        factory.setNamespaceAware(true);
        factory.setValidating(true);

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        URI catalogUri = XmlDemo.class.getResource("/catalog.xml").toURI();
        CatalogResolver resolver = CatalogManager.catalogResolver(CatalogFeatures.defaults(), catalogUri);
        documentBuilder.setEntityResolver(resolver);

        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }
        });
        Document document = documentBuilder.parse(XmlDemo.class.getResourceAsStream("/books.xml"));
    }
}
