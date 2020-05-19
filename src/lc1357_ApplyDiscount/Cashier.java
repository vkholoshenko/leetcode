package lc1357_ApplyDiscount;

class Cashier {
    private int number;
    private int discount;
    private int[] prices;
    private int n;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.number = 1;
        this.prices = new int[201];
        for (int i = 0; i < products.length; i++) {
            this.prices[products[i]] = prices[i];
        }
        this.discount = discount;
        this.n = n;
    }

    public double getBill(int[] product, int[] amount) {
        double total = 0;
        for (int pi = 0; pi < product.length; pi++) {
            total += prices[product[pi]] * amount[pi];
        }
        if (number == n) {
            total *= (1 - (double)discount/100);
            number = 1;
        } else {
            number++;
        }
        return total;
    }
}

