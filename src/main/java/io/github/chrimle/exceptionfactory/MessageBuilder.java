package io.github.chrimle.exceptionfactory;

import static io.github.chrimle.exceptionfactory.MessageTemplates.OneArgTemplate.MUST_NOT_BE_NULL;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Builder of <em>message strings</em>.
 *
 * @since 0.4.0
 */
public final class MessageBuilder {

  private final List<String> words = new ArrayList<>();

  private MessageBuilder() {}

  /**
   * Factory method for instantiating {@link MessageBuilder}.
   *
   * @return a new instance.
   * @since 0.4.0
   */
  @Contract(" -> new")
  public static @NotNull MessageBuilder newMessageBuilder() {
    return new MessageBuilder();
  }

  /**
   * Adds a <em>format specifier</em>, based on the {@code formatClass}, to this builder.
   *
   * @param formatClass to format.
   * @return this builder.
   * @throws IllegalArgumentException if {@code formatClass} is {@code null}.
   * @since 0.4.0
   */
  @Contract("null -> fail; _ -> this")
  public MessageBuilder addFormatSpecifier(final Class<?> formatClass) {
    if (formatClass == null) {
      throw ExceptionFactory.illegalArgumentOf("formatClass", MUST_NOT_BE_NULL);
    }
    if (formatClass == Integer.class) {
      return addCodeQuote("%d");
    }
    if (formatClass == Float.class) {
      return addCodeQuote("%f");
    }
    return addCodeQuote("%s");
  }

  /**
   * Adds a <em>code quoted string representation</em> of the {@code object}, within {@code
   * ``}-quotes, to this builder.
   *
   * @param object to quote and add.
   * @return this builder.
   * @throws IllegalArgumentException if {@code object} is {@code null}.
   * @since 0.4.0
   */
  @Contract("null -> fail; _ -> this")
  public MessageBuilder addCodeQuote(final Object object) {
    if (object == null) {
      throw ExceptionFactory.illegalArgumentOf("object", MUST_NOT_BE_NULL);
    }
    return add("`%s`".formatted(object));
  }

  /**
   * Adds a <em>string representation</em> of the {@code object}, via {@link Object#toString()}, to
   * this builder.
   *
   * @param object to add.
   * @throws IllegalArgumentException if {@code object} is {@code null}.
   * @return this builder.
   * @since 0.4.0
   */
  @Contract("null -> fail; _ -> this")
  public MessageBuilder add(final Object object) {
    if (object == null) {
      throw ExceptionFactory.illegalArgumentOf("object", MUST_NOT_BE_NULL);
    }
    words.add(object.toString());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return String.join(" ", words);
  }
}
