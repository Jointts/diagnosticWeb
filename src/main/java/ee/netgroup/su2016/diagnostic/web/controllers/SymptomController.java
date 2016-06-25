package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pagulane on 23.06.2016.
 */

@Controller
public class SymptomController {

    @Autowired
    SymptomService symptomService;

    @RequestMapping(path = "symptoms/count")
    public String getSymptomCount(Model model){
        model.addAttribute("symptomCount", symptomService.countSymptoms());
        return "symptoms/list";
    }

    @RequestMapping(path = "symptoms/popular")
    public String getThreeTopSymptoms(){
        return null;
    }
}
