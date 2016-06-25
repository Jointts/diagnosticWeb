package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.models.Patient;
import ee.netgroup.su2016.diagnostic.web.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pagulane on 23.06.2016.
 */

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    public String getDiagnose(){

        return null;
    }

    @RequestMapping(path = "patient/list")
    public String getPatientList(Model model){
        model.addAttribute("patientList", patientService.getPatientList());
        return "patient/list";
    }
}
