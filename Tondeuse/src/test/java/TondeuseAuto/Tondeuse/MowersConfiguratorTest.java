package TondeuseAuto.Tondeuse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import TondeuseAuto.Tondeuse.exceptions.FileException;
import TondeuseAuto.Tondeuse.model.Pelouse;
import TondeuseAuto.Tondeuse.model.Tondeuse;
import TondeuseAuto.Tondeuse.service.TondeuseConfiguratorByFile;
import TondeuseAuto.Tondeuse.service.Tondeuseservices;

;

/**
 * Test de la classe chargeant les informations de configuration des tondeuses
 */
public class MowersConfiguratorTest 
{
	
	Pelouse lawn;
	TondeuseConfiguratorByFile mowersConfigurator;
	Tondeuseservices tdservice;
	
	/**
	 * Null en argument du nom du fichier
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnNullValueOnParameter() {
		
		Throwable e = null;
		
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile((String)null);
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);

		assertEquals("NO_FILE", ((FileException) e).getMessageCourt());
		assertEquals("Fichier non trouvé.", ((FileException) e).getMessageLong());
	}
	
	/**
	 * Fichier inexistant en argument
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissingFileOnParameter() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("fichierInexistant");
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("NO_FILE", ((FileException) e).getMessageCourt());
		assertEquals("Fichier non trouvé.", ((FileException) e).getMessageLong());
		
	}
	
	/**
	 * Fichier vide en argument
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnEmptyFileOnParameter() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/fichierVide.txt");
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("EMPTY_FILE", ((FileException) e).getMessageCourt());
		assertEquals("Fichier vide.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnInvalideLawnSizeInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/pelouseStringDimensions.txt");
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("LAWN_SIZE_ERROR", ((FileException) e).getMessageCourt());
		assertEquals("Taille de la pelouse non valide.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissingOneLawnDimensionInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/pelouseUneSeuleDimensionFournie.txt");
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("LAWN_SIZE_ERROR", ((FileException) e).getMessageCourt());
		assertEquals("Erreur dans la description de la taille pelouse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissingMowerInformationInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/pasInfoTondeuse.txt");
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("NO_MOWER_ERROR", ((FileException) e).getMessageCourt());
		assertEquals("Pas d'information de tondeuse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissing1stMowerDirectionInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/manqueInfoDirectionPremiereTondeuse.txt");
			
		} catch (Throwable ex) {
			e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("ERROR_MOWER_DESCRIPTION", ((FileException) e).getMessageCourt());
		assertEquals("Erreur dans la description d'une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissing1stMowerInstructionsInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/manqueInstructionPremiereTondeuse.txt");
			
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("ERROR_NO_MOWER_INSTRUCTION", ((FileException) e).getMessageCourt());
		assertEquals("Pas d'instruction pour une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissing2ndMowerDirectionInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/manqueInfoDirectionDeuxiemeTondeuse.txt");
			
		} catch (Throwable ex) {
			e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("ERROR_MOWER_DESCRIPTION", ((FileException) e).getMessageCourt());
		assertEquals("Erreur dans la description d'une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissing2ndMowerInstructionsInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/manqueInstructionDeuxiemeTondeuse.txt");
			
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("ERROR_NO_MOWER_INSTRUCTION", ((FileException) e).getMessageCourt());
		assertEquals("Pas d'instruction pour une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	/**
	 * Test fournis des chaînes de caractères comme position de la tondeuse
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnMissing1stMowerPositionInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/positionTondeuseString.txt");
			
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("ERROR_MOWER_DESCRIPTION", ((FileException) e).getMessageCourt());
		assertEquals("Erreur dans la description d'une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnWrong1stMowerDirectionInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/directionTondeuseZ.txt");
			
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("MOWER_DIRECTION_ERROR", ((FileException) e).getMessageCourt());
		assertEquals("Direction d'une tondeuse invalide.", ((FileException) e).getMessageLong());
	}
	
	/**
	 * Instructions non valides pour la tondeuse
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_FileExceptionThrownOnWrong1stMowerInstructionsInFile() {
		
		Throwable e = null;
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/instructionsTondeuseZ.txt");
			
		} catch (Throwable ex) {
		  e = ex;
		}
		
		assertTrue(e instanceof FileException);
		
		assertEquals("MOWER_INSTRUCTIONS_ERROR", ((FileException) e).getMessageCourt());
		assertEquals("Erreur dans les instructions d'une tondeuse.", ((FileException) e).getMessageLong());
	}
	
	
	/**
	 * Pelouse 3x4
	 * Une tondeuse valide de position : 1 2 N et instructions : ADDG
	 */
	@Test
	public void constructorTondeuseConfiguratorByFile_validMowerDescriptionInFile() {
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/descriptionValideTondeuse_sansBordure.txt");
			
		} catch (Throwable ex) {
			// ne rentre pas ici
			fail();
		}
		
