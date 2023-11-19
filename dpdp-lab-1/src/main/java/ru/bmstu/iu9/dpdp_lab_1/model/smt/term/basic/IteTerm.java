package ru.bmstu.iu9.dpdp_lab_1.model.smt.term.basic;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.interfaces.Term;

@Setter
@AllArgsConstructor
public class IteTerm implements Term {
    private final String name = "ite";
    private Term condition;
    private Term one;
    private Term two;

    @Override
    public String toString() {
        return String.format("(%s %s %s %s)", name, condition, one, two);
    }
}
