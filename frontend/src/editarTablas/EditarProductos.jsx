import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

export default function EditarProductos(){
    const urlBase = "http://localhost:8080/tienda-app/productos"
    const {id} = useParams();
    let navegacion = useNavigate();

    const [producto, setProducto] = useState({
        descripcion:"",
        precio:"",
        stock:"",
        estado:"",
        idCategoria:""
    });
   const {descripcion, precio, stock, estado, idCategoria} = producto;
   const onInputChange = (e)=>{
       setProducto({...producto, [e.target.name]: e.target.value});
   }
   useEffect( ()=>{
       cargarProducto();
   },[])
   const cargarProducto = async ()=>{
       const resultado = await axios.get(`${urlBase}/${id}`)
       setProducto(resultado.data);
   }
   const onSubmit = async (e)=>{
       e.preventDefault();
       await axios.put(``)
   }
    return(
        <div></div>
    )
}