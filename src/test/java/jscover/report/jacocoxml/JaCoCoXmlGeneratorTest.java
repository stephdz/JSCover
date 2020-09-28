package jscover.report.jacocoxml;

import jscover.report.Coverable;
import jscover.report.CoverageData;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.Collection;
import java.util.HashSet;

import static jscover.report.XmlTestHelper.getXPath;
import static jscover.report.XmlTestHelper.parseXml;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class JaCoCoXmlGeneratorTest {
    private JaCoCoXmlGenerator generator = new JaCoCoXmlGenerator();
    Collection<Coverable> files = new HashSet<>();
    CoverageData data = new CoverageData(files);

    @Test(expected = RuntimeException.class)
    public void shouldWrapException() {
        generator.generateXml(null, null, 123);
    }

    @Test
    public void shouldGenerateXmlSourceAndVersion() throws Exception {
        String xml = generator.generateXml(data, "theId", 123);

        Document document = parseXml(xml);
        XPath xpath = XPathFactory.newInstance().newXPath();
        assertThat(getXPath(xpath, document, "/report/@name"), equalTo("JSCover JaCoCo XML"));
        assertThat(getXPath(xpath, document, "/report/sessioninfo/@id"), equalTo("theId"));
        assertThat(getXPath(xpath, document, "/report/sessioninfo/@start"), equalTo("123"));
        assertThat(getXPath(xpath, document, "/report/sessioninfo/@dump"), equalTo("123"));
    }
}