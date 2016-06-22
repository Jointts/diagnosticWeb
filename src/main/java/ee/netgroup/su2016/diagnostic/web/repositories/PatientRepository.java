package ee.netgroup.su2016.diagnostic.web.repositories;

import ee.netgroup.su2016.diagnostic.web.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by pagulane on 21.06.2016.
 */

@RepositoryRestResource(collectionResourceRel = "patient", path = "api/patient")
public interface PatientRepository extends CrudRepository<Patient, Long>{

}
