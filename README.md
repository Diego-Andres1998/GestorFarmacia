# 💊 Gestor de Farmacia

**Sistema de Gestión de Medicamentos - Arquitectura Refactorizada**

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/GUI-Swing-blue.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

**Autor:** Diego Vergara  
**GitHub:** [Diego-Andres1998/GestorFarmacia](https://github.com/Diego-Andres1998/GestorFarmacia)

---

## 📋 Descripción

Sistema profesional de gestión para registro y control de medicamentos en farmacias. Implementa una arquitectura MVC refactorizada con componentes reutilizables y separación clara de responsabilidades.

### ✨ Características Principales

- 🏗️ **Arquitectura Limpia**: Patrón MVC con componentes modulares
- 💾 **Persistencia Automática**: Guardado automático al cerrar y CRUD
- ✅ **Validación Centralizada**: Sistema de validación robusto
- 🎨 **Interfaz Profesional**: Componentes reutilizables en Swing
- 📊 **Gestión Completa**: CRUD completo de medicamentos
- 🔄 **Actualizaciones en Tiempo Real**: Tabla sincronizada automáticamente

---

## 🚀 Funcionalidades

### Operaciones CRUD
- ✅ **Agregar** medicamento con validación de campos
- ✅ **Editar** medicamento existente
- ✅ **Eliminar** con confirmación
- ✅ **Visualizar** todos los medicamentos en tabla interactiva
- ✅ **Limpiar** formulario

### Características Avanzadas
- 🔒 **Validación de código único** - Previene duplicados
- 💾 **Persistencia automática** - Guardado en archivo .dat
- 🔄 **Carga automática** - Al iniciar la aplicación
- ℹ️ **Diálogo "Acerca de"** - Con enlace clickeable a GitHub
- 🎯 **Interfaz intuitiva** - Formulario, tabla y botones organizados

---

## 🏛️ Arquitectura

### Patrón MVC Refactorizado

```
📦 com.gestorfarmacia
├── 📄 Main.java                    # Punto de entrada
│
├── 📁 model/
│   └── Medicamento.java            # Modelo de datos (Serializable)
│
├── 📁 view/
│   ├── VentanaPrincipal.java       # Vista principal
│   └── components/
│       ├── BasePanel.java          # Clase base abstracta (HERENCIA)
│       ├── PanelFormularioMedicamento.java
│       ├── PanelTablaMedicamentos.java
│       └── PanelBotonesCRUD.java
│
├── 📁 controller/
│   └── ControladorMedicamentos.java # Controlador MVC
│
├── 📁 repository/
│   ├── Repositorio.java            # Interface genérica CRUD (POLIMORFISMO)
│   └── GestorMedicamentos.java     # Implementación de persistencia
│
└── 📁 util/
    ├── Validador.java              # Interface (POLIMORFISMO)
    ├── Mapper.java                 # Interface genérica (POLIMORFISMO)
    ├── ValidadorFormulario.java    # Implementa Validador
    ├── MedicamentoMapper.java      # Implementa Mapper<Medicamento>
    ├── MensajeFactory.java         # Factory Pattern
    └── DialogoAcercaDe.java        # Diálogo "Acerca de"
```

### Diagrama UML Simplificado

```
┌─────────────────────────────────────────────────────────────────────┐
│                          INTERFACES                                 │
├─────────────────────────────────────────────────────────────────────┤
│  <<interface>>                <<interface>>            <<interface>>│
│   Validador                    Mapper<T>              Repositorio<T>│
│  + validar()              + crearDesdeFormulario()   + agregar(T)   │
│  + getMensajeError()      + cargarEnFormulario(T)   + eliminar(ID)  │
│                                                       + buscarPorId()│
│                                                       + obtenerTodos()│
└─────────────────────────────────────────────────────────────────────┘
         ▲                           ▲                        ▲
         │                           │                        │
         │implements          implements              implements
         │                           │                        │
┌────────┴────────┐       ┌──────────┴─────────┐    ┌────────┴────────┐
│ValidadorFormulario│     │MedicamentoMapper   │    │GestorMedicamentos│
├─────────────────┤       ├────────────────────┤    ├──────────────────┤
│- vista           │       │- vista             │    │- medicamentos    │
│- mensajeError    │       │                    │    │- rutaArchivo     │
├─────────────────┤       ├────────────────────┤    ├──────────────────┤
│+ validar()       │       │+ crearDesde...()   │    │+ agregar()       │
│+ validarCampos() │       │+ cargarEn...()     │    │+ eliminar()      │
└─────────────────┘       └────────────────────┘    │+ buscarPorId()   │
                                                      │+ obtenerTodos()  │
                                                      │+ guardarDatos()  │
                                                      └──────────────────┘

┌─────────────────────────────────────────────────────────────────────┐
│                        CLASE ABSTRACTA                              │
├─────────────────────────────────────────────────────────────────────┤
│                       BasePanel (abstract)                          │
│         + inicializarComponentes() {abstract}                       │
│         + limpiar() {abstract}                                      │
│         + configurarBorde(String)                                   │
└─────────────────────────────────────────────────────────────────────┘
                              ▲
                              │ extends
                 ┌────────────┼────────────┐
                 │            │            │
    ┌────────────┴─────┐  ┌──┴──────────┐ ├─────────────────┐
    │PanelFormulario...│  │PanelBotones │ │PanelTabla...    │
    │- restricciones: GBC│  │- botones:Map│ │- modelo: DTM    │
    │+ limpiar()       │  │+ limpiar()  │ │+ getTabla()     │
    └──────────────────┘  └─────────────┘ └─────────────────┘

┌─────────────────────────────────────────────────────────────────────┐
│                           MODELO                                    │
├─────────────────────────────────────────────────────────────────────┤
│                     Medicamento (Serializable)                      │
│  - codigo: String                                                   │
│  - nombreComercial: String                                          │
│  - laboratorio: String                                              │
│  - tipoVenta: String                                                │
│  - formato: String                                                  │
│  - requiereFrio: boolean                                            │
│  + getters/setters                                                  │
└─────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────┐
│                         CONTROLADOR                                 │
├─────────────────────────────────────────────────────────────────────┤
│                    ControladorMedicamentos                          │
│  - vista: VentanaPrincipal                                          │
│  - gestor: GestorMedicamentos                                       │
│  - validador: ValidadorFormulario                                   │
│  - mapper: MedicamentoMapper                                        │
│  - modoEdicion: boolean                                             │
│  + agregarMedicamento()                                             │
│  + eliminarMedicamento()                                            │
│  + actualizarMedicamento()                                          │
│  + cargarMedicamentoSeleccionado()                                  │
└─────────────────────────────────────────────────────────────────────┘
```

---

## 📊 Datos del Medicamento

Cada medicamento registrado contiene:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| **Código** | String | Identificador único |
| **Nombre Comercial** | String | Nombre del medicamento |
| **Laboratorio** | String | Fabricante/Laboratorio |
| **Tipo de Venta** | Enum | Libre, Receta Simple, Receta Retenida |
| **Formato** | Enum | Pastillas, Jarabe, Inyectable |
| **Refrigeración** | Boolean | Requiere almacenamiento en frío |

---

## 💻 Instalación y Ejecución

### Requisitos Previos
- ☕ Java 17 o superior
- 🛠️ JDK instalado

### Compilar el Proyecto

```bash
# Navegar al directorio del proyecto
cd GestorFarmacia

# Compilar desde la raíz
javac -d bin src/main/java/com/gestorfarmacia/**/*.java
```

### Ejecutar la Aplicación

```bash
# Usando el classpath compilado
java -cp bin com.gestorfarmacia.Main
```

### Ejecutar desde IDE
1. Abrir el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code)
2. Ejecutar `Main.java`

