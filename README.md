# Lab5-Auto
Test cases to grade Lab 5 Automatically

## GradTAExmaple Folder
Example from Grad TA

## JUnitTest Folder
Attempt to use JUnitTest for auto grading

Dependencies: [JUnit4](https://mvnrepository.com/artifact/junit/junit/4.12), [Java hamcrest 2.0.0.0](https://mvnrepository.com/artifact/org.hamcrest/java-hamcrest/2.0.0.0)

To use autograding, place the \*Test.java files and full student submission in the same folder along with [JUnit4](https://mvnrepository.com/artifact/junit/junit/4.12), [Java hamcrest 2.0.0.0](https://mvnrepository.com/artifact/org.hamcrest/java-hamcrest/2.0.0.0) jar files.

#### UNIX:
run autograde.sh

*Note:* If your terminal says permission denied, try:
```bash
> chmod 777 autograde.sh
```

## ImplementationToTest Folder
The folder contains an implementation from a student last semester. Feel free to add more test cases, but make sure different cases stays in difference folders
