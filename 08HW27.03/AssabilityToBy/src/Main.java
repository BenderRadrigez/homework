import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account(0, "scientist");
        Car bmw = new Car(10, "scientist");
        Car audi = new Car(10, "captain");
        Phone samsung = new Phone(20, "captain");
        Phone iphone = new Phone(20, "programmer");
        Plane airBaltic = new Plane(10, "scientist");
        Plane airNorthway = new Plane(10, "stylish");
        DownshifterKit myKit = new DownshifterKit(20, "scientist");

        System.out.println(isCanBuying(myAccount.currentAmount, myAccount.category, bmw.price, bmw.category) ? (bmw.category + " " + bmw.price ) : "нет денег на это");

    }

    public static boolean isCanBuying(double currentAmount, String category, double price, String categoryOther){
        if (currentAmount >= price && category.equals(categoryOther)){
            return true;
        }

        return false;
    }
}


//6) В классе Main написать метод , который будет определять по переменным account.currentAmount и account.category c помощью конструкции if->else if… -> else, какой объект из созданных должен купить человек с текущим Account’oм.