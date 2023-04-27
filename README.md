# mySchool

mySchool-project-java
a simulation of a Java training school. This school will admit students and they will receive training by a team of specialist instructors.

The school offers training courses on various Java’s related subjects. Some examples of subjects are showed in Table 1. Each subject has a unique ID and belong to some area of specialism. The duration for the course associated with each subject is specified. The specialism determines the type of instructors that can deliver the course. For example, for the subject titled “Basics (variables, conditionals, methods, loop, etc.)” (with ID “1”), the duration for a course covering the subject is 5 days. Furthermore, the subject belongs to Specialism “1” and can be taught by any teachers.

There are a number of concepts, people, and procedures that contribute to this simulation. For our purposes these include:

Students: Students will be admitted to the school to study a number of subjects. These subjects need to be taught by the instructors. A student can only enrol to at most ONE course at a time. Once the students have graduated they can leave the school.

Courses: The school will create courses to teach different subjects. Each course is associated with exactly ONE subject. Each course will have a maximum 3 students and must be taught by an instructor.

Instructors: The school will be staffed by a number of instructors. The instructors may have particular specialisms that let them teach particular subjects. Some subjects can only be taught by instructors with the right specialism. An instructor will teach at most ONE course at a time.

School: For our purposes a school will manages the courses, students, and instructors.

Administrator: The school administrator is in charge of registering/deregistering students and instructors to the school.
