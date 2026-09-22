import java.util.Scanner;

public class ShopBill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char again;

        // DO-WHILE: serve next customer
        do {
            System.out.print("How many items is the customer buying? ");
            int items = input.nextInt();

            double total = 0;

            // FOR: read each item
            for (int i = 1; i <= items; i++) {
                System.out.print("Item " + i + " price (UGX): ");
                double price = input.nextDouble();

                System.out.print("Item " + i + " quantity: ");
                int qty = input.nextInt();

                // WHILE: quantity must be more than 0
                while (qty <= 0) {
                    System.out.print("Invalid! Enter quantity above 0: ");
                    qty = input.nextInt();
                }

                total += price * qty;
            }

            // TERNARY: 10% discount if total is 50,000 or more
            double discount = (total >= 50000) ? total * 0.10 : 0;
            double payable = total - discount;

            System.out.println("----- RECEIPT -----");
            System.out.println("Total    : UGX " + total);
            System.out.println("Discount : UGX " + discount);
            System.out.println("To pay   : UGX " + payable);
            System.out.println("-------------------");

            System.out.print("Next customer? (y/n): ");
            again = input.next().charAt(0);

        } while (again == 'y' || again == 'Y');
    }
}
