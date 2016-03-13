---
layout: page
show_meta: false
title: "Finished Projects"
teaser: "Older finished projects."
header:
   image_fullwidth: "header_drop.jpg"
permalink: "/finishedProjects/"
---

{% for post in site.categories.subproject %}
  {% if post.tags[0] == 'old' %}
    {% include _pagination_small.html %}
  {% endif %}
{% endfor %}
