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

    @Test
    @DisplayName("Validate XSD base type restriction")
    void testValidateXsdBaseTypeRestriction() {
        assertTrue(
            XmlValidator.validate(
                getFile("schema/restriction/base_type_restriction.xsd"),
                getFile("schema/restriction/base_type_restriction_valid.xml")
            )
        );

        assertFalse(
            XmlValidator.validate(
                getFile("schema/restriction/base_type_restriction.xsd"),
                getFile("schema/restriction/base_type_restriction_novalid.xml")
            )
        );
    }

    @Test
    @DisplayName("Validate XSD base type restriction with regex pattern")
    void testValidateXsdBaseTypeRestrictionWithRegexPattern() {
        assertTrue(
            XmlValidator.validate(
                getFile("schema/restriction/base_type_restriction_with_pattern.xsd"),
                getFile("schema/restriction/base_type_restriction_with_pattern_valid.xml")
            )
        );

        assertFalse(
            XmlValidator.validate(
                getFile("schema/restriction/base_type_restriction_with_pattern.xsd"),
                getFile("schema/restriction/base_type_restriction_with_pattern_novalid.xml")
            )
        );
    }

    private File getFile(String fileName) {
        return Paths.get("src", "test", "resources").resolve(fileName).toFile();
    }
}
