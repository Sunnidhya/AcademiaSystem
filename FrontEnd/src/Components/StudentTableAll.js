import '../App.css'
import StudentTableAllRow from './StudentTableAllRow';
const StudentTableAll = (props) =>{
    return(
        <table class="student-table">
          <thead>
            <tr>
              <th>Student Id</th>
              <th>Student Name</th>
              <th>Email</th>
              <th>CGPA</th>
              <th>Total Credits</th>
              <th>Graduation Year</th>
              <th>Student Roll no.</th>
            </tr>
          </thead>
          <tbody>
          {
              props.first.map((item) => {
                  return(
                  <StudentTableAllRow 
                    first={item.studentId} 
                    second={item.studentName} 
                    third={item.email}
                    fourth={item.cgpa}
                    fifth={item.totalCredits}
                    sixth={item.graduationYear}
                    seventh={item.studentRollNo}
                  />
                  );
              })
          }
          </tbody>
        </table>
    );
}

export default StudentTableAll