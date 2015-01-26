import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CurrencyConverter {
    private ArrayList<String> names, descs;
    private ArrayList<Double> vals;

    // Creates a converter class based on an input file.
    public CurrencyConverter( String file ) throws Exception {
	names= new ArrayList<String>();  //Create 3 empty Array list.
        descs = new ArrayList<String>();
        vals = new ArrayList<Double>();

	Scanner sc = new Scanner( new File( file ) );
        while(sc.hasNext()){
            String rad=sc.nextLine();
            Scanner sc2=new Scanner(rad);   //Read in the contents and add them to the Array lists.
            names.add(sc2.next().toUpperCase());
	    String val = sc2.next();
	    try {
		vals.add( Double.parseDouble( val ) );
	    }
	    catch( Exception e ) {
		throw new Exception();
	    }
			  
           descs.add(sc2.nextLine());
        }
    }

    // Converts one currency to another; returns a nice string explaining the result.
    public String convert( Double amount, String from, String to ) {
	from = from.toUpperCase();
	to = to.toUpperCase();

	Integer ind_from = names.indexOf( from ), ind_to = names.indexOf( to );

	if( ind_from == -1 )
	    return from + " is an invalid currency.";
	if( ind_to == -1 )
	    return to + " is an invalid currency.";

	return "Converting from " + descs.get( ind_from ) + " to " + descs.get ( ind_to ) + ":\n" +
	    String.format( "%.2f", amount ) + " " + from + " = " +
	    String.format( "%.2f", amount * vals.get( ind_from ) / vals.get( ind_to ) );
    }

    // Converts one currency to the main currency; returns a nice string explaining the result.
    public String convert( Double amount, String from ) {
	return convert( amount, from, names.get( 0 ) );
    }
}

public class currency2x {
    public static void main (String args[]) throws IOException {
        if (args.length != 2 && args.length != 3){
            System.out.println("Usage: java Converter currency amount [currency]");
            System.exit(0);
        }

	// Create a converter:
	CurrencyConverter conv = null;

	try {
	    conv = new CurrencyConverter( "valutor.txt" );
	}
	catch( Exception e ) {
	    System.out.println( "Error: corrupted data file." );
	    System.exit( 0 );
	    return;
	}

	Double amt;
	try {
	    amt = Double.parseDouble( args[1] );
	}
	catch( Exception e ) {
	    System.out.println( "The amount must be a number." );
	    System.exit( 0 );
	    return;
	}

	String ret;

	if( args.length == 3 ) 
	    ret = conv.convert( amt, args[0], args[2] );
	else
	    ret = conv.convert( amt, args[0] );

	System.out.println( ret );

    } //End of main method.
} // End of class





