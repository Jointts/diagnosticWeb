package ee.netgroup.su2016.diagnostic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pagulane on 25.06.2016.
 */

@Controller
public class DiagnoseController {

    @RequestMapping(path = "")
    public String usualDiagnose(){
        return "";
    }
}
