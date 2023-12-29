import '../App.css'

const StudentTableAllRow = (props) =>{
    return(
        <tr>
              <td>{props.first}</td>
              <td>{props.second}</td>
              <td>{props.third}</td>
              <td>{props.fourth}</td>
              <td>{props.fifth}</td>
              <td>{props.sixth}</td>
              <td>{props.seventh}</td>
        </tr>
    )
}

export default StudentTableAllRow;