package commerce;

import java.util.UUID;

public class Account {
private final UUID id;

    private final PhoneNumber ownerPhoneNumber;

    private Money balance;

    public Account(PhoneNumber ownerPhoneNumber, Money initialDeposit) {
        this.id = UUID.randomUUID();
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.balance = initialDeposit;
    }

    public void crediter(Money montant) {
        this.balance = this.balance.add(montant);
        System.out.println("Compte " + ownerPhoneNumber.value() + " crédité de " + montant.amount());
    }

    public void debiter(Money montant) {
        if (!this.balance.isGreaterThan(montant)) {
            throw new IllegalStateException("Solde insuffisant pour débiter " + montant.amount());
        }
        this.balance = this.balance.subtract(montant);
        System.out.println("Compte " + ownerPhoneNumber.value() + " débité de " + montant.amount());
    }


    public void transfererVers(Account destinataire, Money montant) {
        System.out.println("Tentative de transfert de " + montant.amount() + " " + montant.currency() + "...");
        this.debiter(montant);
        destinataire.crediter(montant);
    }

    public Money getBalance() {
        return balance;
    }

    public PhoneNumber getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }
    
}
