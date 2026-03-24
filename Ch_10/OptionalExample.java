package Ch_10;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> opt = Optional.ofNullable("hello");

// 1. isPresent() / isEmpty()
        opt.isPresent();           // true
        opt.isEmpty();             // false (Java 11+)

// 2. get() — use only after isPresent() check
        opt.get();                 // "hello"

// 3. orElse — default value if empty
        Optional.empty().orElse("default");          // "default"

// 4. orElseGet — lazy default via Supplier
        Optional.empty().orElseGet(() -> "computed"); // "computed"

// 5. orElseThrow — throw if empty
        opt.orElseThrow(() -> new RuntimeException("Not found")); // "hello"

// 6. ifPresent — run action if value exists
        opt.ifPresent(v -> System.out.println("Value: " + v)); // Value: hello

// 7. map — transform the value
        opt.map(String::toUpperCase);          // Optional["HELLO"]

// 8. flatMap — when mapper itself returns Optional
        opt.flatMap(v -> Optional.of(v + "!"));// Optional["hello!"]

// 9. filter — keep value only if predicate passes
        opt.filter(v -> v.startsWith("h"));   // Optional["hello"]
        opt.filter(v -> v.startsWith("z"));   // Optional.empty
    }
}
