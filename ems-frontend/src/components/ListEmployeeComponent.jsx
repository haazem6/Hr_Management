import React, { useEffect, useState } from 'react'
import { listEmployees ,deleteEmployee} from '../services/EmployeeService';
import {useNavigate} from 'react-router-dom'



const ListEmployeeComponent = () => {
 
    const [employees,setEmployee]=useState([]);
    const navigator=useNavigate();

    useEffect( () => {
        getAllEmployees();
  
    },[])
    function getAllEmployees(){
        listEmployees().then((response) => {
            setEmployee(response.data);
        }).catch(error => {
            console.error(error)
        })

    }
    function addNewEmployee(){
        navigator('/add-employee')

    }
    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee(id){
console.log(id)
deleteEmployee(id).then((resonse)=>{
    getAllEmployees
    

}).catch(error=> {
    console.log(error)
})
navigator('/employees')
}
    
  return (
    <div className='container'>
        <h2 className='text-center'>List of employees</h2>
        <button type="button" className="btn btn-primary" onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Fisrst Name</th>

                    <th>Employee Last Name</th>

                    <th>Employee Email Id</th>

                    <th>Action</th>

                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee =>
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                        <td>
                            <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>update</button>
                            <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}>delete</button>

                        </td>

            

                    </tr>)
                }
            </tbody>
        </table>

    </div>
  )
}

export default ListEmployeeComponent