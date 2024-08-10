import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.User;

public class TestUser {
    
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenUserNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, 12345));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenUserNameContainsNonAlphabeticCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new User("John123", 12345));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenUserNameIsLessThan3Characters() {
        assertThrows(IllegalArgumentException.class, () -> new User("Jo", 12345));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenUserNameStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new User("1John", 12345));
    }
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenUserIdStartsWithAlphabeticValue() {
        assertThrows(IllegalArgumentException.class, () -> new User("John", "A1235"));
    }

}
