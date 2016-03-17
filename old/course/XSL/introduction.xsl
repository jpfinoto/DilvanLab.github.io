<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template name="introduction">
      <P>
        The goal of the WWW pages of this course is to offer students all the
        material about the course in a format more <I>learner friendly</I>.
        Here you can find a guide with the contents of the course,
        all the transparencies shown at lectures and complementary material in
        the form of papers, auxiliary texts and links to WWW pages with related
        material.
      </P>
      <P>
        Keep in mind that these WWW pages are an evolving tool. They may have
        mistakes and be subject to big changes as the course progresses. I hope
        you enjoy this new teaching tool and help to make it work.
      </P>
      <H2>
        <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>
        <A NAME="SIGN"> </A>Sign in
      </H2>
      <UL>
        <P>
          You must use the button <I>Join Candidate</I> to register yourself as a user.
          <BR/>
          You will have to chose a username (lower case letters) and answer the
          questions in the form. An e-mail will be sent to confirm your registration.
        </P>
        <P>
          <B> <font color="#FF0000">Attention:</font> </B> Some time after you
          register, a temporary password will be sent to you by e-mail. Please,
          using the <i>Change Password</i> button change it and set the password
          question-answer pair as soon as possible. In case you forget your password,
          use the <I>Forgot Password?</I> button to answer the question you set
          (in the question-answer pair) to set a new password.
          <BR/>
        </P>
      </UL>
      <H2>
        <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>
        Following the course
      </H2>
      <UL>
        <P>
          To follow the course you will need an Internet browser that supports
          Java and JavaScript (Microsoft Explorer or Netscape). Use the Sun Java
          implementation (download from <A HREF="http://java.sun.com">http://java.sun.com</A>),
          it works for Explorer and Netscape browsers.
        </P>
        <P>
          The <a href="" onClick="return expandcontent('sc3', document.getElementById('calendarLink'))" >Calendar tab</a>
          has the schedule of the course.
        </P>
      </UL>
      <H2>
        <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>
        Group Assignments
      </H2>
      <UL>
        <P>
          The course assignments should be done by groups of students. The group
          can coordinate its work using the Internet. Students can use Blogs,
          the <A HREF="/manager_files/newsgroup.jsp?group={$courseId}Course&amp;course_name={$courseTitle}">
          news Blogs</A>, the assignments subdirectory, or any other resource that all members
          of the group have access.
        </P>
        <P>
          To form a group use the <I>Manage Groups</I> button (in the applet).
        </P>
        <P>
          More information on the <a href="" onClick="return expandcontent('sc4', document.getElementById('assignmentsLink'))" >Assignments tab</a>.
        </P>
      </UL>
      <H2>
        <IMG HEIGHT="8" HSPACE="5" SRC="{$imgDir}/smallredball.gif" VSPACE="3" WIDTH="8"/>
        Software Downloads
      </H2>
      <UL>
        <P>
          In the <A HREF="/library">Library page</A> you can find interesting
          software packages and other materials. You are not required to download
          them to follow the course.
        </P>
      </UL>
  </xsl:template>

</xsl:stylesheet>
