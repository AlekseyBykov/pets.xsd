//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.xsd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 2019-10-25
 */
@DisplayName("Tests for XML documents validation by XSD schemas")
class XmlValidatorTest {

    @Test
    @DisplayName("Validate xsd:double")
    void testValidateXsdDoubleType() {
        assertTrue(
            XmlValidator.validate(
                getFile("schema/type/double.xsd"),
                getFile("schema/type/double_valid.xml")
            )
        );

        assertFalse(
            XmlValidator.validate(
                getFile("schema/type/double.xsd"),
                getFile("schema/type/double_novalid.xml")
            )
        );
    }

    private File getFile(String fileName) {
        return Paths.get("src", "test", "resources").resolve(fileName).toFile();
    }
}
