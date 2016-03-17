<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template name="contents">

     <xsl:for-each select="document($courseBook)/book">

     <h2>Contents: <font color='blue' face='arial'><xsl:value-of select="bookinfo/title"/></font></h2>
     <xsl:for-each select="chapter">
	<xsl:if test="not(@role) or @role!='assignments'">
		<b><p><img src="{$imgDir}/smallredball.gif" hspace="5" vspace="3"/>
		<font face="arial" size="+1"><a href="{$bookHtml}/{@id}.html"><xsl:value-of select="title"/></a></font></p></b>
		<dl>
		<xsl:for-each select="section">
			<dd>
				<img src="{$imgDir}/smallyellowball.gif" hspace="5" vspace="2"/>
				<b><font size="+1"><a href="{$bookHtml}/{@id}.html"><xsl:value-of select="title"/></a></font></b>
			</dd>
		</xsl:for-each>
		</dl>
	</xsl:if>
     </xsl:for-each>
     </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>
