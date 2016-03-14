---
layout: page
show_meta: false
title: "People"
#subheadline: "Using semantics to give meaning"
#teaser: "Computers understanding science"
header:
   image_fullwidth: "header_unsplash_1.jpg"
permalink: "/people/"
---
We are a team of very committed people!

{% comment %}
<ul>
    {% for post in site.categories.people %}
    <li><a href="{{ site.url }}{{ post.url }}">{{ post.title }}</a></li>
    {% endfor %}
</ul>
{% endcomment %}

## Principal Investigator

{% for post in site.categories.people %}
  {% if post.tags contains 'pi' %}
    {% include _pagination_small.html %}
  {% endif %}
{% endfor %}

## Ph.D. Students

{% for post in site.categories.people %}
  {% if post.tags contains 'phd' %}
    {% include _pagination_small.html %}
  {% endif %}
{% endfor %}

## M.Sc. Students

{% for post in site.categories.people %}
  {% if post.tags contains 'msc' %}
    {% include _pagination_small.html %}
  {% endif %}
{% endfor %}

## Undergraduate Students

{% for post in site.categories.people %}
  {% if post.tags contains 'under' %}
    {% include _pagination_small.html %}
  {% endif %}
{% endfor %}
