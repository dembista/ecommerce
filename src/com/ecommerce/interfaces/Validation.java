package interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validation {
    Predicate<String> isValidEmail = email -> email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    Predicate<String> isValidPassword = password -> password != null && password.length() >= 6;
    Predicate<String> isValidSKU = sku -> sku != null && !sku.isBlank() && sku.matches("^[A-Z0-9]+$");
    Predicate<String> isValidName = name -> name != null && !name.isBlank();
     public static Function<String, Integer> doubleValue() {return  s -> Integer.parseInt(s)*2;};
    Consumer<String> printValidationError = message -> System.out.println("Validation error: " + message);
}
