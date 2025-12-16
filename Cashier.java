package M3_Activity;
import java.util.Scanner;

public class Cashier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Products product=new Products();
		
		int option;

		product.initialProduct();
		do 
		{	
			System.out.println("====================================");
			System.out.println("| Cashier Checkout Menu            |");
			System.out.println("| 1 - Add a product                |");
			System.out.println("| 2 - Process next product         |");
			System.out.println("| 3 - Check number of products     |");
			System.out.println("| 4 - View total bill so far       |");
			System.out.println("| 5 - Exit                         |");
			System.out.println("====================================");
			System.out.print("Enter Choice:");
		
				option = sc.nextInt();				
				switch (option)
				{
				case 1:
					product.addProduct(sc);
					break;
		        case 2:
		        	//product.processNextProduct();
		        	product.processNextProduct();
		        	break;
		        case 3:
		        	product.countProductList();
		        	break;
		        case 4:
		        	product.totalBill();
		        	break;
		        case 5:
		        	product.finalBill();
		        	System.out.println("Exiting");
		        	System.exit(0);
		        default:
		            System.out.println("Invalid option! Please try again.\n");
				}
		}
		while (option != 5);
			sc.close();
			System.exit(0);
	}

}
