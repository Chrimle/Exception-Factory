package io.github.chrimle.exceptionfactory;

/**
 * Keywords to indicate <em>requirement levels</em>, as described in <a
 * href="https://www.rfc-editor.org/rfc/rfc2119">RFC 2119</a>.
 *
 * @since 0.3.0
 * @author Chrimle
 */
public enum RequirementLevel {
  /**
   * Synonymous with {@link #OPTIONAL}.
   *
   * <p><strong>Definition</strong>
   *
   * <blockquote>
   *
   * "This word, or the adjective "{@link #OPTIONAL}", mean that an item is truly optional. One
   * vendor may choose to include the item because a particular marketplace requires it or because
   * the vendor feels that it enhances the product while another vendor may omit the same item. An
   * implementation which does not include a particular option MUST be prepared to interoperate with
   * another implementation which does include the option, though perhaps with reduced
   * functionality. In the same vein an implementation which does include a particular option MUST
   * be prepared to interoperate with another implementation which does not include the option
   * (except, of course, for the feature the option provides.)"
   *
   * <p>- <a href="https://www.rfc-editor.org/rfc/rfc2119#section-5">RFC 2119 Section 5</a>
   *
   * </blockquote>
   *
   * @since 0.3.0
   * @see #OPTIONAL
   */
  MAY,
  /**
   * Synonymous with {@link #SHALL} and {@link #REQUIRED}.
   *
   * <p><strong>Definition</strong>
   *
   * <blockquote>
   *
   * "This word, or the terms "{@link #REQUIRED}" or "{@link #SHALL}", mean that the definition is
   * an absolute requirement of the specification."
   *
   * <p>- <a href="https://www.rfc-editor.org/rfc/rfc2119#section-1">RFC 2119 Section 1</a>
   *
   * </blockquote>
   *
   * @since 0.3.0
   * @see #SHALL
   * @see #REQUIRED
   * @see #MUST_NOT
   */
  MUST,
  /**
   * Synonymous with {@link #SHALL_NOT}.
   *
   * <p><strong>Definition</strong>
   *
   * <blockquote>
   *
   * "This phrase, or the phrase "SHALL NOT", mean that the definition is an absolute prohibition of
   * the specification."
   *
   * <p>- <a href="https://www.rfc-editor.org/rfc/rfc2119#section-2">RFC 2119 Section 2</a>
   *
   * </blockquote>
   *
   * @since 0.3.0
   * @see #MUST
   * @see #SHALL_NOT
   */
  MUST_NOT,
  /**
   * Synonymous with {@link #SHOULD_NOT}.
   *
   * @see #SHOULD_NOT
   * @since 0.3.0
   */
  NOT_RECOMMENDED,
  /**
   * Synonymous with {@link #MAY}.
   *
   * @see #MAY
   * @since 0.3.0
   */
  OPTIONAL,
  /**
   * Synonymous with {@link #SHOULD}.
   *
   * @see #SHOULD
   * @see #NOT_RECOMMENDED
   * @since 0.3.0
   */
  RECOMMENDED,
  /**
   * Synonymous with {@link #MUST} and {@link #SHALL}.
   *
   * @since 0.3.0
   * @see #MUST
   * @see #SHALL
   */
  REQUIRED,
  /**
   * Synonymous with {@link #MUST} and {@link #REQUIRED}.
   *
   * @see #MUST
   * @see #REQUIRED
   * @see #SHALL_NOT
   * @since 0.3.0
   */
  SHALL,
  /**
   * Synonymous with {@link #MUST_NOT}.
   *
   * @see #MUST_NOT
   * @see #SHALL
   * @since 0.3.0
   */
  SHALL_NOT,
  /**
   * Synonymous with {@link #RECOMMENDED}.
   *
   * <p><strong>Definition</strong>
   *
   * <blockquote>
   *
   * "This word, or the adjective "{@link #RECOMMENDED}", mean that there may exist valid reasons in
   * particular circumstances to ignore a particular item, but the full implications must be
   * understood and carefully weighed before choosing a different course."
   *
   * <p>- <a href="https://www.rfc-editor.org/rfc/rfc2119#section-3">RFC 2119 Section 3</a>
   *
   * </blockquote>
   *
   * @see #RECOMMENDED
   * @see #SHOULD_NOT
   * @since 0.3.0
   */
  SHOULD,
  /**
   * Synonymous with {@link #NOT_RECOMMENDED}.
   *
   * <p><strong>Definition</strong>
   *
   * <blockquote>
   *
   * "This phrase, or the phrase "{@link #NOT_RECOMMENDED}" mean that there may exist valid reasons
   * in particular circumstances when the particular behavior is acceptable or even useful, but the
   * full implications should be understood and the case carefully weighed before implementing any
   * behavior described with this label."
   *
   * <p>- <a href="https://www.rfc-editor.org/rfc/rfc2119#section-4">RFC 2119 Section 4</a>
   *
   * </blockquote>
   */
  SHOULD_NOT;

  @Override
  public String toString() {
    return name().replace("_", " ");
  }
}
