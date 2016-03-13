<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template name="questions">

      <H3>You may find help information:</H3>
      <br/>
      <UL>
        <H3>Searching the site with keywords using Google:</H3>

        <form method="get" action="http://www.google.com/custom">
          <br/>
          <p>
            <input type="text" name="q" size="15" maxlength="255" value=""/>
            <input type="submit" name="sa" value="Go"/>
            <br/>
            <input type="hidden" name="cof" value="T:black;LW:72;ALC:#ff3300;L:http://www.w3.org/Icons/w3c_home;LC:#000099;LH:48;BGC:white;AH:left;VLC:#660066;GL:0;AWFID:0b9847e42caf283e;"/>
            <input type="radio" name="sitesearch" value="{course/id/www}" checked="checked"/>Search
            <FONT FACE="Arial" SIZE="-1">
              <b><xsl:value-of select='course/id/www'/></b>
            </FONT>
            <br/>
          </p>
        </form>
        <br/>
        <H3>Trying the site <A HREF="/library">Library</A>.</H3>
        <br/>
      </UL>
      <I>If after trying the links above, you still have a question, please e-mail:</I>
      <br/>
      <br/>
      <xsl:for-each select='course/id/teacher'>
        <UL>
          <H3>
            <xsl:value-of select='name/first'/> <xsl:value-of select='name/last'/>:
              <A HREF="mailto:{email}"><xsl:value-of select='email'/></A>
          </H3>
          <I>or visit my homepage</I>:
          <A HREF="{www}"><IMG SRC="{$imgDir}/home3.jpg" BORDER="0" HEIGHT="22" WIDTH="76"/></A>
          <br/>
        </UL>
      </xsl:for-each>
      <br/>
      <I>Or e-mail a monitor:</I>
      <br/>
      <br/>
      <xsl:for-each select='course/id/monitor'>
        <UL>
          <H3>
            <xsl:value-of select='name/first'/> <xsl:value-of select='name/last'/>:
              <A HREF="mailto:{email}"><xsl:value-of select='email'/></A>
          </H3>
          <br/>
        </UL>
      </xsl:for-each>

  </xsl:template>

</xsl:stylesheet>
