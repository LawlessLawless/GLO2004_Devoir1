package QualiteDevoir.domain;

import org.junit.Before;
import org.junit.Test;

import QualiteDevoir.domain.enums.VisibleSymptom;

import static org.junit.Assert.*; 

public class FIFOSorterTest {
	
	private FIFOSorter sorter;
	
	@Before
	public void Testnitialize() {
		sorter = new FIFOSorter();
	}
	
	@Test
	public void when_getDoctorWaitLine_then_medecinWaitLineIsNotNull() {
		assertTrue(sorter.getDoctorWaitLine()!= null);
	}
	
	@Test
	public void when_getRadiologyWaitLine_then_medecinWaitLineIsNotNull() {
		assertTrue(sorter.getRadiologyWaitLine() != null);
	}
	
	
	@Test
	public void when_removePatientFromDoctorWaitLine_then_patientIsRemoved() {
		Patient bob = geteBob(VisibleSymptom.FLU, 1); 
		sorter.Sort(bob);
		sorter.removeMostPriorityPatientFromMedecin();
		assertTrue(sorter.getDoctorWaitLine().size() == 0);
	}
	
	@Test
	public void when_removePatientFromRadiologyWaitLine_then_patientIsRemoved() {
		Patient bob =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob);
		sorter.removeMostPriorityPatientFromMedecin();
		assertTrue(sorter.getDoctorWaitLine().size() == 0);
	}
	
	@Test
	public void when_sortPatientNeedingRadiology_then_patientIsAddedRadiologyWaitLine() {
		Patient bob =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob);
		assertTrue(sorter.getRadiologyWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithBrokenBone_then_patientIsAddedRadiologyWaitLine() {
		Patient bob =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob);
		assertTrue(sorter.getRadiologyWaitLine().contains(bob));
	}

	@Test
	public void when_sortPatientWithSprain_then_patientIsAddedRadiologyWaitLine() {
		Patient bob =  geteBob(VisibleSymptom.SPRAIN, 3); 
		sorter.Sort(bob);
		assertTrue(sorter.getRadiologyWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithFlu_then_patientIsNotInRadiologyWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.FLU, 3); 
		sorter.Sort(bob1);
		assertFalse(sorter.getRadiologyWaitLine().contains(bob1));
	}
	
	@Test
	public void when_sortPatientWithCold_then_patientIsNotInRadiologyWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.COLD, 3); 
		sorter.Sort(bob1);
		assertFalse(sorter.getRadiologyWaitLine().contains(bob1));
	}
	
	@Test
	public void when_sortPatientWithEbola_then_patientIsNotInRadiologyWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.EBOLA, 8); 
		sorter.Sort(bob1);
		assertFalse(sorter.getRadiologyWaitLine().contains(bob1));
	}

	@Test
	public void when_sortPatientWithChestPain_then_patientIsNotInRadiologyWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.CHEST_PAIN, 3); 
		sorter.Sort(bob1);
		assertFalse(sorter.getRadiologyWaitLine().contains(bob1));
	}
	
	@Test
	public void when_sortPatientWithMigraine_then_patientIsNotInRadiologyWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.MIGRAINE, 1); 
		sorter.Sort(bob1);
		assertFalse(sorter.getRadiologyWaitLine().contains(bob1));
	}
	
	@Test
	public void when_sortPatientWithBrokenBone_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.BROKEN_BONE, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithChestPain_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.CHEST_PAIN, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithCold_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.COLD, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithEbola_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.EBOLA, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithFlu_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.FLU, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithMigraine_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.MIGRAINE, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithSprain_then_patientIsAddedMedecinWaitLine() {
		Patient bob = geteBob(VisibleSymptom.SPRAIN, 2); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().contains(bob));
	}
	
	@Test
	public void when_sortPatientWithSprainAndLowPriority_then_patientIsFirstPriorityRadiology() {
		Patient bob1 =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob1);
		Patient bob2 =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob2);
		Patient bob3 =  geteBob(VisibleSymptom.SPRAIN, 4); 
		sorter.Sort(bob3);
		assertTrue(sorter.getRadiologyWaitLine().get(0).equals(bob3));
	}
	
	@Test
	public void when_sortPatientWithMigraine_then_patientIsAddedMedecinWaitLineAtFirst() {
		Patient bob1 =  geteBob(VisibleSymptom.CHEST_PAIN, 2); 
		sorter.Sort(bob1);
		Patient bob2 =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob2);
		Patient bob = geteBob(VisibleSymptom.MIGRAINE, 6); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().get(0).equals(bob));
	}
	
	@Test
	public void given_PatientWithMigraine_when_sortInMedecinFileContainingAFirstPriority_then_patientIsAddedMedecinWaitLineAtSecond() {
		Patient bob1 =  geteBob(VisibleSymptom.CHEST_PAIN, 1); 
		sorter.Sort(bob1);
		Patient bob2 =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob2);
		Patient bob = geteBob(VisibleSymptom.MIGRAINE, 6); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().get(1).equals(bob));		
	}

	@Test
	public void when_sortPatientWithSprain_then_heIsFirstInAllWaitLine() {
		Patient bob1 =  geteBob(VisibleSymptom.CHEST_PAIN, 2); 
		sorter.Sort(bob1);
		Patient bob2 =  geteBob(VisibleSymptom.BROKEN_BONE, 3); 
		sorter.Sort(bob2);
		Patient bob = geteBob(VisibleSymptom.SPRAIN, 6); 
		sorter.Sort(bob);
		assertTrue(sorter.getDoctorWaitLine().get(0).equals(bob));
		assertTrue(sorter.getRadiologyWaitLine().get(0).equals(bob));
	}
	
	private Patient geteBob(VisibleSymptom symptom, int priority) {
		return new Patient("Bob", priority, symptom);
	}
}

