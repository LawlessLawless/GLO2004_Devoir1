package QualiteDevoir.domain;

import org.junit.Before;
import org.junit.Test;

import QualiteDevoir.domain.enums.TriageType;
import QualiteDevoir.domain.enums.VisibleSymptom;

import static org.junit.Assert.*; 

public class ClinicTest {
	
	private Clinic clinic;
	
	@Before
	public void Testnitialize() {
		clinic = new Clinic(TriageType.FIFO);
	}
	
	@Test
	public void atCreation_medecinWaitLineIsNotNull() {
		assertTrue(clinic.getDoctorWaitLine()!= null);
	}
	
	@Test
	public void atCreation_radiologyWaitLineIsNotNull() {
		assertTrue(clinic.getRadiologyWaitLine()!= null);
	}
	
	@Test
	public void when_sortPatient_then_doctorWaitLineContainIt() {
		 clinic.sortPatient("Bob", 2, VisibleSymptom.FLU);
		assertTrue(clinic.getDoctorWaitLine().get(0).getPatientName().equals("Bob"));
	}
	
	@Test
	public void when_sortPatientWithRadiology_then_radiologyWaitLineContainIt() {
		 clinic.sortPatient("Bob", 2, VisibleSymptom.BROKEN_BONE);
		assertTrue(clinic.getRadiologyWaitLine().get(0).getPatientName().equals("Bob"));
	}
	
	@Test
	public void when_receivedPatient_then_doctorWaitLineDoNotContainIt() {
		 clinic.sortPatient("Bob", 2, VisibleSymptom.FLU);
		 clinic.DoctorReceiveNextPatient();
		assertTrue(clinic.getDoctorWaitLine().size() == 0);
	}
	
	@Test
	public void when_receivedPatientWithRadiology_then_radiologyWaitLineDoNotContainIt() {
		 clinic.sortPatient("Bob", 2, VisibleSymptom.BROKEN_BONE);
		 clinic.RadiologyReceiveNextPatient();
		assertTrue(clinic.getRadiologyWaitLine().size() == 0);
	}
	
	
}