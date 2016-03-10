---
#
# Use the widgets beneath and the content will be
# inserted automagically in the webpage. To make
# this work, you have to use › layout: frontpage
#
layout: frontpage
header:
  image_fullwidth: header_unsplash_5.jpg
widget1:
  title: "Research"
  url: '/research'
  image: researchImg-303x182.jpg
  text: 'The basic line of research is Semantic Web technologies applied to Bioinformatics. Java technologies are the tools used.'
widget2:
  title: "GitHub Resources"
  url: 'https://github.com/DilvanLab'
  image: widget-github-303x182.jpg
  text: 'Much of our projects code is freely available at GitHub:<ol> <li><a href="https://github.com/DilvanLab" target="_blank"> DilvanLab </a>.</li></ol>'
widget3:
  title: "Moodle Web Courses"
  url: 'http://java.icmc.usp.br/moodle'
  image: moodle-303x182.png
  text: 'Training using the WWW is a very powerful way of distant learning. Here you have the chance to follow courses, given at University of São Paulo - USP (Brazil), or just access course materials. There are also <a href="/oldcourses">older courses (before 2006)</a> available.'

#
# Use the call for action to show a button on the frontpage
#
# To make internal links, just use a permalink like this
# url: /getting-started/
#
# To style the button in different colors, use no value
# to use the main color or success, alert or secondary.
# To change colors see sass/_01_settings_colors.scss
#  
#callforaction:
#  url: https://tinyletter.com/feeling-responsive
#  text: Inform me about new updates and features ›
#  style: alert
permalink: /index.html
#
# This is a nasty hack to make the navigation highlight
# this page as active in the topbar navigation
#
homepage: true
---
