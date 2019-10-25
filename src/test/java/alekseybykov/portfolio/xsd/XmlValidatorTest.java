//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.xsd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 2019-10-25
 */
@DisplayName("Tests for XML documents validation by XSD schemas")
class XmlValidatorTest {

    @Test
    @DisplayName("Validate simple type")
    void testValidateSimpleType() {
        assertTrue(
            XmlValidator.validate(getFile("simple_type.xsd"), getFile("simple_type.xml"))
        );
    }

    private File getFile(String fileName) {
        return Paths.get("src", "test", "resources").resolve(fileName).toFile();
    }
}
