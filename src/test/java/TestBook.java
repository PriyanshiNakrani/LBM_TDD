import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.Book;

public class TestBook {
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenCalledWithNullArguments() {
        assertThrows(IllegalArgumentException.class,() -> new Book());
    }    
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenTitleStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Book("123Effective Java", "Joshua Bloch", "1234567890", 2008));
    }
}
