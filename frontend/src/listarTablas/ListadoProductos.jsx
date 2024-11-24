import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import {NumericFormat} from "react-number-format";
export default function ListadoProductos(){

    const urlBase = "http://localhost:8080/tienda-app/productos"

    const [productos, setProductos] = useState([]);

    useEffect(() => {
        cargarProductos();
    }, []);

    const cargarProductos = async () => {
        const resultado = await axios.get(urlBase);
        console.log("Cargar resultados de productos");
        console.log(resultado.data);
        setProductos(resultado.data);
    }

    const eliminarProductos = async  (id) => {
        await axios.delete(`${urlBase}/${id}`);
        cargarProductos();
    }
    return (
        <div className="container">
            <div className="container text-center" style={{margin: "30px"}}>
                <h3>
                    Tienda Demo - Productos
                </h3>
            </div>
            <table className="table table-hover align-middle">
                <thead className="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Estado</th>
                    <th scope="col">ID_Categoria</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                {
                    //Iteramos el arreglo de empleados
                    productos.map((producto, indice) => (
                        <tr key={indice}>
                            <th scope="row">{producto.idProducto}</th>
                            <td>{producto.descripcion}</td>
                            <td><NumericFormat value={producto.precio}
                                               displayType={'text'}
                                               thousandSeparator=','
                                               prefix={'C$'}
                                               decimalScale={2}
                                               fixedDecimalScale/></td>
                            <td>{producto.stock}</td>
                            <td>{producto.estado}</td>
                            <td>{producto.idCategoria}</td>
                            <td className="text-center">
                                <div>
                                    <button className="btn btn-warning btn-sm me-3">Editar</button>
                                    <button onClick={() => eliminarProductos(producto.idProducto)}
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