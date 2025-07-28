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
}
