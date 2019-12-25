package TondeuseAuto.Tondeuse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.exceptions.TondeuseException;
import TondeuseAuto.Tondeuse.model.Pelouse;
import TondeuseAuto.Tondeuse.model.Tondeuse;
import TondeuseAuto.Tondeuse.service.AbstractTondeuse;

class TondeuseTest {

	Tondeuse TondeuseN;
	Tondeuse TondeuseE;
	Tondeuse TondeuseS;
	Tondeuse TondeuseW;
	Pelouse lawn;

	AbstractTondeuse mowersConfiguratorN;
	AbstractTondeuse mowersConfiguratorE;
	AbstractTondeuse mowersConfiguratorS;
	AbstractTondeuse mowersConfiguratorW;

	@Before
	public void SetUp() throws Exception {
		lawn = new Pelouse(5, 5);
	}
	
	@Test
	public void initializationMower_12N() throws Exception {
		// Position initiale
		Tondeuse mowerN = new Tondeuse(lawn, 1, 2, 'N',"");
		
		assertEquals(1, mowerN.getxPosition());
		assertEquals(2, mowerN.getyPosition());
		assertEquals('N', mowerN.getDirection());
	}
	
	
	@Test
	public void initializationMower_12ZAsParams_FailedExceptionThrown() {
		
		Throwable e = null;
		
		@SuppressWarnings("unused")
		Tondeuse mower;
		
		try {
			mower = new Tondeuse(null, 1, 2, 'Z',null);
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof TondeuseException);
		
	}
	
