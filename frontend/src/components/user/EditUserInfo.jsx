import * as React from 'react';
import axios from 'axios';

const defaultTheme = createTheme();

export default function EditUserInfo() {


    const handleEdit = (user) => {

        axios
            .put("http://localhost:9090/passenger/edit/${user.id}")
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error)
            })
    }

    return(
        <div className="container white">
         <h3 className="center"> 
         User List
         <Button className="btn-createUser" color="info">
             <Link to='/signup'>Add New User</Link>
         </Button>
         </h3>          
        <form className="inline-form">
             {users.list.map(user => (
                 <div className="section" key={user.id}>
                 <div className="divider"></div>
                     <h5 className="user-userName">{user.username}</h5>
                     <h5 className="user-userEmail">{user.email}</h5>
                     <Button className="btn-delete" color="info" onClick={() => handleDelete(user)}>Delete</Button>
                     <Button className="btn-edit" color="info" onClick={() => handleEdit(user)}>Edit</Button>
                 </div>
             ))}
        </form>
     </div>

    );

}