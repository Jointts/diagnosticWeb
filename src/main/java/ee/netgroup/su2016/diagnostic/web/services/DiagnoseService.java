package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 27.06.2016.
 */

@Service
public class DiagnoseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    SymptomRepository symptomRepository;

    public List<Disease> getDiagnose(List<Long> symptomList){
        if(symptomList != null){
            List<Symptom> symptoms = new ArrayList<>();
            List<Disease> diseaseList = new ArrayList<>();
            for(Long id: symptomList){
                symptoms.add(symptomRepository.findOne(id));
            }
            for(Disease disease: diseaseRepository.findAll()){
                if(disease.getSymptoms().containsAll(symptoms)){
                    diseaseList.add(disease);
                }
            }
            return diseaseList;
        }
        return null;
    }
}
