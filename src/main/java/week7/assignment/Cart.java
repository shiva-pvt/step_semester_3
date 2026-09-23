package week7.assignment;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
        }
    }

    /** Computes the total from the stored prices on every call. */
    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}
