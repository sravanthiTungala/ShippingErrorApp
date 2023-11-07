import axios from 'axios';
import {useEffect, useState } from "react";

function ShippingError()
{

//Logic
const [order, setOrder] = useState("");
const [shippingErrors, setErrors] = useState([]);
const [formSubmitted, setFormSubmitted] = useState(false);
const [orderStatus, setOrderStatus] = useState("");
const [numberOfErrors, setNumberOfErrors] = useState();
const [currentPage, setCurrentPage] = useState(1);
const itemsPerPage = 10; // Number of items to display per page


useEffect(() => {
    defineOrderStatusAndNoOfErrMsgs();
    }, [shippingErrors])


async function Load(order)
{
    //console.log(order);
    if(order){
        try{
            const result = await axios.get(
                `http://localhost:8089/shippingErrors/getShippingErrorsById/${order}`); 
                setErrors(result.data);

                setFormSubmitted(true); 
            
            // Set the flag to indicate form submission
            // console.log(result.data);
            }
            catch(error){
            console.error('Error loading shipping errors:', error);
            }
    }
    else{
        // Clear the results by setting shippingErrors to an empty array
        setErrors([]);
    }
    
}
function defineOrderStatusAndNoOfErrMsgs(){
setNumberOfErrors(shippingErrors.length);
    shippingErrors.forEach(function(shippingError){
        //console.log("closed_date"+shippingError.closed_date);
            if(shippingError.closed_date){
                setOrderStatus("CLOSED");
            }
            else{
                setOrderStatus("OPEN");
            }
    
    })
}
const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent page reload on form submission
    await Load(); // Fetch data when the form is submitted
    setCurrentPage(1); // Reset to the first page when a new search is performed
};
function formatDateTime(date) {
        // Format the date to display seconds
    return new Date(date).toLocaleString('en-US', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
    });
}
//Design
const indexOfLastItem = currentPage * itemsPerPage;
const indexOfFirstItem = indexOfLastItem - itemsPerPage;
const currentItems = shippingErrors.slice(indexOfFirstItem, indexOfLastItem);
const pageNumbers = [];
for (let i = 1; i <= Math.ceil(shippingErrors.length / itemsPerPage); i++) {
  pageNumbers.push(i);
}
return (
    <div>
        <h1 align="center">Shipping Error Details</h1>
    <div className="container mt-4" >
    <form onSubmit={handleSubmit}>          
            <div className="form-group">
                <label>Order ID</label>
                <input  type="text" className="form-control" id="order"
                value={order}
                onChange={(event) =>
                {
                    setOrder(event.target.value);   
                    //console.log(event.target.value);
                }}
                />
            </div>
            <div>
            <button   className="btn btn-primary mt-4"  onClick={() => Load(order)}>Submit</button>
            </div>   
            </form>
        </div>
        {formSubmitted && ( <div style = {{textAlign :'center',fontWeight : 'bold'}} >Order Status : <i>{orderStatus}</i></div>)}
        {formSubmitted && ( <div style = {{textAlign :'center',fontWeight : 'bold'}} >Number of Error Messages : <i>{numberOfErrors}</i></div>)}
                <br/>
                {formSubmitted && (
<table className="table table-dark" align="center">
<thead>
    <tr>
    <th scope="col">Order</th>
    <th scope="col">Date</th>
    <th scope="col">Error_Message</th>
    <th scope="col">Error_Code</th>
    <th scope="col">Location</th>
    <th scope="col">OpId</th>
    {orderStatus ==="CLOSED" && (
    <th scope="col">Closed_Date</th>)}
    </tr>
</thead>
    {currentItems.map(function fn(shippingError)
    {
            return(
            <tbody key={shippingError.order}>
                <tr>
                <td>{shippingError.order}</td>
                <td>{formatDateTime(shippingError.date_time)}</td>
                <td>{shippingError.message}</td>    
                <td>{shippingError.error_code}</td> 
                <td>{shippingError.location}</td>
                <td>{shippingError.metadata.opid}</td>
                {orderStatus ==="CLOSED" && (
                <td>{formatDateTime(shippingError.closed_date)}</td>)}
                </tr>
            </tbody>
            );
            })}
            </table>  
                )}  
{shippingErrors.length > itemsPerPage && (
                 <div style={{ textAlign: 'center' }}>
<div>
{pageNumbers.map((number) => (
<button
key={number}
onClick={() => setCurrentPage(number)}
style={{ margin: '5px' }}
>
{number}
</button>
))}
</div>
<div style={{ fontWeight: 'bold' }}>
Page {currentPage} of {Math.ceil(shippingErrors.length / itemsPerPage)}
</div>
</div>
)}
    </div>
            );
        }

export default ShippingError;
