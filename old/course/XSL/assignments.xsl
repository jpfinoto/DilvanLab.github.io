<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template name="assignments">

     <xsl:for-each select="document($courseBook)/book">
	<h2>Course Assignments</h2>

        <xsl:for-each select="chapter">
           <xsl:if test="@role='assignments'">
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

     <H2><IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>Assignments Format </H2>
<UL>
  <P>
     The assignments should be posted to the course pages using the <A HREF="#UPLOAD">upload tools</A>.
     They should always contain a main HTML page named <B>index.html</B> with links to all other assignment
     files.
     Assignments that include software code should include the software source files, executable files
     and a HTML file with the UDF (Unit Development Folder) report.
     This UDF file will be the assignment's main HTML file (<B>index.html</B>).
  </P>
  <P>
    <B>All</B> main HTML files must contain the names of all students of the group.
  </P>

  <H3>Peer Review</H3>
  <P>
    If Peer Review is being used, each group of students will review the work of another group.
    When this work is a software design the review must cover the following topics:
  </P>
  <UL type="disc">
    <LI>The quality of the software design.</LI>
    <LI>The quality of the code generated.</LI>
    <LI>Could your group have done something better?</LI>
  </UL>
  <P>
    The review should be handed in using the same procedure as the assignment.
    It should be a HTML file.
    Don't forget to send any included file together with your main file (<B>index.html</B>).
  </P>

  <I>Grades</I>
  <P>
    Each group grade will be based on the quality of its assignment and of its review of the
    work of another group. The reviewers opinions about a group work can be challenged, during debate
    in class or by e-mail/chat (depending on the course format).
    A group grade is not determined by its review.
    The review and the debate between the group and its reviewers serve as a tool to help the teacher
    grade the group (and reviewers) work.
  </P>
</UL>

<H2>
  <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>
  <A NAME="UPLOAD"/>Upload Tools
</H2>
  <H3>
    <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallyellowball.gif" VSPACE="3" WIDTH="8"/> Browser Upload Tool
  </H3>
  <UL>
    <P>
      The button <I>Upload Files</I> will transfer files direct from your local directory to their proper
      location in the course site (It uses HTML forms). It will take some time until your files are
      cleared to appear in the site. Please, do not forget to check the site to be sure that all files
      were uploaded correctly.
    </P>
  </UL>
  <H3>
    <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallyellowball.gif" VSPACE="3" WIDTH="8"/> Applet FTP Tool
  </H3>
  <UL>
    <P>
      The button <I>FTP Tool</I> will transfer files direct from your local directory to their proper
      location in the course site. It uses applet Java code.
      It will take some time until your files are cleared to appear in the site. Please, do not forget
      to check the site to be sure that all files were uploaded correctly.
    </P>
  </UL>
  <H3>
    <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallyellowball.gif" VSPACE="3" WIDTH="8"/> Automatic E-mail Tool
  </H3>
  <UL>
    <P>
      This tool allows you to send your files as attachments to an e-mail.
      The files will be detached from the e-mail and loaded in their proper location in the course site.
    </P>
    <P>
      The tool will periodically check its email address and process all emails with the subject
      <TT>course</TT>.
      To successfully submit an email to the tool and have the attached files uploaded to the site
      the users must follow these rules:
    </P>
    <UL type="disc">
      <LI>
        The subject of the email has to be:<B><TT>course</TT></B>.
      </LI>
      <LI>
        The body of the email should have the lines:
      </LI>
      <UL type="disc">
        <LI>
          <code>#username <i>&lt;username of the user&gt;</i></code>
        </LI>
        <LI>
          <code>#coursename <i>&lt;course name, i.e. Operating Systems II, Microprocessors etc.&gt;</i></code>
        </LI>
        <LI>
          <code>#activity <i>&lt;activity being uploaded, i.e. report1, review6, assignment2, etc.&gt;</i></code>
        </LI>
      </UL>
      <LI>All the files being uploaded should be attached to the email.</LI>
      <LI>
        The email should be sent to: <A HREF="mailto:virtualme@java.icmc.usp.br">virtualme@java.icmc.usp.br</A>.
      </LI>
    </UL>
    <P>
      After processing, the tool will always send back to the user an email either confirming the uploading
      of the files or informing the error that stopped the uploading process.
      If you do not receive an e-mail from the tool it indicates that, for some reason, your e-mail was
      not processed by the toll.
    </P>
  </UL>


  </xsl:template>

</xsl:stylesheet>
