import React, { useState } from 'react';
import axios from "axios";
import {useNavigate } from "react-router-dom";
export default function AgregarCategoria(){
    let navegacion = useNavigate();

    const [categoria, setCategoria] = useState({
        descripcion:"",
        estado:""
    });
    const {descripcion, estado} = categoria;

    const onInputChange = (e) =>{
        setCategoria({...categoria, [e.target.name]: e.target.value});
    }

    const onSubmit = async (e) => {
        e.preventDefault();
        const urlBase = "http://localhost:8080/tienda-app/categorias-guardar"
        await axios.post(urlBase, categoria);
        navegacion("/");
    }
    return (
        <div className="container">
            <div className="container text-center" style={{margin: '30px'}}>
                <h3>Agregar Categoria</h3>
            </div>
            <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="descripcion" className="form-label">Descripcion</label>
                    <input type="text" className="form-control" id="descripcion"
                           name="descripcion" required={true}
                           value={descripcion} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="estado" className="form-label">Estado</label>
                    <input type="text" className="form-control" id="estado"
                           name="estado"
                           value={estado} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="text-center">
                    <button type="submit" className="btn btn-warning btn-sm me-3">Agregar</button>
                    <a href="/" className="btn btn-danger btn-sm">Regresar</a>
                </div>
            </form>
        </div>
    )
}