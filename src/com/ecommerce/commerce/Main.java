package commerce;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("DAKAR-TECH WALLET (DOMAIN-DRIVEN DESIGN)");
        try {
            System.out.print("Test 1 (Montant négatif) : ");
            new Money(new BigDecimal("-500"), "XOF");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCÈS - Erreur capturée : " + e.getMessage());
        }

        Account compteMoussa = new Account(
            new PhoneNumber("771234567"),
            new Money(new BigDecimal("5000"), "XOF")
        );
        Account compteFatou = new Account(
            new PhoneNumber("789876543"),
            new Money(new BigDecimal("1000"), "XOF")
        );

        try {
            System.out.print("\nTest 2 (Devises différentes) : ");
            Money montantDollars = new Money(new BigDecimal("10"), "USD");
            compteMoussa.transfererVers(compteFatou, montantDollars);
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCÈS - Erreur capturée : " + e.getMessage());
        }

        try {
            System.out.print("\nTest 3 (Solde insuffisant) : ");
            Money tropCher = new Money(new BigDecimal("10000"), "XOF");
            compteMoussa.debiter(tropCher);
        } catch (IllegalStateException e) {
            System.out.println("SUCCÈS - Erreur capturée : " + e.getMessage());
        }

        System.out.println("\nTest 4 (Transfert valide) :");
        compteMoussa.transfererVers(compteFatou, new Money(new BigDecimal("2000"), "XOF"));

        System.out.println("\nSolde final Moussa : " + compteMoussa.getBalance().amount());
        System.out.println("Solde final Fatou : " + compteFatou.getBalance().amount());
    }

}
