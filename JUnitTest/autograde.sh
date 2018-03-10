javac -cp .:junit-4.12.jar URArrayListTest.java URLinkedListTest.java
java -cp .:junit-4.12.jar:java-hamcrest-2.0.0.0.jar org.junit.runner.JUnitCore URArrayListTest > arraylist.txt
echo "ArrayList test result saved to arraylist.txt"
java -cp .:junit-4.12.jar:java-hamcrest-2.0.0.0.jar org.junit.runner.JUnitCore URLinkedListTest > linkedlist.txt
echo "ArrayList test result saved to linkedlist.txt"
rm *.class
