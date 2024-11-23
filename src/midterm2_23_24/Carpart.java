package midterm2_23_24;

import java.util.Objects;

public class Carpart implements MarketItem {
    private final int price;
    private final String name;


    public Carpart(int price, String name) {
        if (price <= 0 || name == null) {
            throw new IllegalArgumentException();
        }
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       Carpart carpart = (Carpart) obj;
       return Objects.equals(name, carpart.name);
    }
}
