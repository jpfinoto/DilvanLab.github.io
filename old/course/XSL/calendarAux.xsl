<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:include href="param.xsl"/>

  <xsl:output
          method="xml"
          encoding="ISO-8859-1"
          omit-xml-declaration="yes"
          indent="yes"/>

  <xsl:template match="/">
     <xsl:for-each select="document($courseBook)/book">

        <xsl:for-each select="chapter">
           <xsl:choose>
	          <xsl:when test="(@role)">
	             <chapter id="{@id}" role="{@role}"/>
	          </xsl:when>
	          <xsl:otherwise>
	             <chapter id="{@id}"/>
	          </xsl:otherwise>
	       </xsl:choose>
           <xsl:for-each select="section">
		      <section id="{@id}"/>
           </xsl:for-each>
        </xsl:for-each>

     </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
