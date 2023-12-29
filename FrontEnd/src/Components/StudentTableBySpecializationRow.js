import '../App.css'

const StudentTableBySpecializationRow = (props) =>{
    return(
        <tr>
              <td>{props.first}</td>
              <td>{props.second}</td>
              <td>{props.third}</td>
              <td>{props.fourth}</td>
            </tr>
    )
}

export default StudentTableBySpecializationRow;