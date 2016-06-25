package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 21.06.2016.
 */

@Controller
public class DiseaseController {

    @Autowired
    SymptomRepository symptomRepository;

    @RequestMapping(value = "/symptoms/", method = RequestMethod.GET)
    public String getDiseaseList(Model model){
        model.addAttribute("symptoms", symptomRepository.findAll());
        return "symptoms/list";
    }
}
