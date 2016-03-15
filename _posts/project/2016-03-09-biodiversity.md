---
layout: page
title:  "Biodiversity LOD"
subheadline:  "Biodiversity Linked Open Data"
teaser: "Tools to allow the conversion of raw biodiversity data, usually in the form of tables, into machine processable Linked Open Data sets."
categories:
    - project
tags:
    - project
image:
   thumb: "biodiv-small.jpg"
header:
    image_fullwidth: "biodiv.jpg"
breadcrumb: true
---

Big Data, as found in biodiversity collections and other research products, offers tremendous opportunities for scientific researchers. However, this kind of data, when public available, is not in a machine processable format (usually tables with no metadata).

Experimental data that an investigator collected is often not maintained in a public repository. When it is, it can be challenging even to find it. It is even harder to find all the data from similar experiments. It is generally not possible to compare characteristics of experiments and/or collections.

Usually, the associated metadata is too limited to offer clear insight into what the experimenter actually did or what each piece of data represents. And finally, it is all but impossible for investigators to reproduce other experiments, by using the public metadata about that experiment, or reuse collected data.

Our goal in this project is to create tools to allow the conversion of raw biodiversity data, usually in the form of tables, into [Linked Data](https://www.w3.org/standards/semanticweb/data) sets. These data sets will use ontologies to make them machine processable and to link them to other data sets also available as Linked Data.

## Sub Projects

{% for post in site.categories.biodiv %}
  {% include _pagination_small.html %}
{% endfor %}


### All Projects

{% include list-posts tag='project' %}
