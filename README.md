# Gestor de Farmacia

**Autor:** Diego Vergara

## Descripción

Sistema de gestión para registro y control de medicamentos en farmacias. Permite administrar la información de medicamentos incluyendo código, nombre comercial, laboratorio, tipo de venta, formato y requerimientos de refrigeración.

## Funcionalidades

- **Registro de Medicamentos**: Captura completa de datos de cada medicamento
- **Gestión CRUD**: Crear, leer, eliminar medicamentos
- **Persistencia de Datos**: Los datos se guardan automáticamente al cerrar la aplicación
- **Interfaz Intuitiva**: Diseño en tres secciones (formulario, tabla y controles)

## Características Técnicas

- **Arquitectura**: MVC (Modelo-Vista-Controlador)
- **Lenguaje**: Java
- **Interfaz Gráfica**: Swing
- **Persistencia**: Serialización de objetos

## Estructura del Proyecto

```
GestorFarmacia/
├── DiagramaClases.png       # Diagrama UML del sistema
├── README.md                # Este archivo
└── src/
    └── main/
        └── java/
            └── com/
                └── gestorfarmacia/
                    ├── Main.java              # Punto de entrada de la aplicación
                    ├── controller/            # Controladores (En desarrollo)
                    ├── model/
                    │   └── Medicamento.java   # Clase del modelo de datos
                    ├── view/
                    │   └── VentanaPrincipal.java # Interfaz gráfica
                    └── repository/            # Gestión de datos (En desarrollo)
```

## Cómo Ejecutar

1. Compilar el proyecto desde la carpeta raíz:
   ```bash
   javac src/main/java/com/gestorfarmacia/Main.java
   ```

2. Ejecutar la aplicación:
   ```bash
   java -cp src/main/java com.gestorfarmacia.Main
   ```

## Datos del Medicamento

Cada medicamento registrado contiene:

- **Código**: Identificador único
- **Nombre Comercial**: Nombre del medicamento
- **Laboratorio**: Fabricante
- **Tipo de Venta**: Libre, Receta Simple o Receta Retenida
- **Formato**: Pastillas, Jarabe o Inyectable
- **Refrigeración**: Indica si requiere almacenamiento en frío

## Estado del Proyecto

✅ **Completo y Funcional**

- ✅ Diseño UML
- ✅ Estructura de paquetes (patrón Spring Boot)
- ✅ Modelo de datos (Medicamento)
- [x] Interfaz gráfica completa
- [x] Controlador y lógica CRUD
- [x] Persistencia de datos (serialización)
- [x] Validaciones y manejo de errores

## Funcionalidades Implementadas

- ✅ **Agregar Medicamento**: Con validación de campos obligatorios y código único
- ✅ **Editar Medicamento**: Cargar datos seleccionados en el formulario
- ✅ **Eliminar Medicamento**: Con confirmación antes de eliminar
- ✅ **Persistencia Automática**: Los datos se guardan automáticamente al cerrar
- ✅ **Carga Automática**: Los datos se cargan al iniciar la aplicación
- ✅ **Validaciones**: Campos obligatorios y prevención de códigos duplicados
- ✅ **Interfaz Intuitiva**: Tabla interactiva y formulario organizado

---

**Versión**: 1.0  
**Última actualización**: Diciembre 2025
