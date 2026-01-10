/*Design the KKTea (parent) and KKFlavouredTea (child) classes so that the following output is produced. The KKFlavouredTea class should inherit KKTea and KKTea should inherit the Tea class. Note that: 
1. An object of either class represents a single box of teabags. 
2. Each tea bag weighs 2 grams. 
3. The status of an object refers to whether it is sold or not
 */

public class TeaTester { // Driver code
    public static void main(String[] args) {
        KKTea t1 = new KKTea(250, 50);
        System.out.println("--------1---------");
        t1.productDetail();
        System.out.println("--------2---------");
        KKTea.totalSales();
        System.out.println("--------3---------");
        KKTea t2 = new KKTea(470, 100);
        KKTea t3 = new KKTea(360, 75);
        KKTea.updateSoldStatusRegular(t1);
        KKTea.updateSoldStatusRegular(t2);
        System.out.println("--------4---------");
        t2.productDetail();
        System.out.println("--------5---------");
        KKTea.totalSales();
        System.out.println("--------6---------");
        KKFlavouredTea t4 = new KKFlavouredTea("Jasmine", 260, 50);
        KKFlavouredTea t5 = new KKFlavouredTea("Honey Lemon", 270, 45);
        KKFlavouredTea t6 = new KKFlavouredTea("Honey Lemon", 270, 45);
        System.out.println("--------7---------");
        t4.productDetail();
        System.out.println("--------8---------");
        t6.productDetail();
        System.out.println("--------9---------");
        KKFlavouredTea.updateSoldStatusFlavoured(t4);
        KKFlavouredTea.updateSoldStatusFlavoured(t5);
        KKFlavouredTea.updateSoldStatusFlavoured(t6);
        System.out.println("--------10---------");
        KKTea.totalSales();
    }
}

// Class starts here

class Tea { // GrandParent class
    public String name;
    protected int price;
    protected boolean status;

    public Tea(String name, int price) {
        this.name = name;
        this.price = price;
        this.status = false;
    }

    public void productDetail() {
        System.out.println("Name: " + name + ", Price: " + price);
        System.out.println("Status: " + status);
    }
}

class KKTea extends Tea { // Parent class
    public int weight;
    public int teabags;
    public static int totalSales;
    public static int kktea_count;

    public KKTea(int price, int teabags) {
        super("KK Regular Tea", price);
        this.teabags = teabags;
        this.weight = teabags * 2;
    }

    public void productDetail() {
        super.productDetail();
        System.out.println("Weight: " + weight + ", Tea Bags: " + teabags);
    }

    public static void totalSales() {
        System.out.println("Total Sales: " + totalSales);
        System.out.println("KK Regular Tea: " + kktea_count);
        if (KKFlavouredTea.KKFlavouredTea_count > 0) {
            System.out.println("KK Flavoured Tea: " + KKFlavouredTea.KKFlavouredTea_count);
        }
    }

    public static void updateSoldStatusRegular(KKTea k) {
        if (k.status == false) {
            k.status = true;
            totalSales++;
            kktea_count++;
        }
    }
}

class KKFlavouredTea extends KKTea { // Child class
    public static int KKFlavouredTea_count;

    public KKFlavouredTea(String name, int price, int teabags) {
        super(price, teabags);
        super.name = "KK " + name + " Tea";
    }

    public void productDetail() {
        super.productDetail();
    }

    public static void updateSoldStatusFlavoured(KKFlavouredTea k) {
        if (k.status == false) {
            k.status = true;
            totalSales++;
            KKFlavouredTea_count++;
        }
    }

}