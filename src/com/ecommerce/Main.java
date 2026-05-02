
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import interfaces.Validation;
import interfaces.Validator;
import models.User;
import repositories.UserRepository;
import models.Address;
import models.Employee;
import models.Item;
import models.Order;
import models.Produit;
import models.Transaction;

public class Main {

    public static void main(String[] args) {

        /*
         * SKU sku = new SKU("TEC1234");
         *
         * Money price = new Money(new BigDecimal("10000"), "FCFA");
         *
         * Produit produit = new Produit(sku, "Laptop", price);
         *
         * System.out.println("Prix initial: " + produit.getPrice());
         *
         * produit.applyDiscount(new BigDecimal("10"));
         *
         * System.out.println("Prix après remise: " + produit.getPrice());
         *
         * try {
         * new SKU("AA");
         * } catch (Exception e) {
         * System.out.println("Erreur SKU: " + e.getMessage());
         * }
         *
         * try {
         * new Money(new BigDecimal("1000"), "USD");
         * } catch (Exception e) {
         * System.out.println("Erreur currency: " + e.getMessage());
         * }
         *
         * try {
         * Money m1 = new Money(new BigDecimal("1000"), "FCFA");
         * Money m2 = new Money(new BigDecimal("10"), "EUR");
         * m1.add(m2);
         * } catch (Exception e) {
         * System.out.println("Erreur addition: " + e.getMessage());
         * }
         *
         * Consumer<String> logger = s -> System.out.println("[LOG] " +
         * s.toUpperCase());
         *
         * /* Predicate<List<User>> isActive = u -> u.stream().allMatch(User::isActive);
         *
         * List<User> users = List.of(new User(" Alice", "alice@example.com",
         * "password123"),
         * new User("Bob", "bob@example.com", "password456"));
         *
         * boolean allActive = isActive.test(users);
         * List<User> activeUsers =
         * users.stream().filter(isActive.test(users)).collect(Collectors.toList());
         * System.out.println("Tous les utilisateurs sont actifs ? " +
         * activeUsers.size());
         */

        Predicate<Integer> isPositive = number -> number != null && number > 0;
        System.out.println("Is 5 positive? " + isPositive.test(5));
        System.out.println("Is -3 positive? " + isPositive.test(-3));
        System.out.println("Is null positive? " + isPositive.test(null));
        System.out.println("##################################");
        String log = "LOG";

        Consumer<String> printMessage = message -> System.out.println("Message: " + log + " " + message.toUpperCase());
        printMessage.accept("Hello, World!");

        System.out.println("##################################");
        System.out.println("String length: " + Validation.doubleValue().apply("10"));

        Supplier<Double> interestRateSupplier = () -> Math.random();
        System.out.println("##################################");
        System.out.println(interestRateSupplier.get());
        String email = "teste@example.com";

        Validator test = new Validator() {
            @Override
            public boolean validate(String s) {
                return s != null && s.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
            }
        };

        System.out.println("##################################");
        System.out.println("Is valid email? " + test.validate(email));

        System.out.println("##################################");
        List<String> fruits = List.of("apple", "banana", "cherry");
        fruits.stream().filter(fruit -> fruit.startsWith("a")).forEach(fruit -> System.out.println("Fruit: " + fruit));

        System.out.println("##################################");
        List<User> users1 = List.of(
                new User("Alice", "alice@example.com", "password123", new Address("Rue de Paris")),
                new User("Bob", "bob@example.com", "password456", null));

        users1.stream().filter(User::isActive).forEach(user -> System.out.println("Active user: " + user.getNom()));

        List<Integer> prices = List.of(100, 200, 300);
        int totalPrice = prices.stream().reduce(0, Integer::sum);
        System.out.println("Total price: " + totalPrice);

        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "David");
        names.stream().distinct().forEach(name -> System.out.println("Name: " + name));

        Optional<User> admin = users1.stream().findAny();
        admin.ifPresent(user -> System.out.println("Admin user: " + user.getNom()));

