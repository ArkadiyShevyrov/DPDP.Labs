package ru.bmstu.iu9.dpdp_lab_1.model.smt.term.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.interfaces.Term;

@Getter
@Setter
@AllArgsConstructor
public class ValueTerm implements Term {
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
