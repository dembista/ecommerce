
public record SKU(String value) {
    public SKU {
        if (value == null || value.isBlank() || !value.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("SKU ne doit pas être null ou vide et doit être alphanumérique en majuscules");
        }
    }
}
