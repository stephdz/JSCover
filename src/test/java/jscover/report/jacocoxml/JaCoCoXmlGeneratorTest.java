package jscover.report.jacocoxml;

import jscover.report.Coverable;
import jscover.report.coberturaxml.CoberturaData;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

public class JaCoCoXmlGeneratorTest {
    private JaCoCoXmlGenerator generator = new JaCoCoXmlGenerator();
    Collection<Coverable> files = new HashSet<>();
    CoberturaData data = new CoberturaData(files);

    @Test(expected = RuntimeException.class)
    public void shouldWrapException() {
        generator.generateXml(null, null, null);
    }
}