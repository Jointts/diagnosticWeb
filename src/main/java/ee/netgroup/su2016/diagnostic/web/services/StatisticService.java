package ee.netgroup.su2016.diagnostic.web.services;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Patient;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pagulane on 23.06.2016.
 */

@Service
public class StatisticService {

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    public long countSymptoms(){
        return symptomRepository.count();
    }

    public Object[] getThreePopularSymptoms(){
        TreeMap<Symptom, Integer> symptomMap = new TreeMap<>();
        for(Disease disease: diseaseRepository.findAll()){
            for(Symptom symptom: disease.getSymptoms()){
                if(symptomMap.containsKey(symptom)){
                    symptomMap.put(symptom, symptomMap.get(symptom) + 1);
                }else{
                    symptomMap.put(symptom, 1);
                }
            }
        }
        return symptomMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).map(Map.Entry::getKey).toArray();
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

    public Iterable<Symptom> getSymptomList(){
        return symptomRepository.findAll();
    }
}
