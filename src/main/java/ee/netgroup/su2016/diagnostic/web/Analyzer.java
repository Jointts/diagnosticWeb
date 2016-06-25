package ee.netgroup.su2016.diagnostic.web;

/**
 * Created by pagulane on 21.06.2016.
 */
import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import ee.netgroup.su2016.diagnostic.web.repositories.DiseaseRepository;
import ee.netgroup.su2016.diagnostic.web.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Service
public class Analyzer {

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    SymptomRepository symptomRepository;

    public String analyze(final MultipartFile multipartFile) throws IOException {

        InputStream inputStream = multipartFile.getInputStream();
        HashMap<String, Symptom> symptomMap = new HashMap<>();

        if (inputStream == null)
            return "";

        final StringBuffer result = new StringBuffer();

        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int linesCount = 0;

        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null)
                break;

            linesCount++;

            String[] seperatedInfo = line.split(", ");
            Disease disease = new Disease();
            String diseaseName = seperatedInfo[0];
            seperatedInfo = Arrays.copyOfRange(seperatedInfo, 1, seperatedInfo.length);
            List<Symptom> symptomList = new ArrayList<>();

            for(String item: seperatedInfo){
                if(symptomMap.get(item) != null){
                    symptomList.add(symptomMap.get(item));
                    continue;
                }
                Symptom symptom = new Symptom();
                symptom.setName(item);
                symptomRepository.save(symptom);
                symptomMap.put(symptom.getName(), symptom);
                symptomList.add(symptom);
            }

            disease.setName(diseaseName);
            disease.setSymptoms(symptomList);
            diseaseRepository.save(disease);
        }

        result.append("<br/>Input parsing result:");
        result.append("<br/>Detected " + linesCount + " line(s).");

        return result.toString();
    }

}
