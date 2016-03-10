---
layout: page
show_meta: false
title: "Projects"
teaser: "Computers understanding science"
header:
   image_fullwidth: "header_drop.jpg"
permalink: "/project/"
---

{% for post in site.categories.project %}
   {% include _pagination_small.html %}
{% endfor %}
