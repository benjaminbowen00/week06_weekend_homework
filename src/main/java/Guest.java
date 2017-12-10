public class Guest {
    private String name;
    private double money;

    public Guest(String name, double money){
        this.name = name;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }



    public void deductMoney(double amount){
        this.money -= amount;
    }
}
