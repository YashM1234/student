<h1>Student Project</h1>
<p>student project using spring boot, all CRUD Operation using jdbcTemplate</p>


<h2>Model</h2>
<p>we have two model:</p>
<ol>
<li>Student</li>
<ul>
<li>id</li>
<li>fName</li>
<li>lName</li>
<li>age</li>
<li>branch</li>
<li>year</li>
<li>semester</li>
<li>phone_no</li>
<li>courses_name (List of Course)</li>
</ul>

<li>Course</li>
<ul>
<li>courseId</li>
<li>courseName</li>
</ul>
</ol>

<h2>Database</h2>
<p>We have two tables:</p>
<ol>
<li>student</li>
<ul>
<li>student_id (primary key)
<li>fname</li>
<li>lname</li>
<li>age</li>
<li>branch</li>
<li>year</li>
<li>semester</li>
<li>phone_no</li>
</ul>
<li>course</li>
<ul>
<li>course_id (primary key)</li>
<li>course_name</li>
<li>student_id (foreign key)</li>
</ul>
</ol>