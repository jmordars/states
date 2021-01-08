# states
States Project

This project uses maven to build.  Maven is a java tool, so you'll need java as well.

Get Java here:
https://www.oracle.com/technetwork/java/javase/downloads/index.html

Get Maven here:
https://maven.apache.org/download.html

Maven installation instructions:
https://maven.apache.org/install.html

To build an executable run:
mvn package

After the package is built, run this command to run the app:
java -cp target/states-1.0-SNAPSHOT.jar com.jmordars.app.MainApp

This will take some command line args up to 3:
- first arg is the number of seats to run against (int)
- second arg is if you want to run benchmark testing (boolean)
- third arg is how many variances to calculate

Issues/Questions -- Send me an email:
jmordars@gmail.com