#!/bin/bash
clear
javac Main.java
if [ "$1" != "" ]; then
    java Main $1
else
    java Main 
fi

