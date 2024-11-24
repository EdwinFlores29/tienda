import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
export default function (){
    const urlBase = "http://localhost:8080/tienda-app/categorias"

    const [categorias, setCategorias] = useState([]);

    useEffect(()=>{
        cargarCategoria();
    },[]);
    const cargarCategoria = async () => {
        const resultado = await axios.get(urlBase);
        console.log("Cargar resultado categorias");
        console.log(resultado.data);
        setCategorias(resultado.data);
    }

    const eliminarCategoria = async (id) => {
        await axios.delete(`${urlBase}/${id}`);
        cargarCategoria();
    }

    return (
        <div className="container">
            <div className="container text-center" style={{margin: "30px"}}>
                <h3>
                    Tienda Demo - Categorias
                </h3>
            </div>
            <table className="table table-hover align-middle">
                <thead className="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Estado</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                {
                    //Iteramos el arreglo de empleados
                    categorias.map((categoria, indice) => (
                        <tr key={indice}>
                            <th scope="row">{categoria.idCategoria}</th>
                            <td>{categoria.descripcion}</td>
                            <td>{categoria.estado}</td>
                            <td className="text-center">
                                <div>
                                    <Link to={`/editar-categoria/${categoria.idCategoria}`}
                                          className="btn btn-warning btn-sm me-3">Editar</Link>
                                    <button onClick={() => eliminarCategoria(categoria.idCategoria)}
                                            className="btn btn-danger btn-sm">Eliminar
                                    </button>
                                </div>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}