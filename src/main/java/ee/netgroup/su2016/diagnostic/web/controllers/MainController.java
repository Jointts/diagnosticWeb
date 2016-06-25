package ee.netgroup.su2016.diagnostic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pagulane on 24.06.2016.
 */

@Controller
public class MainController {

    @RequestMapping(path = "/")
    public String getIndex(Model model){
        return "index";
    }
}
