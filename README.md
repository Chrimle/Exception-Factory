# Exception Factory

*Create `Exception` instances with Factory-methods and Builder patterns!*

## Import the Dependency
```xml
<dependency>
    <groupId>io.github.chrimle</groupId>
    <artifactId>exception-factory</artifactId>
    <version>0.4.0</version>
</dependency>
```

## Example Usage

There are several ways of instantiating `Exception`s using `exception-factory`. Here are some examples, given in the order of quick-and-easy to more customized `Exception`s.

### 1. Using [`ExceptionFactory`](src/main/java/io/github/chrimle/exceptionfactory/ExceptionFactory.java)
Offers the creation of `IllegalArgumentException`s and `IllegalStateException`s, in the following ways:

```java
import io.github.chrimle.exceptionfactory.ExceptionFactory;
import io.github.chrimle.exceptionfactory.MessageTemplates;

import java.util.regex.Pattern;

import static io.github.chrimle.exceptionfactory.MessageTemplates.OneArgTemplate.*;
import static io.github.chrimle.exceptionfactory.MessageTemplates.TwoArgTemplate.MUST_MATCH_REGEX;

// Example of ExceptionFactory
static {
  // Example of a One-Arg MessageTemplate, which throws "`username` MUST NOT be `null`".
  if (username == null)
    throw ExceptionFactory.illegalArgumentOf("username", MUST_NOT_BE_NULL);
  
  // Example of a Two-Arg MessageTemplate, which throws "`username` MUST match the RegEx `^[a-z]{3,15}$`".
  if (!Pattern.matches("^[a-z]{3,15}$", username))
    throw ExceptionFactory.illegalArgumentOf("username", MUST_MATCH_REGEX, "^[a-z]{3,15}$");
}
```
Refer to [`MessageTemplates`](src/main/java/io/github/chrimle/exceptionfactory/MessageTemplates.java) for all available *message templates*.
These are separated by how many *format specifiers* are needed, i.e. `OneArgTemplate` requires ***one*** argument to format the resulting `String`.
For *custom* messages, and/or providing a *cause*, see section below.


### 2. Using [`ExceptionBuilder`](src/main/java/io/github/chrimle/exceptionfactory/ExceptionBuilder.java)
Offers the creation of *any* `Exception`-class, via a *builder-pattern*. This class is used by `ExceptionFactory` internally.

```java
import io.github.chrimle.exceptionfactory.ExceptionBuilder;
import io.github.chrimle.exceptionfactory.MessageTemplates;

import static io.github.chrimle.exceptionfactory.MessageTemplates.TwoArgTemplate.*;

// Example of ExceptionBuilder

static {
  if (1 + 1 == 3) {
    // Creating a plain Exception without message/cause.
    throw ExceptionBuilder.of(MakesNoSenseException.class).build();
  }
  
  try {
    oldUsername = userRepository.getUsername(userId);
  } catch (NoSuchUserException exception) {
    // Creating an exception with a custom message and cause.
    throw ExceptionBuilder.of(IllegalArgumentException.class)
        .setMessage("No user with userId '%s' exists!"::formatted, userId)
        .setCause(exception)
        .build();
  } catch (ExceptionalException exception) {
    // Creating an exception with a custom format message string and cause.
    throw ExceptionBuilder.of(IllegalStateException.class)
        .setMessage("No clue what happened. Time to log everything %s, %s, %s, %s, %s", userId, newUsername, newLanguage, newDescription)
        .setCause(exception)
        .build();
  }

  // Creating an exception with a MessageTemplate. (Similar to ExceptionFactory)
  if (newUsername == oldUsername)
    throw ExceptionBuilder.of(IllegalArgumentException.class)
        .setMessage(MUST_NOT_BE_EQUAL_TO, "newUsername", oldUsername)
        .build();
}
```

## JavaDocs
Please refer to the [JavaDocs](https://javadoc.io/doc/io.github.chrimle/exception-factory/latest/index.html) for further explanations.

