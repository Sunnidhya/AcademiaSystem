import "../App.css";
import React, { useState, useEffect } from "react";
import StudentTableAll from "./StudentTableAll";
import StudentTableBySpecialization from "./StudentTableBySpecialization";
import { useAuth } from "../Auth/AuthContext";
import { useNavigate } from "react-router-dom";
const Student = () => {
  const [selectedValueD, setSelectedValueD] = useState("all");
  const [selectedValueS, setSelectedValueS] = useState("all");
  const [comp, setComp] = useState();
  const [data, setData] = useState([]);
  const [dataByDomain, setDataByDomain] = useState([]);
  const [dataBySpecialization, setDataBySpecialization] = useState([]);
  const { isAuthenticated } = useAuth();
  const { setAuthenticated } = useAuth();
  const nav = useNavigate();
  const handleLogout = () => {
    setAuthenticated(false);
    nav("/");
  };
  const getStudents = async () => {
    setComp(1);
    setSelectedValueD("all");
    setSelectedValueS("all");
    let result = await fetch("http://localhost:8080/students");
    result = await result.json();
    setData(result);
    console.warn("data", result);
    //window.location.reload(false);
  };
  const getPostStudentByDomain = async (id) => {
    setSelectedValueD(id);
    setSelectedValueS("all");
    setComp(2);
    if (id == "all") {
      getStudents();
    } else {
      const data = {
        domainId: id,
      };
      await fetch("http://localhost:8080/student/domain", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((response) => response.json())
        .then((json) => {
          console.warn("data", json);
          setDataByDomain(json);
        })
        .catch((e) => {
          console.log("e", e);
        });
    }
    //window.location.reload(false);
  };
  const getPostStudentBySpecialization = async (id) => {
    setSelectedValueD("all");
    setSelectedValueS(id);
    setComp(3);
    if (id == "all") {
      getStudents();
    } else {
      const data = {
        specializationId: id,
      };
      await fetch("http://localhost:8080/student/studentBySpecialization", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((response) => response.json())
        .then((json) => {
          console.warn("data", json);
          setDataBySpecialization(json);
        })
        .catch((e) => {
          console.log("e", e);
        });
    }
    //window.location.reload(false);
  };

  useEffect(() => {
    if (isAuthenticated) {
      setAuthenticated(true)
      getStudents();
    } else {
      console.log("dev", isAuthenticated);
      return nav("/");
    }
  }, []);

  return (
    <>
      <div class="header">
        <h1>Student List</h1>
        <div class="filters">
          <label for="domain">Domain:</label>
          <select
            value={selectedValueD}
            id="domain"
            onChange={(e) => getPostStudentByDomain(e.target.value)}
          >
            <option value="all">All</option>
            <option value="1">Theory</option>
            <option value="2">Intelligent Systems</option>
          </select>

          <label for="specialization">Specialization:</label>
          <select
            value={selectedValueS}
            id="specialization"
            onChange={(e) => getPostStudentBySpecialization(e.target.value)}
          >
            <option value="all">All</option>
            <option value="1">AI/ML</option>
            <option value="2">CSE</option>
          </select>

          <button id="refresh" onClick={() => getStudents()}>
            Refresh
          </button>
          <button
            id="logout"
            className="logoutView"
            onClick={() => handleLogout()}
            style={{
              padding: "10px",
              backgroundColor: "#d9534f",
              color: "white",
              border: "none",
              borderRadius: "5px",
              marginLeft: "10px",
              cursor: "pointer",
            }}
          >
            Logout
          </button>
        </div>
      </div>

      <div class="table-container">
        {comp == 1 && <StudentTableAll first={data} />}
        {comp == 2 && <StudentTableAll first={dataByDomain} />}
        {comp == 3 && (
          <StudentTableBySpecialization first={dataBySpecialization} />
        )}
      </div>
    </>
  );
};

export default Student;
