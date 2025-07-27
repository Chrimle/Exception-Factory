package io.github.chrimle.exceptionfactory;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <em>Builder</em> of {@link Exception}s.
 *
 * @param <T> {@link Exception}-class <em>instance</em> to build and instantiate.
 * @since 0.1.0
 * @author Chrimle
 */
public final class ExceptionBuilder<T extends Exception> {

  /** The {@link Exception}-class to build and instantiate. */
  private @NotNull final Class<T> exceptionClass;

  /** The {@code message} of the {@link Exception}. */
  private @Nullable String message;

  /** The {@code cause} of the {@link Exception}. */
  private @Nullable Throwable cause;

  /**
   * <em>Private Constructor</em>.
   *
   * @param exceptionClass for the builder.
   */
  @Contract(pure = true)
  private ExceptionBuilder(final @NotNull Class<T> exceptionClass) {
    this.exceptionClass = exceptionClass;
  }

  /**
   * Creates a new {@link ExceptionBuilder} instance for building and instantiating an {@link
   * Exception} of type {@link C}.
   *
   * @param exceptionClass to build and instantiate.
   * @return a new {@link ExceptionBuilder} instance.
   * @param <C> to build and instantiate.
   * @since 0.1.0
   * @throws IllegalArgumentException if {@code exceptionClass} is {@code null}. {@code
   *     exceptionClass} <strong>MUST NOT</strong> be {@code null}.
   * @throws IllegalArgumentException if {@code exceptionClass} does not have a constructor with
   *     method arguments {@code ExampleException(String, Throwable)}. {@code exceptionClass}
   *     <strong>MUST</strong> have a {@code (String, Throwable)} constructor.
   */
  @Contract("null -> fail; _ -> new")
  public static <C extends Exception> @NotNull ExceptionBuilder<C> of(
      final Class<C> exceptionClass) {
    if (exceptionClass == null) {
      throw new IllegalArgumentException("`exceptionClass` is `null`");
    }
    if (!hasStringAndThrowableConstructor(exceptionClass)) {
      throw new IllegalArgumentException(
          "`exceptionClass` does NOT have a (`String, Throwable`) constructor");
    }
    return new ExceptionBuilder<>(exceptionClass);
  }

  /**
   * Checks whether the {@code exceptionClass} has a {@code (String, Throwable)} constructor.
   *
   * @param exceptionClass to check.
   * @return whether the {@code exceptionClass} has the constructor.
   * @since 0.1.0
   */
  @Contract(pure = true)
  private static boolean hasStringAndThrowableConstructor(
      final Class<? extends Exception> exceptionClass) {
    try {
      exceptionClass.getDeclaredConstructor(String.class, Throwable.class);
    } catch (NoSuchMethodException e) {
      return false;
    }
    return true;
  }

  /**
   * Sets the {@code message} to be used when instantiating {@link T}.
   *
   * @param message of the exception. <strong>MAY</strong> be {@code null}.
   * @return <em>this</em> {@link ExceptionBuilder}.
   * @since 0.1.0
   */
  @Contract(value = "_ -> this", mutates = "this")
  public ExceptionBuilder<T> setMessage(@Nullable final String message) {
    this.message = message;
    return this;
  }

  /**
   * Sets the {@code cause} to be used when instantiating {@link T},
   *
   * @param cause of the exception. <strong>MAY</strong> be {@code null}.
   * @return <em>this</em> {@link ExceptionBuilder}.
   * @since 0.1.0
   */
  @Contract(value = "_ -> this", mutates = "this")
  public ExceptionBuilder<T> setCause(@Nullable final Throwable cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Builds the {@link T} instance, by invoking the constructor with {@link #message} and {@link
   * #cause}.
   *
   * @return the new {@link T} instance.
   * @since 0.1.0
   */
  @Contract(" -> new")
  public @NotNull T build() {
    try {
      return exceptionClass
          .getDeclaredConstructor(String.class, Throwable.class)
          .newInstance(message, cause);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException("NoSuchMethodException", e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException("InvocationTargetException", e);
    } catch (InstantiationException e) {
      throw new RuntimeException("InstantiationException", e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException("IllegalAccessException", e);
    }
  }
}
