package well;

import java.util.Scanner;
import java.io.*;
import java.io.File;

/**
 *
 * @author Brian Albert
 */
public class WellDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Declaring variables
        Well[] myWell;
        double totalCost = 0;
        String filename = "WellData.txt";
        String line;
        String[] tokens;
        char type;
        int depth;
        int count = 0;

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        //Counting number of lines in the data file
        while (inputFile.hasNext()) {
            // Determine whether there is more to read.
            line = inputFile.nextLine();
            if (line.trim().equals("")) {
                break;
            }
            // If so, read the next line
            count++;
        }
        inputFile.close();

        //Initializing object
        myWell = new Well[count];

        // Open the file
        inputFile = new Scanner(file);
        // while file has data and array not full
        int j = 0;
        while (inputFile.hasNext()) {
            // read an entire line from the file
            line = inputFile.nextLine();

            // split the lineread into an array of strings
            tokens = line.split(",");

            //Passing values as integers
            type = tokens[0].charAt(0);
            depth = Integer.parseInt(tokens[1].trim());

            //Creating specific well object
            myWell[j] = new Well(type, depth);
            //Adding to total cost
            totalCost += myWell[j].cost();
            
            j++;
        }
        inputFile.close();

        //Displaying Data
        for (int i = 0; i < myWell.length; i++) {
            System.out.printf(" %d ", i);
            System.out.print(myWell[i]);
            //Displaying the percent of total cost
            System.out.printf("  %% of total cost %.1f\n", ((myWell[i].cost()) / totalCost) * 100);
        }
        System.out.printf("\nTotal Costs = $%,.2f\n", totalCost);
    }
}
