package io.github.chrimle.exceptionfactory;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <em>Factory</em> of {@link Exception}s and <em>sub-classes</em>.
 *
 * <p><strong>Example Usage</strong>
 *
 * <p>Using {@link MessageTemplates.OneArgTemplate}:
 *
 * <pre>{@code
 * ExceptionFactory.illegalArgumentOf("username", MUST_NOT_BE_NULL);
 * }</pre>
 *
 * Creates a {@link IllegalArgumentException} with a {@code message} as {@code "`username` MUST NOT
 * be `null`"}.
 *
 * <p><em>To provide a {@code cause}, use {@link ExceptionBuilder}.</em>
 *
 * @see ExceptionBuilder
 * @see MessageTemplates
 * @author Chrimle
 * @since 0.1.0
 */
public final class ExceptionFactory {

  private ExceptionFactory() {}

  private static <C extends Exception> C exceptionOf(
      final Class<C> exceptionClass,
      @Nullable final String key,
      final MessageTemplates.OneArgTemplate messageTemplate) {
    if (messageTemplate == null) {
      throw new IllegalArgumentException("`messageTemplate` MUST NOT be `null`");
    }
    return ExceptionBuilder.of(exceptionClass).setMessage(messageTemplate, key).build();
  }

  private static <C extends Exception> C exceptionOf(
      final Class<C> exceptionClass,
      @Nullable final String key,
      final MessageTemplates.TwoArgTemplate messageTemplate,
      final String value) {
    if (messageTemplate == null) {
      throw new IllegalArgumentException("`messageTemplate` MUST NOT be `null`");
    }
    return ExceptionBuilder.of(exceptionClass).setMessage(messageTemplate, key, value).build();
  }

  /**
   * Creates an {@link IllegalArgumentException} instance with the {@code message} derived from the
   * {@code messageTemplate} and {@code key}.
   *
   * @param key to include in the {@code messageTemplate}.
   * @param messageTemplate to create the {@code message}.
   * @return a new {@link IllegalArgumentException} instance.
   * @throws IllegalArgumentException if {@code messageTemplate} is {@code null}.
   * @since 0.1.0
   */
  @Contract("_, null -> fail; _, _ -> new")
  public static @NotNull IllegalArgumentException illegalArgumentOf(
      @Nullable final String key, final MessageTemplates.OneArgTemplate messageTemplate) {
    return exceptionOf(IllegalArgumentException.class, key, messageTemplate);
  }

  /**
   * Creates an {@link IllegalArgumentException} instance with the {@code message} derived from the
   * {@code messageTemplate} and {@code key}.
   *
   * @param key to include in the {@code messageTemplate}.
   * @param messageTemplate to create the {@code message}.
   * @param value to include in the {@code messageTemplate}.
   * @return a new {@link IllegalArgumentException} instance.
   * @throws IllegalArgumentException if {@code messageTemplate} is {@code null}.
   * @since 0.1.0
   */
  @Contract("_, null, _ -> fail; _, _, _ -> new")
  public static @NotNull IllegalArgumentException illegalArgumentOf(
      @Nullable final String key,
      final MessageTemplates.TwoArgTemplate messageTemplate,
      @Nullable final String value) {
    return exceptionOf(IllegalArgumentException.class, key, messageTemplate, value);
  }

  /**
   * Creates an {@link IllegalStateException} instance with the {@code message} derived from the
   * {@code messageTemplate} and {@code key}.
   *
   * @param key to include in the {@code messageTemplate}.
   * @param messageTemplate to create the {@code message}.
   * @return a new {@link IllegalStateException} instance.
   * @throws IllegalArgumentException if {@code messageTemplate} is {@code null}.
   * @since 0.1.0
   */
  @Contract("_, null -> fail; _, _ -> new")
  public static @NotNull IllegalStateException illegalStateOf(
      @Nullable final String key, final MessageTemplates.OneArgTemplate messageTemplate) {
    return exceptionOf(IllegalStateException.class, key, messageTemplate);
  }

  /**
   * Creates an {@link IllegalStateException} instance with the {@code message} derived from the
   * {@code messageTemplate} and {@code key}.
   *
   * @param key to include in the {@code messageTemplate}.
   * @param messageTemplate to create the {@code message}.
   * @param value to include in the {@code messageTemplate}.
   * @return a new {@link IllegalStateException} instance.
   * @throws IllegalArgumentException if {@code messageTemplate} is {@code null}.
   * @since 0.1.0
   */
  @Contract("_, null, _ -> fail; _, _, _ -> new")
  public static @NotNull IllegalStateException illegalStateOf(
      @Nullable final String key,
      final MessageTemplates.TwoArgTemplate messageTemplate,
      @Nullable final String value) {
    return exceptionOf(IllegalStateException.class, key, messageTemplate, value);
  }
}
