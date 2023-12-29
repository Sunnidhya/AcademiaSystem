import '../App.css'
import StudentTableAllRow from './StudentTableAllRow';
import StudentTableBySpecializationRow from './StudentTableBySpecializationRow';
const StudentTableBySpecialization = (props) =>{
    return(
        <table class="student-table">
          <thead>
            <tr>
              <th>Student Id</th>
              <th>Student Name</th>
              <th>Specialization Name</th>
              <th>Total Credits</th>
            </tr>
          </thead>
          <tbody className='rowTab'>
          {
              props.first.map((item) => {
                  return(
                  <StudentTableBySpecializationRow 
                    first={item.studentId} 
                    second={item.studentName} 
                    third={item.name}
                    fourth={item.credits}
                  />
                  );
              })
          }
          </tbody>
        </table>
    );
}

export default StudentTableBySpecialization