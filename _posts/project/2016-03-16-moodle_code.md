---
layout: page
title:  "Moodle Code Question"
subheadline:  "Auto Correction"
teaser: "A Quiz plugin for Moodle to allow programming questions that will be corrected automatically."
categories:
    - subproject
tags:
    - learning
image:
   thumb: "unsplash_moodle-code-thumb.png"
header:
    image_fullwidth: "unsplash_moodle-code_header.jpg"
breadcrumb: true
---
*[Learning Tools](/project/learning) Subproject*

*[Github Repository](https://github.com/DilvanLab/MoodleCodeQuestionType)*

`qtype_code` is a question type that autocorrects source code based on some settings.
The question's creator can select an environment in which the student's code will be run, as well as environment-specific settings.
Feedback can be customized by the grader application, and any programming language is supported.

The environment system is very powerful and robust, being able to support several types of correction methods.
Compiling and running can be done inside a [`docker`](https://www.docker.com/) container, being completely isolated from the host.

This question type also uses Moodle's logger, creating an entry every time code is executed.
The content of the logger can be customized by the environment.

This system can be used as a learning tool, providing students with a controlled environment in which they can develop their programming skills.
Being a part of Moodle, code question can be inserted into any course, and created easily by the teacher.

### [Learning Tools](/project/learning) Subprojects

{% include list-posts tag='learning' %}
