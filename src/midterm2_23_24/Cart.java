package midterm2_23_24;
import java.util.*;

public class Cart<T extends MarketItem> {
    private Map<T, Integer> cart = new HashMap<>();


    public void addItem(T item, int n) {
        cart.merge(item, n, Integer::sum);
    }

    public boolean removeItem(T item, int n) {
        Integer quantity = this.cart.get(item);

        if (quantity == null || quantity < n) return false;
        else if (quantity == n)
            this.cart.remove(item);
        else
            this.cart.put(item, this.cart.get(item) - n);

        return true;
    }

    public int calculatePrice() {
        return this.cart.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int checkout(int money) {
        int total = this.calculatePrice();

        if (money < total) throw new IllegalArgumentException("Fuck of you beggar!");

        this.cart.clear();
        return money - total;
    }
    public int checkout(int money, int reduction ) {
        int total = this.calculatePrice()* ((100- reduction)/100);

        if (money < total) throw new IllegalArgumentException("Fuck of you beggar!");

        this.cart.clear();
        return money - total;
    }
}