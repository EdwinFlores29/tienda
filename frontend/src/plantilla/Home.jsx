import React from 'react';
import ListadoCategorias from "../listarTablas/ListadoCategorias";
import ListadoProductos from "../listarTablas/ListadoProductos";
export default function Home(){
    return(
        <div className="container">
            <ListadoCategorias />
            <ListadoProductos />
        </div>
    )
}