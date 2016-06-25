package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pagulane on 25.06.2016.
 */

@Controller
public class StatisticController {

    @Autowired
    SymptomService symptomService;

    @RequestMapping(path = "statistics")
    public String getStatistics(Model model){
        model.addAttribute("symptomCount", symptomService.countSymptoms());
        model.addAttribute("mostSymptoms", symptomService.getThreeDiseasesWithMostSymptoms());
        symptomService.getThreePopularSymptoms();
        return "statistics";
    }
}