        System.out.println("##################################");
        List<Transaction> transactions = List.of(
                new Transaction("USD", 100, "STANDARD"),
                new Transaction("EUR", 200, "STANDARD"),
                new Transaction("USD", 150, "PREMIUM"),
                new Transaction("JPY", 300, "PREMIUM"));
        Map<String, List<Transaction>> byCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println("Transactions by currency: " + byCurrency);
        System.out.println("##################################");

        List<Produit<String, Double>> products = new ArrayList<>();
        products.add(new Produit<>("ID1", "Livre", 15.0));
        products.add(new Produit<>("ID2", "Stylo", 2.5));

        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(p -> p.getPrice()));

        System.out.println("Max : " + stats.getMax());
        System.out.println("Min : " + stats.getMin());
        System.out.println("Moyenne : " + stats.getAverage());
        System.out.println("Somme : " + stats.getSum());
        System.out.println("Nombre d'éléments : " + stats.getCount());
        System.out.println("##################################");
        List<Student> students = Arrays.asList(
                new Student("Alice", 14.5),
                new Student("Bob", 8.0),
                new Student("Charlie", 12.0),
                new Student("Damien", 9.5));
        Map<Boolean, List<Student>> results = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getNote() >= 10));

        List<Student> recus = results.get(true);
        List<Student> ajournes = results.get(false);
        System.out.println("Recus : " + recus);
        System.out.println("Ajournes : " + ajournes);
        System.out.println("##################################");
        System.out.println("##################################");
        Item clavier = new Item("Clavier", 50.0);
        Item souris = new Item("Souris", 25.0);
        Item ecran = new Item("Ecran", 200.0);

        Order commande1 = new Order("CMD-001");
        commande1.addItem(clavier);
        commande1.addItem(souris);

        Order commande2 = new Order("CMD-002");
        commande2.addItem(ecran);
        commande2.addItem(souris);

        List<Order> orders = Arrays.asList(commande1, commande2);

        List<Item> allItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toList());

        System.out.println("Tous les articles cumulés :");
        allItems.forEach(System.out::println);
        System.out.println("##################################");
        System.out.println("##################################");
        Address maRue = new Address("10 Rue des Développeurs");
        User user = new User("Jean Dupont", "jean.dupont@email.com", "securePass123", maRue);
        String street = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Rue inconnue");
        System.out.println("Rue de l'utilisateur : " + street);
        System.out.println("##################################");
        System.out.println("##################################");
        Predicate<Transaction> isPositives = t -> t.getAmount() > 0;

        Predicate<Transaction> isXof = t -> t.getAmount() > 0 && "XOF".equals(t.getCurrency());

        Predicate<Transaction> isPremium = t -> "PREMIUM".equals(t.getUserType());
        Predicate<Transaction> complexValidator = isPositives
                .and(isXof)
                .or(isPremium);
        Transaction t1 = new Transaction("XOF", 100, "STANDARD");
        Transaction t2 = new Transaction("USD", 150, "PREMIUM");
        System.out.println("Transaction 1 valid? " + complexValidator.test(t1));
        System.out.println("Transaction 2 valid? " + complexValidator.test(t2));
        System.out.println("##################################");
        System.out.println("##################################");

        List<String> ids = List.of("1", "2", "3");

        UserRepository repository = new UserRepository() {
            @Override
            public Optional<User> findById(String id) {
                return Optional.of(new User("User " + id, id + "@test.com", "password123", null));
            }
        };
        List<User> existingUsers = ids.stream()
                .map(repository::findById)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println("Utilisateurs existants : " + existingUsers);
        System.out.println("##################################");
        System.out.println("##################################");

        
        List<String> csvLines = Arrays.asList(
                "Alice;30;2500.0",
                "Bob;inconnu;3000.0",
                "Charlie;45;invalid",
                "Damien;25;1800.0",
                "ErreurLigne"
        );
        List<Employee> employees = csvLines.stream()
                .map(line -> {
                    try {
                        String[] parts = line.split(";");
                        String nom = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        double salaire = Double.parseDouble(parts[2]);
                        return Optional.of(new Employee(nom, age, salaire));
                    } catch (Exception e) {
                        return Optional.<Employee>empty();
                    }
                })
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println("Employés valides : " + employees);

    }
}
