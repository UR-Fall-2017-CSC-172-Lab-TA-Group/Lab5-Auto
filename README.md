# Lab5-Auto
Test cases to grade Lab 5 Automatically

This lab focuses on implementation of ArrayLists, LinkedLists and their Iterators

## GradTAExmaple Folder
Example from Grad TA

## JUnitTest Folder
Attempt to use JUnitTest for auto grading

Dependencies: [JUnit4](https://mvnrepository.com/artifact/junit/junit/4.12), [Java hamcrest 2.0.0.0](https://mvnrepository.com/artifact/org.hamcrest/java-hamcrest/2.0.0.0)

To use autograding, place the student's submission of `URArrayList.java` and `URLinkedList.java` in this folder, then run `autograde.sh` for UNIX systems

### UNIX:
run autograde.sh

*Note:* If your terminal says permission denied, try changing the permission then run again:
```bash
> chmod 777 autograde.sh
```

## ImplementationToTest Folder
The folder contains an implementation from a student last semester. Feel free to add more test cases, but make sure different cases stays in different folders
