import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

import java.util.logging.Logger

@Aspect
class UpdateReporter {
    Logger log = Logger.getLogger(UpdateReporter.class.name)

    @Before("execution(void set*(*))")
    void reportOnSet(JoinPoint jp) {
        String method = jp.signature.name
        String property = (method - 'set')[0].toLowerCase() +
                (method - 'set')[1..-1]
        def current = jp.target."$property"
        log.info "About to change $property from $current to ${jp.args[0]}"
    }
}