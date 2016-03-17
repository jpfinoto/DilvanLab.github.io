<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template name="calendar">
		<H4>Calendar of Activities:</H4>
		<P>The days mark the deadlines for you to master the contents.</P>
		<BR/>
		<TABLE BORDER="0" CELLSPACING="6" CELLPADDING="6" NOSAVE="">
			<xsl:apply-templates select="course/calendar/day"/>
		</TABLE>
	</xsl:template>

	<xsl:template match="day">
	   <TR>
	      <TD VALIGN="TOP" BGCOLOR="#E0E0FF">
	         <B>
		      <FONT face="ARIAL" size="-1">
		        <xsl:choose>
			      <xsl:when test="@m[.='1']">January </xsl:when>
			      <xsl:when test="@m[.='2']">February </xsl:when>
			      <xsl:when test="@m[.='3']">March </xsl:when>
			      <xsl:when test="@m[.='4']">April </xsl:when>
			      <xsl:when test="@m[.='5']">May </xsl:when>
			      <xsl:when test="@m[.='6']">June </xsl:when>
			      <xsl:when test="@m[.='7']">July </xsl:when>
			      <xsl:when test="@m[.='8']">August </xsl:when>
			      <xsl:when test="@m[.='9']">September </xsl:when>
			      <xsl:when test="@m[.='10']">October </xsl:when>
			      <xsl:when test="@m[.='11']">November </xsl:when>
			      <xsl:when test="@m[.='12']">December </xsl:when>
                </xsl:choose>
                <xsl:value-of select="@d"/>
		        <font color="#9595CF"><br/><xsl:value-of select="@y"/></font>  
	          </FONT>
		    </B>
	      </TD>
	      <TD VALIGN="TOP" BGCOLOR="#E0E0FF">
	        
		      <dt>
		        <IMG SRC="{$imgDir}/smallredball.gif" HSPACE="5" VSPACE="2" HEIGHT="8" WIDTH="8"/>
		        <b>Lecture: <font color="#888888" size="-1"> (<xsl:number value="position()" format=" 1"/>)</font></b>
              </dt>
                <xsl:apply-templates/>
            
          </TD>
       </TR>
    </xsl:template>

	<xsl:template match="chapter">
 	  <xsl:param name="chapterId" select="@id"/>
	    <dd>
		  <font color="#FF4444">
		    <b>
              <xsl:for-each select="document($courseBook)/book/chapter[@id=$chapterId]">
                <xsl:value-of select="title"/>
              </xsl:for-each>
		    </b>
		  </font>
		</dd>
	</xsl:template>

	<xsl:template match="section">
 	  <xsl:param name="sectionId" select="@id"/>
	  <dd>
	    <img src="{$imgDir}/smallyellowball.gif" hspace="5" vspace="2" height="8" width="8"/>
		
		  <xsl:for-each select="document($courseBook)/book/chapter">
            <xsl:for-each select="section[@id=$sectionId]">
			  <a href="{$bookHtml}/{@id}.html">
				<xsl:value-of select="title"/>
		      </a>.
            </xsl:for-each>
          </xsl:for-each>
		
	  </dd>
	</xsl:template>

	<xsl:template match="body">
	  <dd>
	    <img src="{$imgDir}/smallgreenball.gif" hspace="5" vspace="2" height="8" width="8"/>
	    <b>
          <xsl:value-of select="text()"/>
	    </b>
      </dd>
	</xsl:template>
</xsl:stylesheet>
