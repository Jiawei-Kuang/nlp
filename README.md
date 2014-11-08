This is a web application for a natural language processing project of Dept. of CS at Stony Brook University. 

We use MVC pattern to implements this web application based on Spring Framework, Bootstrap and jQuery as front end, java and jsp as back end.

How to set up this web application using eclipse:

require environment and tools:

1. JDK 1.7 or 1.8 http://www.oracle.com/technetwork/articles/javase/index-jsp-138363.html (If you use 1.7, you need to change the jdk version in pom.xml)

2. Eclipse IDE for Java EE Developers https://www.eclipse.org/downloads/

3. Apache Tomcat 7 or 8 http://tomcat.apache.org/

4. Browser: Recommend to use Chrome by now, other browsers and eclipse will have misplaces of the html element. 

Steps

1. install tomcat for eclipse (make sure you are not running a tomcat in your pc) http://www.programcreek.com/2014/01/install-tomcat-7-for-eclipse/

2. import this project by go to file -> import -> maven -> existing maven project, if you have some error such as "cannot find javax.servlet.http.HttpServletRequest", right click your project -> properties -> java build path -> add Library -> server runtime and select your tomcat.

3. right click your project -> run as -> run on server, choose your tomcat and then click finish.
