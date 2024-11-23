package midterm2_23_24;

public class Mechanic extends Customer{
    private int reduction;
    public Mechanic(String name, int money) throws IllegalAccessException {
        super(name, money);
    }
    @Override
    public boolean buyItemsFromCart() {
        int leftMoney;
        try {
            leftMoney = this.cart.checkout(this.money,reduction);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        this.money = leftMoney;
        return true;
    }
}
