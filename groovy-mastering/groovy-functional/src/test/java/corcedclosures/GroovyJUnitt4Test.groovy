package corcedclosures

import coercedclosures.GroovyUtilityMethods
import coercedclosures.UtilityMethods
import org.junit.Test

class GroovyJUnitt4Test {
    UtilityMethods impl = new GroovyUtilityMethods()

    @Test
    void testGetPositives() {
        def results = impl.getPositives(-3..3 as int[])
        // results = impl.getPositives(-3, -2, -1, 0, 1, 2, 3)
        assert results.size() == 3
        assert results.every { it > 0 }
    }

    @Test
    void testIsPalindrome() {
        assert impl.isPalindrome('No cab, no tuna nut on bacon')
        assert impl.isPalindrome('Do geese see God?')
        assert impl.isPalindrome("Go hang a salami; I'm a lasagna hog!")
        assert !impl.isPalindrome('This is not a palindrome')
    }
}
