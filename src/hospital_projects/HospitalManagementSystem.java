package hospital_projects;



import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private int age;
    private String gender;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private String treatment;

    public MedicalRecord(Patient patient, String diagnosis, String treatment) {
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
}

class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<MedicalRecord> medicalRecords;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        medicalRecords = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public List<Appointment> getAppointments(String date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                result.add(appointment);
            }
        }
        return result;
    }


}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Example usage
        Patient patient1 = new Patient("John", 30, "Male");
        hospital.addPatient(patient1);

        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiologist");
        hospital.addDoctor(doctor1);

        Appointment appointment1 = new Appointment(patient1, doctor1, "2024-02-21", "10:00 AM");
        hospital.scheduleAppointment(appointment1);

        MedicalRecord medicalRecord1 = new MedicalRecord(patient1, "Heart Disease", "Prescribed medication X");
        hospital.addMedicalRecord(medicalRecord1);

        List<Appointment> todaysAppointments = hospital.getAppointments("2024-02-21");
        for (Appointment appointment : todaysAppointments) {
            System.out.println(appointment.getPatient().getName() + " has an appointment with " + appointment.getDoctor().getName());
        }

    }
}



