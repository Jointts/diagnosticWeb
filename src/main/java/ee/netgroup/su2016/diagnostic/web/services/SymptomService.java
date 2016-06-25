package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        HashMap<String, Integer> symptomMap = new HashMap<>();
        for(Disease disease: diseaseRepository.findAll()){
            String diseaseName = disease.getName();
            if(symptomMap.containsKey(diseaseName)){
                symptomMap.put(diseaseName, symptomMap.get(diseaseName) + 1);
                continue;
            }
            symptomMap.put(disease.getName(), 1);
        }
        return null;
    }

    public List<Symptom> getThreeDiseasesWithMostSymptoms(){
        List<Integer> valueList = new ArrayList<>();
        List<Disease> diseaseList = new ArrayList<>();
        HashMap<String, Integer> symptomMap = new HashMap<>();
        for(Disease disease: diseaseRepository.findAll()){
            disease.getSymptoms().size();
        }
        return null;
    }
}
