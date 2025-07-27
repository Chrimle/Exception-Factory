package io.github.chrimle.exceptionfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionBuilderTest {

  @Test
  void testNullClass() {
    final var exception =
        assertThrows(IllegalArgumentException.class, () -> ExceptionBuilder.of(null));
    assertEquals("`exceptionClass` is `null`", exception.getMessage());
  }

  @ParameterizedTest
  @ValueSource(classes = {NullPointerException.class})
  void testUnsupportedClasses(final Class<? extends Exception> exceptionUnderTest) {
    final var exception =
        assertThrows(IllegalArgumentException.class, () -> ExceptionBuilder.of(exceptionUnderTest));
    assertEquals(
        "`exceptionClass` does NOT have a (`String, Throwable`) constructor",
        exception.getMessage());
  }

  @ParameterizedTest
  @ValueSource(
      classes = {
        IllegalArgumentException.class,
        UnsupportedOperationException.class,
        IllegalStateException.class,
        RuntimeException.class
      })
  void testEmptyException(final Class<? extends Exception> exceptionToBuild) {
    final var exceptionBuilder = assertDoesNotThrow(() -> ExceptionBuilder.of(exceptionToBuild));
    final var exception = assertDoesNotThrow(exceptionBuilder::build);
    assertNotNull(exception);
    assertEquals(exceptionToBuild, exception.getClass());
  }
}
