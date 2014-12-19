Web Application for NLP Project
===============================
This is a web application for a natural language processing project of Dept. of CS at Stony Brook University. 

We use Spring Framework to implements this web application, Bootstrap and jQuery as front end, java and jsp as back end.

How to set up this web application using eclipse:
=================================================

require environment and tools:
------------------------------

1. Please use Windows, since java API of Attempto APE has some problems in Mac or Linux. 

2. JDK 1.7 or 1.8 http://www.oracle.com/technetwork/articles/javase/index-jsp-138363.html (Recommend to use 1.8. If you use 1.7, you need to change the jdk version in pom.xml)

3. Eclipse IDE for Java EE Developers https://www.eclipse.org/downloads/

4. Apache Tomcat 7 or 8 http://tomcat.apache.org/ 

5. Install maven, http://maven.apache.org/download.cgi and set path to $MAVEN_ROOT\bin

6. Install swipl, http://www.swi-prolog.org/download/stable and set the path to $SWIPL_ROOT\bin

7. Download Attempto APE, https://github.com/Attempto/APE/releases


Steps
-----

1. Copy the jpl.dll file from $SWIPL_ROOT\bin to $SWIPL_ROOT\lib\x64-win64

2. Compile Attempto APE: goto $APE_ROOT
	
	make_exe.bat

3. Build Java Interface for APE, https://github.com/Attempto/APE/tree/master/java. After building of APE, add attempto-ape jar in $APE_ROOT\java\target to your local maven repository.(how to add jar in local maven repository? http://www.mkyong.com/maven/how-to-include-library-manully-into-maven-local-repository/) You also need to add jpl.jar into local maven repository, but you have already done it in the building process. You can find jpl.jar in $SWIPL_ROOT\bin

4. Your also need to add common jar (https://github.com/Jiawei-Kuang/Common.git) into your local maven repository.

4. install tomcat for eclipse (make sure you are not running a tomcat in your pc while you are installing) http://www.programcreek.com/2014/01/install-tomcat-7-for-eclipse/

5. import this project by go to file -> import -> maven -> existing maven project, if you have some error such as "cannot find javax.servlet.http.HttpServletRequest", right click your project -> properties -> java build path -> add Library -> server runtime and select your tomcat.

6. Before you run the project, please note that in SentenceParser.java, you need to change "C:\\ape-6.7-131003\\ape.exe" to your own path in statement 
	
	APELocal.init("C:\\ape-6.7-131003\\ape.exe", true).

7. right click your project -> run as -> run on server, choose your tomcat and then click finish.
