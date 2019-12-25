package TondeuseAuto.Tondeuse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.model.Tondeuse;
import TondeuseAuto.Tondeuse.service.AbstractTondeuse;

public class TestMowersConfigurator extends AbstractTondeuse {

	public TestMowersConfigurator(Tondeuse mower) throws FileException {
		ajouterTondeuse(mower);
	}
	
}
