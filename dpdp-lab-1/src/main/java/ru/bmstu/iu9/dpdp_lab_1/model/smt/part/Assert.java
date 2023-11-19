package ru.bmstu.iu9.dpdp_lab_1.model.smt.part;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.interfaces.Term;

@Getter
@AllArgsConstructor
public class Assert {
    private Term term;

    @Override
    public String toString() {
        return "(assert " + term + ")";
    }
}