---

## 🎯 Uso del Sistema

### 1. Agregar Medicamento
1. Completar todos los campos del formulario
2. Seleccionar tipo de venta del combo box
3. Marcar formato con radio buttons
4. Opcional: marcar si requiere refrigeración
5. Click en **"Agregar"**

### 2. Editar Medicamento
1. Seleccionar medicamento de la tabla
2. Click en **"Editar"**
3. Modificar los campos necesarios
4. Click en **"Actualizar"**

### 3. Eliminar Medicamento
1. Seleccionar medicamento de la tabla
2. Click en **"Eliminar"**
3. Confirmar la eliminación

### 4. Limpiar Formulario
- Click en **"Limpiar"** para resetear todos los campos

---

## 📈 Métricas del Proyecto

### Código Refactorizado

| Clase | Líneas | Responsabilidad |
|-------|--------|-----------------|
| Main | 24 | Inicialización |
| Medicamento | ~50 | Modelo de datos |
| **VentanaPrincipal** | **127** | Orquestación UI (-47% vs original) |
| PanelFormularioMedicamento | 135 | Formulario entrada |
| PanelTablaMedicamentos | 44 | Visualización datos |
| PanelBotonesCRUD | 49 | Botones acción |
| **ControladorMedicamentos** | **162** | Lógica negocio (-36% vs original) |
| GestorMedicamentos | 81 | Persistencia |
| DialogoAcercaDe | 47 | Diálogo info |
| ValidadorFormulario | 52 | Validación |
| MedicamentoMapper | 75 | Mapeo datos |
| MensajesUI | 54 | Mensajes UI |
| **TOTAL** | **~900** | Proyecto completo |

