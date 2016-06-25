package ee.netgroup.su2016.diagnostic.web.repositories;


import ee.netgroup.su2016.diagnostic.web.models.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by pagulane on 21.06.2016.
 */

public interface DiseaseRepository extends CrudRepository<Disease, Long> {

}
