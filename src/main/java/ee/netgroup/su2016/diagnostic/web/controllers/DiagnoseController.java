package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.PatientRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import ee.netgroup.su2016.diagnostic.web.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 25.06.2016.
 */

@Controller
public class DiagnoseController {

    @Autowired
    SymptomService symptomService;

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(path = "diagnose")
    public String usualDiagnose(Model model){
        model.addAttribute("symptomList", symptomService.getSymptomList());
        return "diagnose";
    }

    @RequestMapping(path = "diagnose", method = RequestMethod.POST)
    public String usualDiagnosePost(@RequestParam(value="symptomList", required=false) List<Long> symptomList, Model model){
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
            model.addAttribute("diseaseList", diseaseList);
        }
        return "diagnose_result";
    }

    @RequestMapping(path = "diagnose-interactive")
    public String interactiveDiagnose(Model model){
        model.addAttribute("patientList", patientRepository.findAll());
        return "diagnose_interactive";
    }
}
