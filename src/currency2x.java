import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class currency2x {
    public static void main (String args[]) throws IOException {
        if (args.length != 2 && args.length != 3){
            System.out.println("Usage: java Converter currency amount [currency]");
            System.exit(0);
        }
        //This is the main method to the program.
        String val = args[0];
        String var = args[1];
        String mot = null;
        // If the "args" is shorter than 2, program will throw a exception and break.

        if (args.length == 3){  //If user hasn't give the third course,
            // program will use "SEK" as default.
            mot = args[2];
        }else {
            mot = "SEK";
        }
        Scanner sc=new Scanner(new File("valutor.txt"));// Use Scanner method to read the txt file.
        List<String>valuta= new ArrayList<String>();  //Create 3 empty Array list.
        List<String>vardet= new ArrayList<String>();
        List<String>resten= new ArrayList<String>();
        while(sc.hasNext()){
            String rad=sc.nextLine();
            Scanner sc2=new Scanner(rad);   //Read in the contents and add them to the Array lists.
            valuta.add(sc2.next());
            vardet.add(String.valueOf(sc2.next()));
            resten.add(sc2.nextLine());
        }
        int index_val = valuta.indexOf(val);  //get the index of the currency in user's input.
        int index_mot = valuta.indexOf(mot);
        if (index_mot == -1){
            System.out.println("'"+mot+"'"+"is not a recognized currency.");
        }else if(index_val == -1){
            System.out.println("'"+val+"'"+" "+"is not a recognized currency.");
        }else {
            Double res_sek = (Double.parseDouble(vardet.get(index_val)))*(Double.parseDouble(var));
            Double res = res_sek/(Double.parseDouble(vardet.get(index_mot)));
            System.out.println(var+" "+val+" = "+String.format("%.2f",res)+" "+mot);} //Do the output.

    } //End of main method.
} // End of class





