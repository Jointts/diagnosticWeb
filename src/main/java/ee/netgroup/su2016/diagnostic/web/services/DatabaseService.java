package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.Analyzer;
import ee.netgroup.su2016.diagnostic.web.models.Patient;
import ee.netgroup.su2016.diagnostic.web.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by pagulane on 21.06.2016.
 */

@Service
public class DatabaseService {

    @Autowired
    Analyzer analyzer;

    @Autowired
    PatientRepository patientRepository;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/diagnostic";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";

    public void populateDatabase(MultipartFile multipartFile){
        try{
            analyzer.analyze(multipartFile);
        }catch (IOException e){
            System.out.println("IO Fault, creating an InputStreamReader failed.");
        }
    }

    public void prepareDatabase(){
        Connection conn;
        Statement stmt;
        String sql_truncate_all_tables =
                "TRUNCATE DISEASE_SYMPTOMS, DISEASE, PATIENT, PATIENT_SYMPTOMS, SYMPTOM";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql_truncate_all_tables);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Patient patient1 = new Patient();
        patient1.setFirst_name("Mari");
        patient1.setLast_name("Maasikas");

        Patient patient2 = new Patient();
        patient2.setFirst_name("Jüri");
        patient2.setLast_name("Jürgenson");

        patientRepository.save(patient1);
        patientRepository.save(patient2);

    }

}
