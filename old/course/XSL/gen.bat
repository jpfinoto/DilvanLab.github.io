set savedCLASSPATH=%CLASSPATH%
set CLASSPATH=.;.\xalan.jar;%CLASSPATH%

REM java Xslt ..\%1\course.xml root.xsl index.html

REM java Xslt ..\%1\course.xml javawebstart.xsl %1Course.jnlp

java Xslt ..\%1\course.xml calendarAux.xsl calendarAux.xml

set CLASSPATH=%savedCLASSPATH%

REM java strchg "&#38;" "&" *.html
REM del *.html.old

REM copy *.html ..\%1\
REM del *.html

copy *.jnlp ..\javaWebStart\
del *.jnlp

copy *.xml ..\%1\
del *.xml
