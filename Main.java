package HardLevel;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService bankService = context.getBean(BankService.class);

        try {
            bankService.transfer(1, 2, 5000); // transfer Rs.5000 from A/c 1 to 2
            System.out.println("Transfer successful!");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        context.close();
    }
}
