package M3_Activity;

//import java.util.LinkedHashMap;
//import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Products {
	private String name;
	private double price=0;
	private double totalbill=0;
	private final Queue<Product> list = new LinkedList<>();
	static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() 
        { 
        	return name; 
        }
        public double getPrice() 
        { 
        	return price; 
        }

        @Override
        public String toString() {
            return name +" " +price;
        }
    }
	
    public void initialProduct() {
        list.add(new Product("Laptop", 50000));
        list.add(new Product("Mouse", 500));
        list.add(new Product("Printer", 3000));
        list.add(new Product("Monitor", 5000));
        list.add(new Product("Speaker", 550));
        
        /*for (Product p:list)
        {
        	totalbill+=p.getPrice();
        }*/
        
       }

	public void addProduct(Scanner sc)
	{
		System.out.println("\nEnter product:");
		name=sc.next();

		    if (name == null) 
		    {
		       System.out.println("Product name cannot be empty.");
		            return;
		    }

	    System.out.println("Enter price: ");
	    price = sc.nextDouble();

	    try 
	    {
	        
	    	if (price < 0) 
	    	{
	            System.out.println("Price must be non-negative.");
	            return;
	        }
	    } 
	    catch (Exception e)
	    {
	        System.out.println("Invalid input. Please enter a numeric value.");
	        sc.nextLine(); 
	        return;
	    }
	    list.add(new Product(name, price));
	    //totalbill=totalbill+price;
	    System.out.println("Successfully Added: "+name);

	}
	public void countProductList()
	{
		int i = 1;
		System.out.println("All Product:");
	    System.out.println("No. | Product Name | Price (PHP)");
	
	    for (Product p : list) {
	        System.out.println(i+". " +p.getName()+ " | " + p.getPrice());
	        i++;
	    }
	
	    System.out.println("\nTotal Product: " + list.size());

	}
    public void totalBill() {
    	
        System.out.println("Total bill: " + totalbill);
    }
    
    public void processNextProduct() {
        if (!list.isEmpty()) 
		{
            Product p = list.remove();
            System.out.println("Processed: " + p);
            totalbill=totalbill+p.getPrice();
            System.out.println("Updated Total Bill: ₱" + totalbill);
        } 
		else 
		{
            System.out.println("No more products in the queue.");
        }
    }
    public void finalBill() {
    	
        System.out.println("Closing Cashier Line.... \nFinal Total Bill: " + totalbill);
    }
}
