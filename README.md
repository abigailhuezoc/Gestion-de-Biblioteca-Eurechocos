# Gestion de Biblioteca - Eurechocos

Este proyecto es un sistema interactivo basado en consola desarrollado en JAVA. Su objetivo es administrar de forma eficiente una biblioteca, gestionando libros tanto físicos como digitales, sus autores, los usuarios y los préstamos, aplicando los principios aprendidos en la Programación Orientada a Objetos.

## Características y funcionalidades
* **Gestión de Catálogo:** Se registran libros con título, autor, género y año.
* **Gestión de Usuarios:** Se registran usuarios (nombre, dui) para generar el préstamo.
* **Sistema de Préstamos y Devoluciones:** Permite asignar libros a usuarios (y valida previamente que no se encuentren prestados) actualizando automáticamente el estado del libro en el sistema.
* **Búsqueda:** Búsqueda de libros por coincidencias de título o autor.
* **Control y Monitoreo:** Se pueden visualizar todos los libros actualmente prestados (con usuario y fecha).
* **Persistencia de Datos:** La información se guarda y se carga de forma automática para evitar la pérdida de datos entre sesiones.

## Diseño
1. **Modelo:** Contiene las entidades principales y la lógica de negocio.
2. **Servicios:** Maneja la lógica de operaciones como búsquedas, generación de reportes y validaciones.
3. **Presentación:** Interfaz por consola para la interacción con el bibliotecario o usuario.
