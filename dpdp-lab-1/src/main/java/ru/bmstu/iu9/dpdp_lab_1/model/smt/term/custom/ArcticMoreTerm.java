package ru.bmstu.iu9.dpdp_lab_1.model.smt.term.custom;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.part.DefineFun;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.basic.*;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.interfaces.CustomTerm;
import ru.bmstu.iu9.dpdp_lab_1.model.smt.term.interfaces.Term;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArcticMoreTerm implements CustomTerm {
    private final String name = "arcticMore";
    private Term one;
    private Term two;

    @Override
    public String toString() {
        return String.format("(%s %s %s)", name, one, two);
    }

    @Override
    public String getDefineFun() {
        return new DefineFun(
                name, "((a Int) (b Int))", "Bool",
                new IteTerm(
                        new OrTerm(
                                new GreaterTerm(
                                        new ValueTerm("a"),
                                        new ValueTerm("b")),
                                new AndTerm(
                                        new LessEqualTerm(
                                                new ValueTerm("a"),
                                                new ValueTerm("-1")),
                                        new LessEqualTerm(
                                                new ValueTerm("b"),
                                                new ValueTerm("-1")))),
                        new ValueTerm("true"),
                        new ValueTerm("false"))
        ).toString();
    }
}