	@Test
	public void starTondeuse_12NAsMowerDescriptionAndMove1Forward_13NPositionExpected() {
		try {
			TondeuseN = new Tondeuse(new Pelouse(5, 5), 1, 2, 'N',"A");
			mowersConfiguratorN = new TestMowersConfigurator(TondeuseN);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		//Déplacement en avant
		mowersConfiguratorN.starTondeuse();
		assertEquals(1, TondeuseN.getxPosition());
		assertEquals(3, TondeuseN.getyPosition());
		assertEquals('N', TondeuseN.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12WAsMowerDescriptionAndMove1Forward_02WPositionExpected() {

		try {
			TondeuseW = new Tondeuse(new Pelouse(5, 5), 1, 2, 'W',"A");
			mowersConfiguratorW = new TestMowersConfigurator(TondeuseW);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		//Déplacement en avant
		mowersConfiguratorW.starTondeuse();
		assertEquals(0, TondeuseW.getxPosition());
		assertEquals(2, TondeuseW.getyPosition());
		assertEquals('W', TondeuseW.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12EAsTondeuseDescriptionAndMove1Forward_22EPositionExpected() {
		try {
			TondeuseE = new Tondeuse(new Pelouse(5, 5), 1, 2, 'E',"A");
			mowersConfiguratorE = new TestMowersConfigurator(TondeuseE);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorE.starTondeuse();
		assertEquals(2, TondeuseE.getxPosition());
		assertEquals(2, TondeuseE.getyPosition());
		assertEquals('E', TondeuseE.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12SAsTondeuseDescriptionAndMove1Forward_11SPositionExpected() {
		//Déplacement en avant
		try {
			TondeuseS = new Tondeuse(new Pelouse(5, 5), 1, 2, 'S',"A");
			mowersConfiguratorS = new TestMowersConfigurator(TondeuseS);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}

		mowersConfiguratorS.starTondeuse();
		assertEquals(1, TondeuseS.getxPosition());
		assertEquals(1, TondeuseS.getyPosition());
		assertEquals('S', TondeuseS.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12NAsTondeuseDescriptionAndTurnRight_12EPositionExpected() {
		//Virage à droite
		try {
			TondeuseN = new Tondeuse(new Pelouse(5, 5), 1, 2, 'N',"D");
			mowersConfiguratorN = new TestMowersConfigurator(TondeuseN);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorN.starTondeuse();
		assertEquals(1, TondeuseN.getxPosition());
		assertEquals(2, TondeuseN.getyPosition());
		assertEquals('E', TondeuseN.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12EAsTondeuseDescriptionAndTurnRight_12SPositionExpected() {
		//Virage à droite
		try {
			TondeuseE = new Tondeuse(new Pelouse(5, 5),  1, 2, 'E',"D");
			mowersConfiguratorE = new TestMowersConfigurator(TondeuseE);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorE.starTondeuse();
		assertEquals(1, TondeuseE.getxPosition());
		assertEquals(2, TondeuseE.getyPosition());
		assertEquals('S', TondeuseE.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12SAsTondeuseDescriptionAndTurnRight_12WPositionExpected() {
		//Virage à droite
		try {
			TondeuseS = new Tondeuse(new Pelouse(5, 5), 1, 2, 'S',"D");
			mowersConfiguratorS = new TestMowersConfigurator(TondeuseS);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorS.starTondeuse();
		assertEquals(1, TondeuseS.getxPosition());
		assertEquals(2, TondeuseS.getyPosition());
		assertEquals('W', TondeuseS.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12WAsTondeuseDescriptionAndTurnRight_12NPositionExpected() {
		//Virage à droite
		try {
			TondeuseW = new Tondeuse(new Pelouse(5, 5), 1, 2, 'W',"D");
			mowersConfiguratorW = new TestMowersConfigurator(TondeuseW);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorW.starTondeuse();
		assertEquals(1, TondeuseW.getxPosition());
		assertEquals(2, TondeuseW.getyPosition());
		assertEquals('N', TondeuseW.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12NAsTondeuseDescriptionAndTurnLeft_12WPositionExpected() {
		//Virage à gauche
		try {
			TondeuseN = new Tondeuse(new Pelouse(5, 5),  1, 2, 'N',"G");
			mowersConfiguratorN = new TestMowersConfigurator(TondeuseN);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorN.starTondeuse();
		
		assertEquals(1, TondeuseN.getxPosition());
		assertEquals(2, TondeuseN.getyPosition());
		assertEquals('W', TondeuseN.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12EAsTondeuseDescriptionAndTurnLeft_12NPositionExpected() {
		//Virage à gauche
		try {
			TondeuseE = new Tondeuse(new Pelouse(5, 5), 1, 2, 'E',"G");
			mowersConfiguratorE = new TestMowersConfigurator(TondeuseE);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorE.starTondeuse();
		assertEquals(1, TondeuseE.getxPosition());
		assertEquals(2, TondeuseE.getyPosition());
		assertEquals('N', TondeuseE.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12SAsTondeuseDescriptionAndTurnLeft_12EPositionExpected() {
		//Virage à gauche
		try {
			TondeuseS = new Tondeuse(new Pelouse(5, 5),  1, 2, 'S',"G");
			mowersConfiguratorS = new TestMowersConfigurator(TondeuseS);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorS.starTondeuse();
		assertEquals(1, TondeuseS.getxPosition());
		assertEquals(2, TondeuseS.getyPosition());
		assertEquals('E', TondeuseS.getDirection());
		
	}
	
	@Test
	public void starTondeuse_12WAsTondeuseDescriptionAndTurnLeft_12SPositionExpected() {
		//Virage à gauche
		try {
			TondeuseW = new Tondeuse(new Pelouse(5, 5), 1, 2, 'W',"G");
			mowersConfiguratorW = new TestMowersConfigurator(TondeuseW);
		} catch (TondeuseException e) {
			fail();
		}
		catch (FileException e) {
			fail();
		}
		
		mowersConfiguratorW.starTondeuse();
		assertEquals(1, TondeuseW.getxPosition());
		assertEquals(2, TondeuseW.getyPosition());
		assertEquals('S', TondeuseW.getDirection());
		
	}
	
	@Test
	public void initializationPelouse_55() {
		assertEquals(5, lawn.getLargeur());
		assertEquals(5, lawn.getLongueur());
		
	}

}
