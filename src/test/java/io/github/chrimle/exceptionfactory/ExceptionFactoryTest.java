package io.github.chrimle.exceptionfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class ExceptionFactoryTest {

  @ParameterizedTest
  @EnumSource(MessageTemplates.OneArgTemplate.class)
  void testOneArgIllegalArgumentOf(MessageTemplates.OneArgTemplate oneArgTemplate) {
    final var exception =
        assertDoesNotThrow(() -> ExceptionFactory.illegalArgumentOf("test", oneArgTemplate));
    assertNotNull(exception);
    assertEquals(oneArgTemplate.format("test"), exception.getMessage());
    assertInstanceOf(IllegalArgumentException.class, exception);
  }

  @ParameterizedTest
  @EnumSource(MessageTemplates.TwoArgTemplate.class)
  void testTwoArgIllegalArgumentOf(MessageTemplates.TwoArgTemplate twoArgTemplate) {
    final var exception =
        assertDoesNotThrow(
            () -> ExceptionFactory.illegalArgumentOf("testKey", twoArgTemplate, "testValue"));
    assertNotNull(exception);
    assertEquals(twoArgTemplate.format("testKey", "testValue"), exception.getMessage());
    assertInstanceOf(IllegalArgumentException.class, exception);
  }

  @ParameterizedTest
  @EnumSource(MessageTemplates.OneArgTemplate.class)
  void testOneArgIllegalStateOf(MessageTemplates.OneArgTemplate oneArgTemplate) {
    final var exception =
        assertDoesNotThrow(() -> ExceptionFactory.illegalStateOf("test", oneArgTemplate));
    assertNotNull(exception);
    assertEquals(oneArgTemplate.format("test"), exception.getMessage());
    assertInstanceOf(IllegalStateException.class, exception);
  }

  @ParameterizedTest
  @EnumSource(MessageTemplates.TwoArgTemplate.class)
  void testTwoArgIllegalStateOf(MessageTemplates.TwoArgTemplate twoArgTemplate) {
    final var exception =
        assertDoesNotThrow(
            () -> ExceptionFactory.illegalStateOf("testKey", twoArgTemplate, "testValue"));
    assertNotNull(exception);
    assertEquals(twoArgTemplate.format("testKey", "testValue"), exception.getMessage());
    assertInstanceOf(IllegalStateException.class, exception);
  }
}
