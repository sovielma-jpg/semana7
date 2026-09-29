# SpeedFast - Gestión de Entregas (Semana 7)

Proyecto académico desarrollado en **Java Swing** para la empresa ficticia *SpeedFast*.  
Este sistema permite gestionar pedidos y entregas mediante una interfaz gráfica de escritorio.

## Funcionalidades
- Registrar nuevos pedidos (ID, Dirección, Tipo).
- Visualizar pedidos en una tabla (`JTable`).
- Asignar repartidores e iniciar entregas.
- Navegación entre ventanas desde la ventana principal.
- Almacenamiento básico en listas en memoria (sin base de datos).

## Estructura del Proyecto

drivers/
├── mysql-connector-j-26.7.0.jar   
src/
├── dao/
│   ├── ConexionBD.java
│   ├── EntregaDAO.java
│   ├── PedidoDAO.java
│   └── RepartidorDAO.java
├── main/
│   └── Main.java
├── modelo/
│   ├── Entrega.java
│   ├── Pedido.java
│   └── Repartidor.java
└── vista/
    ├── VentanaAsignarRepartidor.java
    ├── VentanaListaPedidos.java
    ├── VentanaPrincipal.java
    ├── VentanaRegistroPedido.java
    └── VentanaRegistroRepartidor.java

---

## Dependencias

Este proyecto utiliza el **conector MySQL** para Java:

- **MySQL Connector/J** (`mysql-connector-j-26.7.0.jar`)
- Versión recomendada: `8.0.33` o superior.

### 🔧 Configuración

1. Descarga el conector desde el sitio oficial:  
   [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

2. Coloca el archivo `.jar` dentro de la carpeta `drivers/` del proyecto.

3. Agrega la dependencia en librerias


