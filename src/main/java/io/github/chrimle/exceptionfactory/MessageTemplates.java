package io.github.chrimle.exceptionfactory;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A collection of <em>preset message-templates</em>.
 *
 * @since 0.1.0
 * @author Chrimle
 */
public final class MessageTemplates {

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
     * <pre>{@code "`example` MUST BE `false`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_FALSE("`%s` MUST be `false`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST BE negative"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_NEGATIVE("`%s` MUST be negative"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST BE positive"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_POSITIVE("`%s` MUST be positive"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST BE `true`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_TRUE("`%s` MUST be `true`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST BE unique"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_UNIQUE("`%s` MUST be unique"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST BE valid"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_VALID("`%s` MUST be valid"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST exist"}</pre>
     *
     * @since 0.1.0
     */
    MUST_EXIST("`%s` MUST exist"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be empty"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_EMPTY("`%s` MUST NOT be empty"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be `null`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_NULL("`%s` MUST NOT be `null`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT exist"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_EXIST("`%s` MUST NOT exist");

    private final String template;

    OneArgTemplate(final String template) {
      this.template = template;
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
    MUST_BE_AT_LEAST("`%s` MUST be at least `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be at most `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_AT_MOST("`%s` MUST be at most `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be greater than `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_GREATER_THAN("`%s` MUST be greater than `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST be less than `42`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_BE_LESS_THAN("`%s` MUST be less than `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST contain `ex`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_CONTAIN("`%s` MUST contain `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST match RegEx `.*`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_MATCH_REGEX("`%s` MUST match RegEx `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT be equal to `example`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_BE_EQUAL_TO("`%s` MUST NOT be equal to `%s`"),
    /**
     * <strong>Example:</strong>
     *
     * <pre>{@code "`example` MUST NOT contain `ex`"}</pre>
     *
     * @since 0.1.0
     */
    MUST_NOT_CONTAIN("`%s` MUST NOT contain `%s`");

    private final String template;

    TwoArgTemplate(final String template) {
      this.template = template;
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
