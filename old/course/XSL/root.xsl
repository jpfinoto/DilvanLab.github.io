<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

   <xsl:output method="html"
               doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN"
               doctype-system= "http://www.w3.org/TR/html4/loose.dtd"
               encoding="ISO-8859-1"
               indent="yes"/>
   <!-- Copyright Dilvan Moreira 2005 -->

<xsl:include href="param.xsl"/>

<xsl:include href="scripts.xsl"/>
<xsl:include href="introduction.xsl"/>
<xsl:include href="contents.xsl"/>
<xsl:include href="calendar.xsl"/>
<xsl:include href="assignments.xsl"/>
<xsl:include href="monitors.xsl"/>
<xsl:include href="questions.xsl"/>

<xsl:template match="/">

<html>
  <head>
    <title> <xsl:value-of select="$courseTitle" /> </title>
    <!-- link rel="stylesheet" href="{$courseStyle}" type="text/css"/ -->
    <xsl:call-template name="menuScripts"/>
  </head>

  <body> <!-- leftmargin="0" topmargin="0"-->
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr valign="top">
        <td background="{$imgDir}/backgr.gif">
              <br/>
	      <p align='center'>
	        <a href="" onClick="return expandcontent('sc1', document.getElementById('contentsLink'))" >
	          <img src="{$courseSymbol}" width="50" height="90" VSPACE="3" BORDER="0"/>
	        </a>
	      </p>
        </td>
        <td id="tablistLine" width="100%">
          <br/>
          <h2>&#160;&#160;
            <font color='blue' face='arial'>
              <xsl:value-of select="$courseTitle" />
            </font>
          </h2>
          <br/>
          <br/>
          <ul id="tablist">
            <li><a id="contentsLink" href="" class="current" onClick="return expandcontent('sc1', this)">Contents</a></li>
            <li><a href="" onClick="return expandcontent('sc2', this)" >Introduction</a></li>
            <li><a id="calendarLink" href="" onClick="return expandcontent('sc3', this)" >Calendar</a></li>
            <li><a id="assignmentsLink" href="" onClick="return expandcontent('sc4', this)" >Assignments</a></li>
            <li><a href="" onClick="return expandcontent('sc5', this)" >Monitors</a></li>
            <li><a href="" onClick="return expandcontent('sc6', this)" >Questions</a></li>
          </ul>
        </td>
      </tr>
      <tr valign="top">
        <td width="350" rowspan="2" background="{$imgDir}/backgr.gif" style="padding-left:45px; text-align:justify;">

          <p align="center">
            <a href="/">
              <img src="{$imgDir}/homepg.gif" VSPACE="3" BORDER="0" HEIGHT="70" WIDTH="70"/>
            </a>
          </p>
          <p>&#160;</p>
          <strong>Main Pages</strong>
          <br/>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="/library/">Library</A>
          <br/>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="/manager_files/newsgroup.jsp?group={$courseId}Course&amp;course_name={$courseTitle}">News Blogs</A>
          <br/>
          <xsl:for-each select='course/id/teacher'>
            <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
            <a href="{www}" >Teacher</a>
            <br/>
          </xsl:for-each>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="/courses.html">Other Courses</A>
          <!--br/>
          <br/>
          <strong>Students Info</strong>
          <br/>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="/manager_files/frameJSP.jsp?database={$courseId}Course&amp;typeOperation=groups" TARGET="Groups">Groups</A>
          <br/>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="/manager_files/frameJSP.jsp?database={$courseId}Course&amp;typeOperation=students" TARGET="Students">Students</A>
          <br/>
          <br/>
          <applet archive="agents.jar" code="agents.ContactStudent" codebase="/manager_files" height="365" width="124">
            <param name="RESOURCE" value="{$courseId}Course"/>
            <param name="CANDIDATE" value="yes"/>
            <param name="HELP" value="no"/>
          </applet>
          <br/>

          <strong>Webstart Controls</strong>
          <br/>
          <IMG SRC="{$imgDir}/smallredball.gif"/>&#160;
          <A HREF="{$javaWebStartDir}/{$courseId}Course.jnlp">WebCoM Tool</A-->
          <p>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>
          <p>&#160;</p>

          <p><br/></p>
        </td>
        <td width="100%" height="100%" style="padding-left:20px; text-align:justify;">
        <br/>

          <div id="tabcontentcontainer">
            <div id="sc1" class="tabcontent">
              <xsl:call-template name="contents"/>
            </div>

            <div id="sc2" class="tabcontent">
              <xsl:call-template name="introduction"/>
            </div>

            <div id="sc3" class="tabcontent">
              <xsl:call-template name="calendar"/>
            </div>

            <div id="sc4" class="tabcontent">
              <xsl:call-template name="assignments"/>
            </div>

            <div id="sc5" class="tabcontent">
              <xsl:call-template name="monitors"/>
            </div>

            <div id="sc6" class="tabcontent">
              <xsl:call-template name="questions"/>
            </div>
          </div>

       </td>
      </tr>
      <tr valign="top">
        <td class="footer" width="100%" height="19" align="center" valign="bottom">
          <!-- %@ include file="footer" % -->
          <br/>
          <center>
            <i>
              <font size="-2">
                <p>This course may contain or point to material from other authors.</p>
                <p>Every effort has been made to ensure that material from other authors 
                   was included in a lawful way and that author names and/or copyright 
                   notices appear on them. Please, if you think that a mistake or omission 
                   has happened, contact this course author.</p>
                 
                <p>$Revision: 1.7 $ $Date: 2006/01/24 20:27:54 $</p>
             
                Copyright &#169; 1998-2005
                <xsl:for-each select="document($courseBook)/book/bookinfo">
                  <xsl:value-of select="copyright/holder"/> - 
                  <xsl:value-of select="author/email"/>.
                </xsl:for-each>
              </font>
            </i>
          </center>
          <br/>
        </td>
      </tr>
    </table>
  </body>
</html>

</xsl:template>
</xsl:stylesheet>

