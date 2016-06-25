package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.dto.SymptomDTO;
import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by pagulane on 23.06.2016.
 */

@Service
public class SymptomService {

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    public long countSymptoms(){
        return symptomRepository.count();
    }

    public List<Symptom> getThreePopularSymptoms(){
        return null;
    }

    public Object[] getThreeDiseasesWithMostSymptoms(){
        TreeSet<Disease> diseases = new TreeSet<>((a, b) -> {
            int s1 = a.getSymptoms().size();
            int s2 = b.getSymptoms().size();
            if(s1 == s2){
                return a.getName().compareTo(b.getName());
            }
            else return s1 < s2  ? 1 : -1;
        });
        for(Disease disease: diseaseRepository.findAll()){
            diseases.add(disease);
        }
        return Arrays.copyOfRange(diseases.toArray(), 0, 3);
    }
}
