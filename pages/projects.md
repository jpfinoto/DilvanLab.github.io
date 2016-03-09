---
layout: page
show_meta: false
title: "Projects"
teaser: "Computers understanding science"
header:
   image_fullwidth: "header_unsplash_5.jpg"
permalink: "/projects/"
---
<ul>
    {% for post in site.categories.project %}
    <li><a href="{{ site.url }}{{ post.url }}">{{ post.title }}</a></li>
    {% endfor %}
</ul>
