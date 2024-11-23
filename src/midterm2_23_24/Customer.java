package midterm2_23_24;
    public class Customer {
        private String name;
        int money;
        Cart<MarketItem> cart = new Cart<MarketItem>();

        public Customer(String name, int money) throws IllegalAccessException {
            if (name == null || money < 0) throw new IllegalAccessException("Fuck off!");
            this.name = name;
            this.money = money;
        }

        public void addItemToCart(MarketItem item, int n) {
            this.cart.addItem(item, n);
        }

        public boolean removeItemFromCart(MarketItem item, int n) {
            return this.cart.removeItem(item, n);
        }

        public boolean buyItemsFromCart() {
            int leftMoney;
            try {
                leftMoney = this.cart.checkout(this.money);
            }
            catch (IllegalArgumentException e) {
                return false;
            }
            this.money = leftMoney;
            return true;
        }
    }