### Mejoras de Refactorización
- 📉 **VentanaPrincipal**: 241 → 127 líneas (**-47%**)
- 📉 **ControladorMedicamentos**: 255 → 162 líneas (**-36%**)
- ♻️ **4 componentes** reutilizables creados
- 🎯 **Principios SOLID** aplicados

---

## 📚 Documentación Adicional

### Diagramas UML
El proyecto incluye diagramas UML completos:
- 🏗️ Arquitectura general del sistema
- 📊 Diagrama de clases detallado
- 📦 Diagrama de paquetes
- 🔄 Diagramas de secuencia (Agregar, Editar)

Ver: [`diagramas_uml.html`](diagramas_uml.html) (exportable a PDF)

---

## ✅ Estado del Proyecto

### Completado
- ✅ Diseño UML completo
- ✅ Arquitectura MVC refactorizada
- ✅ Modelo de datos (Medicamento)
- ✅ Componentes de vista modulares
- ✅ Controlador con clases helper
- ✅ Persistencia automática
- ✅ Validaciones robustas
- ✅ Interfaz profesional
- ✅ Documentación completa

### Calidad del Código
- ✅ Principios SOLID aplicados
- ✅ Patrones de diseño implementados
- ✅ Código limpio y mantenible
- ✅ Componentes reutilizables
- ✅ Sin duplicación de código
- ✅ Separación de responsabilidades

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 17+
- **GUI**: Swing (javax.swing)
- **Persistencia**: Serialización de objetos (ObjectOutputStream/ObjectInputStream)
- **Layouts**: BorderLayout, GridBagLayout, FlowLayout
- **Eventos**: ActionListener, WindowAdapter

---

## 📝 Próximas Mejoras Potenciales

- 🧪 Testing unitario con JUnit
- 🌍 Internacionalización (i18n)
- 🎨 Soporte para temas (light/dark)
- 📄 Exportación a PDF
- 🔍 Búsqueda y filtros avanzados
- 💾 Soporte para bases de datos

---

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

---

## 👤 Autor

**Diego Vergara**
- GitHub: [@Diego-Andres1998](https://github.com/Diego-Andres1998)
- Proyecto: [GestorFarmacia](https://github.com/Diego-Andres1998/GestorFarmacia)

---

**Versión:** 1.0
**Última actualización:** Diciembre 2025  
**Estado:** ✅ Producción Lista
