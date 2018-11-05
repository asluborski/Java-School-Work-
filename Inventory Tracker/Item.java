


public class Item {
	 private String name;
	   private int quantity;
	   private double price;
	   private String upc;

	   // Constructors

	   private Item() {

	   }

	   public Item(String name,int qty,double price,String upc) {
	       this.name=name;
	       this.quantity=qty;
	       this.price=price;
	       this.upc=upc;
	   }
	   /**
	   * @return the name
	   */
	   public String getName() {
	       return name;
	   }

	   /**
	   * @return the quantity
	   */
	   public int getQuantity() {
	       return quantity;
	   }

	   /**
	   * @return the price
	   */
	   public double getPrice() {
	       return price;
	   }

	   /**
	   * @return the upc
	   */
	   public String getUPC() {
	       return upc;
	   }


	}