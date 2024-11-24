import React from 'react';
import ListadoCategorias from "../listarTablas/ListadoCategorias";
import ListadoProductos from "../listarTablas/ListadoProductos";
import ListadoProductosFull from "../listarTablas/ListadoProductosFull";
export default function Home(){
    return(
        <div className="container">
            <ListadoCategorias />
            <ListadoProductosFull />
        </div>
    )
}