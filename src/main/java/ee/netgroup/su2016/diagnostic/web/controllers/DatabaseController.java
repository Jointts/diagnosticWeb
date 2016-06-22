package ee.netgroup.su2016.diagnostic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pagulane on 21.06.2016.
 */

@Controller
public class DatabaseController {

    /* If you return null wierd things are gonna happen, atleast return one existing template */

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String uploadDatabaseForm(){
        return "database/upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadDatabase(){
        System.out.println("This has been posted!");
        return "database/upload";
    }
}
