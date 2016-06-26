package ee.netgroup.su2016.diagnostic.web.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by pagulane on 21.06.2016.
 */

@Entity
public class Symptom implements Comparable<Symptom>{

    @Id
    @Setter @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Setter @Getter
    private String name;

    @Override
    public int compareTo(Symptom symptom) {
        return this.name.compareTo(symptom.getName());
    }
}
