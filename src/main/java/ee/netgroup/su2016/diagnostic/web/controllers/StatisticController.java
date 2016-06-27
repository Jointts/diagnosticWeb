package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.services.StatisticService;
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
    StatisticService statisticService;

    @RequestMapping(path = "statistics")
    public String getStatistics(Model model){
        model.addAttribute("symptomCount", statisticService.countSymptoms());
        model.addAttribute("mostSymptoms", statisticService.getThreeDiseasesWithMostSymptoms());
        model.addAttribute("popularSymptoms", statisticService.getThreePopularSymptoms());
        return "statistics";
    }
}
