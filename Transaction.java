package HardLevel;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private int fromAccountId;
    private int toAccountId;
    private double amount;

    // Getters and setters
}
