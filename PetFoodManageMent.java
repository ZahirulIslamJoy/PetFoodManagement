import java.util.ArrayList;
import java.util.List;

abstract class CatFood {
    private String brand;
    private double price;

    public CatFood(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();
}

class DryCatFood extends CatFood {
    private String flavor;

    public DryCatFood(String brand, double price, String flavor) {
        super(brand, price);
        this.flavor = flavor;
    }

    @Override
    public String getType() {
        return "Dry";
    }

    public String getFlavor() {
        return flavor;
    }
}

class WetCatFood extends CatFood {
    private String style;

    public WetCatFood(String brand, double price, String style) {
        super(brand, price);
        this.style = style;
    }

    @Override
    public String getType() {
        return "Wet";
    }

    public String getStyle() {
        return style;
    }
}

class CatFoodInventory {
    private List<CatFood> catFoods;

    public CatFoodInventory() {
        catFoods = new ArrayList<>();
    }

    public void addCatFood(CatFood catFood) {
        catFoods.add(catFood);
    }

    public void listCatFoods() {
        for (CatFood catFood : catFoods) {
            System.out.println("Brand: " + catFood.getBrand());
            System.out.println("Price: $" + catFood.getPrice());
            System.out.println("Type: " + catFood.getType());

            if (catFood instanceof DryCatFood) {
                DryCatFood dryCatFood = (DryCatFood) catFood;
                System.out.println("Flavor: " + dryCatFood.getFlavor());
            } else if (catFood instanceof WetCatFood) {
                WetCatFood wetCatFood = (WetCatFood) catFood;
                System.out.println("Style: " + wetCatFood.getStyle());
            }

            System.out.println();
        }
    }
}

public class PetFoodManagement{
    public static void main(String[] args) {
        CatFoodInventory catFoodInventory = new CatFoodInventory();
        CatFood dryFood = new DryCatFood("Chicken Curry",12, "Chicken");
        CatFood wetFood = new WetCatFood("Milk",7, "Milk Powder");

        catFoodInventory.addCatFood(dryFood);
        catFoodInventory.addCatFood(wetFood);
        catFoodInventory.listCatFoods();
    }
}

