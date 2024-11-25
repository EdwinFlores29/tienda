import React from 'react';
import ListarProductos from "../listarTablas/ListarProductos";
import ListarCategorias from "../listarTablas/ListarCategorias";
export default function Home(){
    return(
        <div className="container">
            <ListarCategorias />
            <ListarProductos />
        </div>
    )
}