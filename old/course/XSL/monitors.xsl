<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template name="monitors">
      <H3>
        <BR/>
        The Monitor(s) of this course will be glad to answer any question related to it.
        <BR/>
        <BR/>
        Please Email:
        <FONT COLOR="#FF0000">
          <xsl:for-each select='course/id/monitor'>
            <UL>
              <xsl:value-of select='name/first'/>&#160;<xsl:value-of select='name/last'/>:
              <A HREF="mailto:{email}"><xsl:value-of select='email'/></A>
              <br/>
            </UL>
          </xsl:for-each>
        </FONT>
      </H3>

  </xsl:template>

</xsl:stylesheet>
