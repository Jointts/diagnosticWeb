package ee.netgroup.su2016.diagnostic.web.dto;

import ee.netgroup.su2016.diagnostic.web.models.Disease;
import ee.netgroup.su2016.diagnostic.web.models.Symptom;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by pagulane on 25.06.2016.
 */

public class SymptomDTO extends Symptom {

    @Setter @Getter
    private int amount;
}
