package io.github.chrimle.exceptionfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RequirementLevelTest {

  @ParameterizedTest
  @EnumSource(RequirementLevel.class)
  void testToString(final RequirementLevel requirementLevel) {
    assertEquals(requirementLevel.name().replace("_", " "), requirementLevel.toString());
  }
}
