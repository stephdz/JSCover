package jscover.report.jacocoxml;

import jscover.report.JSONDataMerger;
import org.junit.Test;

import static jscover.report.XmlTestHelper.parseXml;


public class JaCoCoXmlGeneratorIntegrationTest {
    private JSONDataMerger jsonDataMerger = new JSONDataMerger();

    private String validXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE report PUBLIC \"-//JACOCO//DTD Report 1.1//EN\" \"report.dtd\">\n" +
            "\n" +
            "<report name=\"JSCover\">\n" +
            "</report>";

    @Test
    public void shouldValidateXmlToDtd() throws Exception {
        parseXml(validXml);
    }
}