package ee.netgroup.su2016.diagnostic.web.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pagulane on 21.06.2016.
 */

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter @Getter
    private String name;

    @ManyToMany
    @Setter @Getter
    private List<Symptom> symptoms;

}
