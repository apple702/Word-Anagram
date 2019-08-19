#!/bin/bash
clear
javac WordAnagram.java
groovyc -cp spock-core-1.1-groovy-2.4.jar WordAnagramTest.groovy
groovy -cp spock-core-1.1-groovy-2.4.jar WordAnagramTest