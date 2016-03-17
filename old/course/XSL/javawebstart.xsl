<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:include href="param.xsl"/>

  <xsl:output
          method="xml"
          encoding="ISO-8859-1"
          omit-xml-declaration="no"
          indent="yes"/>

  <xsl:template match="/">
 		<jnlp	spec="1.0+"
                        codebase="{/course/id/www}/manager_files/"
    			href="{/course/id/www}{$javaWebStartDir}/{course/id/name}Course.jnlp">
  	  		<information>
  	    			<title><xsl:value-of select="/course/id/title"/></title>
    				<vendor>Dilvan Moreira</vendor>
     				<homepage href="{/course/id/www}"/>
  	   			<description>WebCoM - Web Course Management </description>
     				<description kind="short">Course Management Tools</description>
     				<icon href="webcom.gif"/>
     				<offline-allowed/>
   	 		</information>
    			<security>
      				<all-permissions/>
 	  		</security>
   			<resources>
      				<j2se version="1.3.*"/>
      				<j2se version="1.4.*"/>
      				<j2se version="1.5.*"/>
      				<jar href="agents.jar"/>
    			</resources>
    			<applet-desc
        			documentBase="{/course/id/www}/manager_files"
        			name="WebCoM Contact "
      	  			main-class="agents.ContactStudent"
        			width="124"
        			height="320">
    			<param name="resource" value="{course/id/name}Course"/>
   	 			<param name="candidate" value="yes"/>
    			<param name="help" value="no"/>
 			</applet-desc>
 		</jnlp>
  </xsl:template>
</xsl:stylesheet>
