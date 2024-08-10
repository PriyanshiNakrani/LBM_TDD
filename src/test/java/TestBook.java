import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.Book;

public class TestBook {
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenCalledWithNullArguments() {
        assertThrows(IllegalArgumentException.class,() -> new Book());
    }    
}
