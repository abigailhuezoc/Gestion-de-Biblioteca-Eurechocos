# Gestion de Biblioteca - Eurechocos

Este proyecto es un sistema interactivo basado en consola desarrollado en JAVA. Su objetivo es administrar de forma eficiente una biblioteca, gestionando libros tanto físicos como digitales, sus autores, los usuarios y los préstamos, aplicando los principios aprendidos en la Programación Orientada a Objetos.

# Características y funcionalidades
* **Gestión de Catálogo:** Se registran libros con título, autor, tipo y año.
* **Gestión de Usuarios (HU-02):** Registro de usuarios (nombre, documento, contacto) para habilitar el préstamo de material.
* **Sistema de Préstamos y Devoluciones (HU-03, HU-04):** Permite asignar libros a usuarios (validando que no estén previamente prestados) y procesar devoluciones, actualizando automáticamente el estado del libro.
* **Búsqueda Avanzada (HU-05):** Búsqueda de libros por coincidencias parciales de título o autor.
* **Control y Monitoreo (HU-06, HU-08):** Visualización de todos los libros actualmente prestados (con usuario y fecha) y generación de reportes administrativos (totales y libros más prestados).
* **Persistencia de Datos (HU-07):** Guardado y carga automática de la información en archivos para evitar la pérdida de datos entre sesiones.
