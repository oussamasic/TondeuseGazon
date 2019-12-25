package TondeuseAuto.Tondeuse;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.service.TondeuseConfiguratorByFile;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Tondeuse Application" );
        
        
    	if(args != null && args.length == 1) {
			try {
				TondeuseConfiguratorByFile tondeusesConfigurator = new TondeuseConfiguratorByFile(args[0]);
				System.out.println(tondeusesConfigurator.starTondeuse());
			} catch (FileException e) {
				System.out.println(e.getMessageLong());
			}
		}
		else {
			System.out.println("il faut un nom  valide en argument.");
		}
	}
    }

