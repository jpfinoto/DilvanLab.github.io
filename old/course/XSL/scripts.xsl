<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template name="menuScripts">

  <style type="text/css">
    <![CDATA[
    
.menu {font-family: verdana; font:bold; font-size: 10px; color:black ; text-decoration: none;}
.menu a:link {font-family: verdana; font:bold; font-size: 10px; color:black ; text-decoration: none;}
.menu a:visited {font-family: verdana; font:bold; font-size: 10px; color:black; text-decoration: none;}
.menu a:hover {color:black; text-decoration:underline; background-color:transparent;}

.painel {font-family: verdana;  font-size: 10px; color:black ; text-decoration: none;}
.painel a:link {font-family: verdana;  font-size: 10px; color:blue ; text-decoration: underline;}
.painel a:visited {font-family: verdana;  font-size: 10px; color:blue ; text-decoration: underline;}
.painel a:hover {font-family: verdana;  font-size: 10px; color:blue ; text-decoration: none;}
.painel td {font-family: verdana;  font-size: 10px; color:black ; text-decoration: none;}


.footer {font-family: verdana;  font-size: 8px; color:black ; text-decoration: none;}
.footer td {font-family: verdana;  font-size: 8px; color:black ; text-decoration: none;}

H5 { FONT-SIZE: 12px; COLOR: #466381 }
body { margin-left: 0; margin-top: 0; }


      #tablist{
         padding: 3px 0;
         margin-left: 0;
         margin-bottom: 0;
         margin-top: 0.1em;
         font: bold 12px Verdana;
      }

      #tablist li{
         list-style: none;
         display: inline;
         margin: 0;
      }

      #tablist li a{
         padding: 3px 0.5em;
         margin-left: 3px;
         border: 1px solid #778;
         border-bottom: 1px solid lightblue;
         background: lightyellow;
      }

      #tablist li a:link, #tablist li a:visited{
         color: navy;
      }

      #tablist li a.current{
         background: lightblue;
      }

      #tablistLine{
         border-bottom: 8px solid lightblue;
         /*#FFCC66;*/
      }

      #tabcontentcontainer{
         /*border-top: 5px solid lightblue;
         *border-top: 1px solid #778;

         *width: 400px;
         * Insert Optional Height definition here to give all the content a unified height *
         padding: 5px;
         border: 1px solid black;*/
      }

      .tabcontent{
         display:none;
      }
    ]]>
  </style>

  <script type="text/javascript">
    <![CDATA[
      /***********************************************
      * Tab Content script- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
      * This notice MUST stay intact for legal use
      * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
      ***********************************************/

      //Set tab to intially be selected when page loads:
      //[which tab (1=first tab), ID of tab content to display]:
      var initialtab=[1, "sc1"]

      ////////Stop editting////////////////

      function cascadedstyle(el, cssproperty, csspropertyNS){
         if (el.currentStyle)
            return el.currentStyle[cssproperty]
         else if (window.getComputedStyle){
            var elstyle=window.getComputedStyle(el, "")
            return elstyle.getPropertyValue(csspropertyNS)
         }
      }

      var previoustab=""

      function expandcontent(cid, aobject){
         if (document.getElementById){
            highlighttab(aobject)
            detectSourceindex(aobject)
            if (previoustab!="")
               document.getElementById(previoustab).style.display="none"
            document.getElementById(cid).style.display="block"
            previoustab=cid
            if (aobject.blur)
               aobject.blur()
            return false
         } else
            return true
      }
 
      function highlighttab(aobject){
         if (typeof tabobjlinks=="undefined")
            collecttablinks()
         for (i=0; i<tabobjlinks.length; i++)
            tabobjlinks[i].style.backgroundColor=initTabcolor
         var themecolor=aobject.getAttribute("theme")? aobject.getAttribute("theme") : initTabpostcolor
         aobject.style.backgroundColor= themecolor
         //document.getElementById("tabcontentcontainer").style.backgroundColor=themecolor
      }

      function collecttablinks(){
         var tabobj=document.getElementById("tablist")
         tabobjlinks=tabobj.getElementsByTagName("A")
      }

      function detectSourceindex(aobject){
         for (i=0; i<tabobjlinks.length; i++){
            if (aobject==tabobjlinks[i]){
               tabsourceindex=i //source index of tab bar relative to other tabs
               break
            }
         }
      }

      function do_onload(){
         var cookiename=(persisttype=="sitewide")? "tabcontent" : window.location.pathname
         var cookiecheck=window.get_cookie && get_cookie(cookiename).indexOf("|")!=-1
         collecttablinks()
         initTabcolor=cascadedstyle(tabobjlinks[1], "backgroundColor", "background-color")
         initTabpostcolor=cascadedstyle(tabobjlinks[0], "backgroundColor", "background-color")
         if (typeof enablepersistence!="undefined" && enablepersistence && cookiecheck){
            var cookieparse=get_cookie(cookiename).split("|")
            var whichtab=cookieparse[0]
            var tabcontentid=cookieparse[1]
            expandcontent(tabcontentid, tabobjlinks[whichtab])
         } else
            expandcontent(initialtab[1], tabobjlinks[initialtab[0]-1])
      }

      if (window.addEventListener)
         window.addEventListener("load", do_onload, false)
         else if (window.attachEvent)
            window.attachEvent("onload", do_onload)
         else if (document.getElementById)
            window.onload=do_onload

   ///script>
   //script type="text/javascript">

      //Dynamicdrive.com persistence feature add-on

      var enablepersistence=true //true to enable persistence, false to turn off (or simply remove this entire script block).
      var persisttype="local" //enter "sitewide" for Tab content order to persist across site, "local" for this page only

      function get_cookie(Name) {
         var search = Name + "="
         var returnvalue = "";
         if (document.cookie.length > 0) {
            offset = document.cookie.indexOf(search)
            if (offset != -1) {
               offset += search.length
               end = document.cookie.indexOf(";", offset);
               if (end == -1) end = document.cookie.length;
               returnvalue=unescape(document.cookie.substring(offset, end))
            }
         }
         return returnvalue;
      }

      function savetabstate(){
         var cookiename=(persisttype=="sitewide")? "tabcontent" : window.location.pathname
         var cookievalue=(persisttype=="sitewide")? tabsourceindex+"|"+previoustab+";path=/" : tabsourceindex+"|"+previoustab
         document.cookie=cookiename+"="+cookievalue
      }

      window.onunload=savetabstate
    ]]>

  </script>

</xsl:template>
</xsl:stylesheet>
