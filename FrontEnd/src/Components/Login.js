import { useNavigate } from "react-router-dom";
import "../App.css";
import React,{useState, useEffect} from "react";
import { useAuth } from "../Auth/AuthContext";

const Login = () => {
    const [dataLogin, setData] = useState([]);
    let nav = useNavigate();
    const { setAuthenticated } = useAuth();
    const login = async (e,username,passwordV) => {
        e.preventDefault();
        const data = {
            employeeName: username,
            password: passwordV
        };
        await fetch("http://localhost:8080/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        })
          .then((response) => response.text())
          .then((textData) => {
            console.warn("data", textData);
            if(textData == 'Login Successful'){
                setAuthenticated(true)
                alert("Login Successful");
                let path = '/student'
                nav(path);
            }else if(textData == 'Login is not successful'){
                alert("Login Failed!! Wrong UserName or Password");
            }
            setData(textData);
          })
          .catch((e) => {
            console.log("e", e);
          });
        return;
      };

  return (
    <div class="login-container">
      <div class="login-box">
        <img
          className="titleIcon"
          src="https://www.iiitb.ac.in/includefiles/userfiles/images/iiitb_logo.jpg"
        />
        <h2>Login</h2>
        <form class="login-form">
          <div class="form-group">
            <label for="username">Username:</label>
            <input
              type="text"
              id="username"
              name="username"
              placeholder="Enter your username"
              required
            />
          </div>

          <div class="form-group">
            <label for="password">Password:</label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="Enter your password"
              required
            />
          </div>

          <div class="form-group">
            <button
              type="submit"
              onClick={(e) =>
                login(
                  e,
                  document.getElementById("username").value,
                  document.getElementById("password").value
                )
              }
            >
              Login
            </button>
          </div>
        </form>
        <div class="login-footer">
          <p>
            Don't have an account? <a href="#">Sign up</a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;