package QualiteDevoir.api;

import java.util.ArrayList;

import QualiteDevoir.domain.Clinic;
import QualiteDevoir.domain.Patient;
import QualiteDevoir.domain.enums.TriageType;
import QualiteDevoir.domain.enums.VisibleSymptom;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Build works!" );
        
        Clinic fifoClinic = new Clinic(TriageType.FIFO);
        
        fifoClinic.sortPatient("Bob", 2, VisibleSymptom.FLU);
        fifoClinic.sortPatient("Jose", 2, VisibleSymptom.CHEST_PAIN);
        fifoClinic.sortPatient("VincentFirst", 2, VisibleSymptom.BROKEN_BONE);
        fifoClinic.sortPatient("VincentSecond", 2, VisibleSymptom.SPRAIN);
        fifoClinic.sortPatient("VincentThird", 2, VisibleSymptom.SPRAIN);
        fifoClinic.sortPatient("Karl", 2, VisibleSymptom.FLU);
        
        System.out.println("Doctor wait line : ");
        ArrayList<Patient> patients = fifoClinic.getDoctorWaitLine();
        for (Patient patient : patients) {      	
        	System.out.println( patient.getPatientName() + " index : " + patients.indexOf(patient) );      	
		}       
        System.out.println("----------------------------------------");
        System.out.println("Radiology wait line : ");
        ArrayList<Patient> radiologyWaitLine = fifoClinic.getRadiologyWaitLine();
        for (Patient patient : radiologyWaitLine) {       	
        	System.out.println( patient.getPatientName() + " index : " + radiologyWaitLine.indexOf(patient) );
		}
    }
}
