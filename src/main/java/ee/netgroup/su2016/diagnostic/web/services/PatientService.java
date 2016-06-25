package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.models.Patient;
import ee.netgroup.su2016.diagnostic.web.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pagulane on 23.06.2016.
 */

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Iterable<Patient> getPatientList(){
        return patientRepository.findAll();
    }
}
