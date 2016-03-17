---
layout: page
show_meta: false
title: "Finished Projects"
teaser: "Older finished projects."
header:
   image_fullwidth: "header_drop.jpg"
permalink: "/subproject/finished/"
breadcrumb: true
---

{% for post in site.categories.finished %}
  {% include _pagination_small.html %}
{% endfor %}
