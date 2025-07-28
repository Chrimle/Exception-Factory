package io.github.chrimle.exceptionfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
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

  @Nested
  class SetMessageTests {

    @ParameterizedTest
    @ValueSource(strings = {"", "test"})
    @NullSource
    void testSetMessageMethod(final String message) {
      final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
      assertDoesNotThrow(() -> exceptionBuilder.setMessage(message));
      final var exception = assertDoesNotThrow(exceptionBuilder::build);
      assertEquals(message, exception.getMessage());
    }

    @Nested
    class OneMessageArgTests {

      @ParameterizedTest
      @ValueSource(strings = {"", "test"})
      @NullSource
      void testOneMessageArg(final String messageArg) {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        assertDoesNotThrow(
            () -> exceptionBuilder.setMessage("this is a %s"::formatted, messageArg));
        final var exception = assertDoesNotThrow(exceptionBuilder::build);
        assertEquals("this is a %s".formatted(messageArg), exception.getMessage());
      }

      @Test
      void testNullUnaryOperator() {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        final var exception =
            assertThrows(
                IllegalArgumentException.class,
                () -> exceptionBuilder.setMessage(null, "irrelevant"));
        assertEquals("`messageBuilder` MUST NOT be `null`", exception.getMessage());
      }
    }

    @Nested
    class TwoMessageArgsTests {

      @ParameterizedTest
      @ValueSource(strings = {"", "test"})
      @NullSource
      void testTwoMessageArgs(final String messageArg) {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        assertDoesNotThrow(
            () ->
                exceptionBuilder.setMessage("this is a %s %s"::formatted, messageArg, messageArg));
        final var exception = assertDoesNotThrow(exceptionBuilder::build);
        assertEquals("this is a %s %s".formatted(messageArg, messageArg), exception.getMessage());
      }

      @Test
      void testNullBiFunction() {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        final var exception =
            assertThrows(
                IllegalArgumentException.class,
                () -> exceptionBuilder.setMessage(null, "irrelevant", "also irrelevant"));
        assertEquals("`messageBuilder` MUST NOT be `null`", exception.getMessage());
      }
    }

    @Nested
    class MessageTemplateTests {

      @Test
      void testNullMessageTemplate() {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        final var exception =
            assertThrows(
                IllegalArgumentException.class,
                () -> exceptionBuilder.setMessage((String) null, "irrelevant", "also irrelevant"));
        assertEquals("`messageTemplate` MUST NOT be `null`", exception.getMessage());
      }

      @ParameterizedTest
      @ValueSource(strings = {"", "test"})
      @NullSource
      void testMessageTemplateOneArg(final String messageArg) {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        assertDoesNotThrow(() -> exceptionBuilder.setMessage("this is a %s", messageArg));
        final var exception = assertDoesNotThrow(exceptionBuilder::build);
        assertEquals("this is a %s".formatted(messageArg), exception.getMessage());
      }

      @ParameterizedTest
      @ValueSource(strings = {"", "test"})
      @NullSource
      void testMessageTemplateTwoArgs(final String messageArg) {
        final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
        assertDoesNotThrow(
            () -> exceptionBuilder.setMessage("this is a %s %s", messageArg, messageArg));
        final var exception = assertDoesNotThrow(exceptionBuilder::build);
        assertEquals("this is a %s %s".formatted(messageArg, messageArg), exception.getMessage());
      }
    }
  }

  @Test
  void testSetCauseMethodNull() {
    final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
    assertDoesNotThrow(() -> exceptionBuilder.setCause(null));
    final var exception = assertDoesNotThrow(exceptionBuilder::build);
    assertNull(exception.getCause());
  }

  @Test
  void testSetCauseMethod() {
    final var cause = new Exception("testSetCauseMethod");
    final var exceptionBuilder = ExceptionBuilder.of(Exception.class);
    assertDoesNotThrow(() -> exceptionBuilder.setCause(cause));
    final var exception = assertDoesNotThrow(exceptionBuilder::build);
    assertEquals(cause, exception.getCause());
  }
}
