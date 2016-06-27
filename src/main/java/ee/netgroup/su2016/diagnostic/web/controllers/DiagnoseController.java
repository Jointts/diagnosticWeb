package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.PatientRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import ee.netgroup.su2016.diagnostic.web.services.DiagnoseService;
import ee.netgroup.su2016.diagnostic.web.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 25.06.2016.
 */

@Controller
public class DiagnoseController {

    @Autowired
    StatisticService statisticService;

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DiagnoseService diagnoseService;

    @RequestMapping(path = "diagnose")
    public String usualDiagnose(Model model){
        model.addAttribute("symptomList", statisticService.getSymptomList());
        return "diagnose";
    }

    @RequestMapping(path = "diagnose", method = RequestMethod.POST)
    public String usualDiagnosePost(@RequestParam(value="symptomList", required=false) List<Long> symptomList, Model model){
        model.addAttribute("diseaseList", diagnoseService.getDiagnose(symptomList));
        return "diagnose_result";
    }

    /* This part does not work very well :S */

    @RequestMapping(path = "diagnose-interactive")
    public String interactiveDiagnose(Model model){
        model.addAttribute("patientList", patientRepository.findAll());
        model.addAttribute("firstSymptom", symptomRepository.findAll().iterator().next());
        return "diagnose_interactive";
    }

    /*
    @RequestMapping(path = "diagnose-interactive", method = RequestMethod.POST)
    public String interactiveDiagnosePost(@RequestParam(value="test", required = false) List<Long> symptomList, Model model){
        List<Symptom> symptoms = new ArrayList<>();
        for(Long id: symptomList){
            symptoms.add(symptomRepository.findOne(id));
        }
        for(Disease disease: diseaseRepository.findAll()){
            if(disease.getSymptoms().containsAll(symptoms) && !(disease.getSymptoms().containsAll(symptoms) && symptoms.containsAll(disease.getSymptoms()))){
                disease.getSymptoms().removeAll(symptoms);
                model.addAttribute("suggestedSymptom", disease.getSymptoms().get(0));
            }else{
                model.addAttribute("diagnosedDisease", disease.getName());
                break;
            }
        }
        return "diagnose_interactive_result";
    }
    */


}
