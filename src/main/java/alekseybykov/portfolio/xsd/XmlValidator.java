package alekseybykov.portfolio.xsd;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class XmlValidator {
    static boolean validate(File schemaFile, File xmlFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        boolean result;
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            result = true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
