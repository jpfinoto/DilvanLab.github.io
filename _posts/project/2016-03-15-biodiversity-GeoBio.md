---
layout: page
title:  "Using Spatiotemporal Information to Integrate Heterogeneous Biodiversity Semantic Data"
subheadline:  "Biodiversity LOD"
teaser: "Biodiversity is essential to life on Earth and motivates many efforts to collect data about species. These data are collected in different places and published in different formats. Researchers use it to extract new knowledge about living things, but it is difficult to retrieve, combine and integrate data sources from different places. This work will investigate how to integrate biodiversity information from heterogeneous sources using Semantic Web technologies."
categories:
    - subproject
tags:
    - project
image:
   thumb: "geobio.jpg"
header:
    image_fullwidth: "geobio.jpg"
breadcrumb: true
---

Biodiversity is essential to life on Earth and motivates many efforts to collect data about species. These data are collected in different places and published in different formats. Researchers use it to extract new knowledge about living things, but it is difficult to retrieve, combine and integrate data sources from different places. This work will investigate how to integrate biodiversity information from heterogeneous sources using Semantic Web technologies. Its main objective is to propose an architecture to link biodiversity data using mainly their spatiotemporal dimension, effectively search these linked data sets and test them using real use cases, defined with the help of biodiversity experts. It is also an important objective to propose a suitable provenance model that captures not only data origin but also temporal information. This architecture will be tested on a set of representative data from important Brazilian institutions that are involved in studies of biodiversity.

The main question is:

• How can we integrate biodiversity information from heterogeneous sources using their spatial location and temporal data?

To answer this question, We also need to find an answer to the following questions:

• How can we improve the interoperability of the biodiversity data? 

• How can we improve the location accuracy of biodiversity data?

• How to improve the trust in biodiversity data? 
## Sub Projects

{% for post in site.categories.biodiv %}
  {% include _pagination_small.html %}
{% endfor %}

### All Projects

{% include list-posts tag='project' %}
