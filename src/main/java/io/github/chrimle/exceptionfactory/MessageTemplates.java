package io.github.chrimle.exceptionfactory;

import static io.github.chrimle.exceptionfactory.MessageBuilder.newMessageBuilder;
import static io.github.chrimle.exceptionfactory.RequirementLevel.*;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A collection of <em>preset message-templates</em>.
 *
 * @since 0.1.0
 * @author Chrimle
 */
public final class MessageTemplates {

  private static final String BE = "be";
  private static final String AT_LEAST = "at least";
  private static final String EXIST = "exist";
  private static final String POSITIVE = "positive";
  private static final String NEGATIVE = "negative";
  private static final String EMPTY = "empty";
  private static final String VALID = "valid";
  private static final String UNIQUE = "unique";
  private static final String TRUE = "true";
  private static final String FALSE = "false";
  private static final String AT_MOST = "at most";
  private static final String NULL = "null";
  private static final String EQUAL_TO = "equal to";
  private static final String GREATER_THAN = "greater than";
  private static final String AN_INSTANCE_OF = "an instance of";
  private static final String LESS_THAN = "less than";
  private static final String OF_LENGTH = "of length";
  private static final String OF_SIZE = "of size";
  private static final String CONTAIN = "contain";
  private static final String MATCH_REG_EX = "match RegEx";

  private MessageTemplates() {}

  /**
   * Template requiring <strong>ONE</strong> <em>template specifier</em> to format a message.
   *
   * @since 0.1.0
   * @author Chrimle
   */
  public enum OneArgTemplate {
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be `false`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_FALSE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).addCodeQuote(FALSE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be negative"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_NEGATIVE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).add(NEGATIVE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be positive"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_POSITIVE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).add(POSITIVE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be `true`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_TRUE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).addCodeQuote(TRUE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be unique"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_UNIQUE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).add(UNIQUE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be valid"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_VALID(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(BE).add(VALID)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST exist"}</pre>
     *
     * @since 0.1.0
     */
    MUST_EXIST(newMessageBuilder().addFormatSpecifier(String.class).add(MUST).add(EXIST)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be empty"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_EMPTY(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST_NOT).add(BE).add(EMPTY)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be negative"}</pre>
     *
     * @since 0.2.0
     */
    MUST_NOT_BE_NEGATIVE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST_NOT).add(BE).add(NEGATIVE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be `null`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_NULL(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST_NOT)
            .add(BE)
            .addCodeQuote(NULL)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be positive"}</pre>
     *
     * @since 0.2.0
     */
    MUST_NOT_BE_POSITIVE(
        newMessageBuilder().addFormatSpecifier(String.class).add(MUST_NOT).add(BE).add(POSITIVE)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT exist"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_EXIST(newMessageBuilder().addFormatSpecifier(String.class).add(MUST_NOT).add(EXIST));

    private final String template;

    OneArgTemplate(final MessageBuilder messageBuilder) {
      this.template = messageBuilder.toString();
    }

    /**
     * Returns the {@code template} of this constant.
     *
     * @return the {@code template}.
     * @since 0.1.0
     */
    @Contract(pure = true)
    public String getTemplate() {
      return template;
    }

    /**
     * Creates a <em>formatted</em> {@code String} from the {@code template} and {@code arg}.
     *
     * @param arg to be used as a <em>template specifier</em>.
     * @return the formatted String.
     * @since 0.1.0
     */
    @Contract(pure = true)
    public @NotNull String format(final String arg) {
      return String.format(template, arg);
    }
  }

  /**
   * Template requiring <strong>TWO</strong> <em>template specifiers</em> to format a message.
   *
   * @since 0.1.0
   * @author Chrimle
   */
  public enum TwoArgTemplate {
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be at least `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_AT_LEAST(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(AT_LEAST)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be at most `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_AT_MOST(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(AT_MOST)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`actual` MUST be equal to `expected`"}</pre>
     *
     * @see #MUST_NOT_BE_EQUAL_TO
     * @since 0.2.0
     */
    MUST_BE_EQUAL_TO(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(EQUAL_TO)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be greater than `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_GREATER_THAN(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(GREATER_THAN)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be an instance of `ExampleClass`"}</pre>
     *
     * @see #MUST_NOT_BE_INSTANCE_OF
     * @since 0.2.0
     */
    MUST_BE_INSTANCE_OF(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(AN_INSTANCE_OF)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be less than `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_LESS_THAN(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(LESS_THAN)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be of length `42`"}</pre>
     *
     * @since 0.2.0
     */
    MUST_BE_OF_LENGTH(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(OF_LENGTH)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be of size `42`"}</pre>
     *
     * @since 0.2.0
     */
    MUST_BE_OF_SIZE(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(BE)
            .add(OF_SIZE)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST contain `ex`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_CONTAIN(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(CONTAIN)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST match RegEx `.*`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_MATCH_REGEX(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST)
            .add(MATCH_REG_EX)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be equal to `example`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_EQUAL_TO(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST_NOT)
            .add(BE)
            .add(EQUAL_TO)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be an instance of `ExampleClass`"}</pre>
     *
     * @see #MUST_BE_INSTANCE_OF
     * @since 0.2.0
     */
    MUST_NOT_BE_INSTANCE_OF(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST_NOT)
            .add(BE)
            .add(AN_INSTANCE_OF)
            .addFormatSpecifier(String.class)),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT contain `ex`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_CONTAIN(
        newMessageBuilder()
            .addFormatSpecifier(String.class)
            .add(MUST_NOT)
            .add(CONTAIN)
            .addFormatSpecifier(String.class));

    private final String template;

    TwoArgTemplate(final MessageBuilder messageBuilder) {
      this.template = messageBuilder.toString();
    }

    /**
     * Returns the {@code template} of this constant.
     *
     * @return the {@code template}.
     * @since 0.1.0
     */
    @Contract(pure = true)
    public String getTemplate() {
      return template;
    }

    /**
     * Creates a <em>formatted</em> {@code String} from the {@code template} and {@code arg}.
     *
     * @param argOne to be used as the first <em>template specifier</em>.
     * @param argTwo to be used as the second <em>template specifier</em>.
     * @return the formatted String.
     * @since 0.1.0
     */
    @Contract(pure = true)
    public @NotNull String format(final String argOne, final String argTwo) {
      return String.format(template, argOne, argTwo);
    }
  }
}
