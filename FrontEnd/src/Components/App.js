
import '../App.css';
import Login from './Login';
import Student from './Student';
import { Link, Route, Router, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
    <Routes>
      <Route path="/" element={<Login/>}/>
      <Route path="/student" element={<Student/>}/>
    </Routes>
    </div>
  );
}

export default App;
