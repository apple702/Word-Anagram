import spock.lang.Specification

class WordAnagramTest extends Specification {

    def static final FILEPATH = '/usr/share/dict/words'
    def static final INPUT = 'Dog'

    WordAnagram wordAnagram


    def setup() {}

    def 'test item is same with created one'() {
        when:
        wordAnagram = new WordAnagram(FILEPATH)
        then:
        FILEPATH == wordAnagram.filepath
    }

    def 'test init'() {
        given:
        wordAnagram = new WordAnagram(FILEPATH)
        when:
        wordAnagram.init(INPUT)
        then:
        wordAnagram.count.length == 128
        wordAnagram.count[68] == 1
        wordAnagram.count[111] == 1
        wordAnagram.count[103] == 1
        wordAnagram.copy.length == 128
    }

    def 'test is Anagram'() {
        given:
        wordAnagram = new WordAnagram(FILEPATH)
        wordAnagram.init(INPUT)
        expect:
        wordAnagram.isAnagram(word) == value

        where:
        word    | value
        'og'    | false
        'ogD'   | true
        'God'   | false
        'gggod' | false
        'abc'   | false
        'ggD'   | false
    }

}
