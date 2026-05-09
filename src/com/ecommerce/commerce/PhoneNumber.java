package commerce;

public record PhoneNumber(String value) {
    private static final String SENEGAL_REGEX = "^(\\+221|00221)?(70|76|77|78|33)[0-9]{7}$";

    public PhoneNumber {
        if (value == null || !value.matches(SENEGAL_REGEX)) {
            throw new IllegalArgumentException("Format de numéro sénégalais invalide.");
        }
    }
}
