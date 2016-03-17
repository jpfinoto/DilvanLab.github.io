---
layout: page
show_meta: false
title: "Research"
subheadline: "Using semantics to give meaning"
teaser: "Computers understanding science"
header:
   image_fullwidth: "SiteImage.jpg"
permalink: "/research/"
---
The application of Semantic Web technologies is poised to revolutionize the way people use the internet. That impact will be felt sooner in the life sciences, domains like health care, medicine, pharmacology, genetics and biomolecular research are right now beginning to benefit from the Semantic Web revolutionary breakthrough: computers understanding science.

{% comment %}
<ul>
    {% for post in site.categories.project %}
    <li><a href="{{ site.url }}{{ post.url }}">{{ post.title }}</a></li>
    {% endfor %}
</ul>
{% endcomment %}

## Projects

Currently active projects


{% for post in site.categories.project %}
  {% include _pagination_small.html %}
{% endfor %}
