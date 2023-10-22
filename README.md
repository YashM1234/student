### student project
student project using spring boot, all CRUD Operation using jdbcTemplate 

##Model
we have two model:
#1. Student
   -id
   -fName
   -lName
   -age
   -branch
   -year
   -semester
   -phone_no
   -courses_name (List<Course>)
#2. Course
   -courseId
   -courseName
   
##Database
We have two tables:
#1. student
   -student_id (primary key)
   -fname
   -lname
   -age
   -branch
   -year
   -semester
   -phone_no
#2. course
   -course_id (primary key)
   -course_name
   -student_id (foreign key)
