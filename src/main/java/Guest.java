public class Guest {
    String name;
    double money;

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
