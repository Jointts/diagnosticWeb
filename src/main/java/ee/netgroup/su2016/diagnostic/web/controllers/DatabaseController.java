package ee.netgroup.su2016.diagnostic.web.controllers;

import ee.netgroup.su2016.diagnostic.web.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pagulane on 21.06.2016.
 */

@Controller
public class DatabaseController {

    @Autowired
    DatabaseService databaseService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadDatabase(@RequestParam("file") MultipartFile file){
        databaseService.prepareDatabase();
        databaseService.populateDatabase(file);
        return "database/upload";
    }
}
