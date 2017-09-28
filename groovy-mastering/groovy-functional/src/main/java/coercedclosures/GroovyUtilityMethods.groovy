package coercedclosures

class GroovyUtilityMethods implements UtilityMethods {
    @Override
    int[] getPositives(int ... values) {
        values.findAll { it > 0 }
    }

    @Override
    boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll(/\W/, '')
        str.reverse() == str
    }
}
