<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!-- Copyright Dilvan Moreira 2005 -->

<xsl:param name="courseBook">../../books/<xsl:value-of select="course/book"/>/xml/book.xml</xsl:param>
<xsl:param name="courseId" select="course/id/name"/>
<xsl:param name="courseTitle" select="course/id/title"/>
<xsl:param name="bookHtml">../../books/<xsl:value-of select="course/book"/>/html</xsl:param>
<xsl:param name="imgDir">../img</xsl:param>
<xsl:param name="courseSymbol">symbol.gif</xsl:param>
<xsl:param name="javaWebStartDir">/course/javaWebStart</xsl:param>
<!-- xsl:param name="courseStyle">../style.css</xsl:param-->


</xsl:stylesheet>
