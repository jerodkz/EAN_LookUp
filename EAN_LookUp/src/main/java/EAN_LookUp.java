import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EAN_LookUp {



    public static void main(String[] args) {

        List<String> products = new ArrayList<String>();

        try {
            String input = "/home/jerome/IdeaProjects/EAN_LookUp/src/main/java/input.txt";
            BufferedReader br1 = new BufferedReader(new FileReader(input));
            String db = "/home/jerome/IdeaProjects/EAN_LookUp/src/main/resources/db.csv";
            BufferedReader br2 = new BufferedReader(new FileReader(db));

            String name;
            String ean;
            String line1 = br1.readLine();
            String line2;

            while ((line2 = br2.readLine()) != null) {
                String[] field = line2.split("\t");
                ean = field[0];
                name = field[5];

                if ((line1 != null && name.contains(line1))) {
                    products.add(ean + " is ean for " + name);
                }

            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        if(!products.isEmpty()){
            System.out.println(products);
            //create here a JSON file filled with products
            } else {
            //if noting found check in another db
            System.out.println("Please check in another DB!");
        }

    }
}