		Tondeuse mower = mowersConfigurator.tondeusesuivante();
		
		Pelouse lawn = mower.getPelouse();
		assertEquals(3, lawn.getLongueur());
		assertEquals(4, lawn.getLargeur());
		
		assertEquals(1, mower.getxPosition());
		assertEquals(2, mower.getyPosition());
		assertEquals('N', mower.getDirection());
		assertEquals("ADDG", mower.getInstructions());
		
		assertTrue(mowersConfigurator.hasNexttondeuse());
		
	}
	
	/**
	 * Pelouse 3x4
	 * Une tondeuse valide de position : 1 2 N et instructions : ADDG
	 */
	@Test
	public void executeInstructions_validMowerDescriptionInFileNeverHitsBorders_finalPositionOK() {
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/descriptionValideTondeuse_sansBordure.txt");
			
		} catch (Throwable ex) {
			// ne rentre pas ici
			fail();
		}
		
		Tondeuse mower = mowersConfigurator.tondeusesuivante();
		
		Pelouse lawn = mower.getPelouse();
		assertEquals(3, lawn.getLongueur());
		assertEquals(4, lawn.getLargeur());
		
		assertEquals(1, mower.getxPosition());
		assertEquals(2, mower.getyPosition());
		assertEquals('N', mower.getDirection());
		assertEquals("ADDG", mower.getInstructions());
		
		assertTrue(tdservice.executeInstructions(mower));
		assertEquals(1, mower.getxPosition());
		assertEquals(3, mower.getyPosition());
		assertEquals('E', mower.getDirection());
		
		assertTrue(mowersConfigurator.hasNexttondeuse());
		
	}
	
	/**
	 * Pelouse 3x4
	 * Une tondeuse valide de position : 1 1 N et instructions : GAAGAADADA
	 * En testant l'arrêt de la tondeuse aux bordures de la pelouse
	 */
	@Test
	public void executeInstructions_validMowerDescriptionInFileWithTestBorders_finalPositionOK() {
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/descriptionValideTondeuse_avecBordure.txt");
			
		} catch (Throwable ex) {
			// ne rentre pas ici
			fail();
		}
		
		Tondeuse mower = mowersConfigurator.tondeusesuivante();
		
		Pelouse lawn = mower.getPelouse();
		assertEquals(3, lawn.getLongueur());
		assertEquals(4, lawn.getLargeur());
		
		assertEquals(1, mower.getxPosition());
		assertEquals(1, mower.getyPosition());
		assertEquals('N', mower.getDirection());
		assertEquals("GAAGAADADAAAADAAAAADAAAA", mower.getInstructions());
		
		assertTrue(tdservice.executeInstructions(mower));
		assertEquals(4, mower.getxPosition());
		assertEquals(0, mower.getyPosition());
		assertEquals('S', mower.getDirection());
		
		assertTrue(mowersConfigurator.hasNexttondeuse());
	}
	
	/**
	 * Pelouse 3x4
	 * tondeuse1 : 1 1 N et instructions : GAAGAADADA
	 * tondeuse2 : 1 2 N et instructions : ADDG
	 */
	@Test
	public void executeInstructions_validTwoMowersDescriptionsInFileWithTestBorders_finalPositionOK() {
		
		try {
			mowersConfigurator = new TondeuseConfiguratorByFile("ressources/test/descriptionValideDeuxTondeuses_avecBordure.txt");
			
		} catch (Throwable ex) {
			// ne rentre pas ici
			fail();
		}
		
		Tondeuse mower1 = mowersConfigurator.tondeusesuivante();
		
		Pelouse lawn = mower1.getPelouse();
		assertEquals(3, lawn.getLongueur());
		assertEquals(4, lawn.getLargeur());
		
		assertEquals(1, mower1.getxPosition());
		assertEquals(2, mower1.getyPosition());
		assertEquals('N', mower1.getDirection());
		assertEquals("ADDG", mower1.getInstructions());
		
		assertTrue(tdservice.executeInstructions(mower1));
		assertEquals(1, mower1.getxPosition());
		assertEquals(3, mower1.getyPosition());
		assertEquals('E', mower1.getDirection());
		
		assertFalse(mowersConfigurator.hasNexttondeuse());
		Tondeuse mower2 = mowersConfigurator.tondeusesuivante();
		
		assertEquals(1, mower2.getxPosition());
		assertEquals(1, mower2.getyPosition());
		assertEquals('N', mower2.getDirection());
		assertEquals("GAAGAADADA", mower2.getInstructions());
		
		assertTrue(tdservice.executeInstructions(mower2));
		assertEquals(0, mower2.getxPosition());
		assertEquals(1, mower2.getyPosition());
		assertEquals('N', mower2.getDirection());
		
		assertTrue(mowersConfigurator.hasNexttondeuse());
		
	}
	
}
