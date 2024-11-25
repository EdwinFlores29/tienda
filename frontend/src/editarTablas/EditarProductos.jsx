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
        await axios.put(`${urlBase}/${id}`, producto);
        navegacion("/");
    }
    return(
        <div className="container">
            <div className="container text-center" style={{margin: '30px'}}>
                <h3>Editar Producto</h3>
            </div>
            <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="descripcion" className="form-label">Descripcion</label>
                    <input type="text" className="form-control" id="descripcion"
                           name="descripcion" required={true}
                           value={descripcion} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="precio" className="form-label">Precio</label>
                    <input type="number" className="form-control" id="precio"
                           name="precio" required={true}
                           value={precio} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="stock" className="form-label">Stock</label>
                    <input type="number" className="form-control" id="stock"
                           name="stock"
                           value={stock} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="estado" className="form-label">Estado</label>
                    <input type="text" className="form-control" id="estado"
                           name="estado"
                           value={estado} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="idCategoria" className="form-label">Categoria</label>
                    <input type="text" className="form-control" id="idCategoria"
                           name="idCategoria" disabled="color: #6c757d; cursor: not-allowed;"
                           value={idCategoria} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="text-center">
                    <button type="submit" className="btn btn-warning btn-sm me-3">Guardar</button>
                    <a href="/" className="btn btn-danger btn-sm">Regresar</a>
                </div>
            </form>
        </div>
    )
}