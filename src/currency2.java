import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class currency2 {
    public static void main (String args[]) throws IOException {
        //This i
        // s the
        String val = null;
        String var = null;
        String mot = null;
        try{val = args[0];
            var = args[1];}
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Usage: java Converter currency amount [currency]");
            System.exit(0);
        }

        if (args.length == 3){
            mot = args[2];
        }else{
            mot = "SEK";
        }
        Scanner sc=new Scanner(new File("valutor.txt"));
        List<String>valuta= new ArrayList<String>();
        List<String>vardet= new ArrayList<String>();
        List<String>resten= new ArrayList<String>();
        while(sc.hasNext()){
            String rad=sc.nextLine();
            Scanner sc2=new Scanner(rad);
            valuta.add(sc2.next());
            vardet.add(String.valueOf(sc2.next()));
            resten.add(sc2.nextLine());
        }
        int index_val = valuta.indexOf(val);
        int index_mot = valuta.indexOf(mot);
        if (index_mot == -1){
            System.out.println("'"+mot+"'"+"is not a recognized currency.");
        }else if(index_val == -1){
            System.out.println("'"+val+"'"+" "+"is not a recognized currency.");
        }else {
            Double res_sek = (Double.parseDouble(vardet.get(index_val)))*(Double.parseDouble(var));
            Double res = res_sek/(Double.parseDouble(vardet.get(index_mot)));
            System.out.println(var+" "+val+" = "+String.format("%.2f",res)+" "+mot);}

    }
}





