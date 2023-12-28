import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import SignUp from './components/registration/SignUp';
import SignIn from './components/registration/SignIn';
import RegisterDriver from './components/admin/AddDriver';
import { NavbarApp } from './components/NavBar';
import HomePage from './components/homepage/HomePage';
import Home from './components/homepage/Home';
import EditUser from './components/user/EditUser';
import ActivateUser from './components/registration/ActivateUser';
import ForgotPassword from './components/registration/ForgotPassword';
import UserPage from './components/user/UserPage';
import UserHistory from './components/admin/UserHistory';
import DriveData from './components/admin/DriveData';

function App() {
  const [count, setCount] = useState(0)

  return (

    <Router>
      <div className='App'>
        <NavbarApp/>
        <div className='content'>
          <Routes>
            <Route path="/" element={<Home/>}></Route>
            <Route path="/signUp" element={<SignUp/>}></Route>
            <Route path="/signIn" element={<SignIn/>}></Route>
            <Route path="/HomePage" element={<Home/>}></Route>
            <Route path="/editInfo" element={<EditUser/>}></Route>

            <Route path="/registerDriver" element={<RegisterDriver/>}/>
            <Route path="/activate" element={<ActivateUser/>}/>
            <Route path="/resetPassword" element={<ForgotPassword/>}/>
            <Route path='/user' element={<UserPage userId={1}/>}/> 
            <Route path='/history' element={<UserHistory/>}/>
            <Route path='/driveData' element={<DriveData/>}/>
            {/* promeniti userPage da putanja bude id usera */}
          </Routes>
        </div>
      </div>
    </Router>
    // <>
    //   <div>
    //     <a href="https://vitejs.dev" target="_blank">
    //       <img src={viteLogo} className="logo" alt="Vite logo" />
    //     </a>
    //     <a href="https://react.dev" target="_blank">
    //       <img src={reactLogo} className="logo react" alt="React logo" />
    //     </a>
    //   </div>
    //   <h1>Vite + React</h1>
    //   <div className="card">
    //     <button onClick={() => setCount((count) => count + 1)}>
    //       count is {count}
    //     </button>
    //     <p>
    //       Edit <code>src/App.jsx</code> and save to test HMR
    //     </p>
    //   </div>
    //   <p className="read-the-docs">
    //     Click on the Vite and React logos to learn more
    //   </p>
    // </>
  )
}

export default App
