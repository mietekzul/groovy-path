import groovy.transform.CompileStatic
import pl.raziel.Evaluator
import pl.raziel.MortgageApplication

@CompileStatic
class GroovyEvaluator implements Evaluator {
    boolean approve(MortgageApplication application) {
        false
    }
}