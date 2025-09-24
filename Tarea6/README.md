# Tarea 6 - Lanzador de Procesos

Este es un sencillo proyecto en Java que funciona como una utilidad de línea de comandos para ejecutar diversas herramientas de diagnóstico de red.

## Descripción

La aplicación permite al usuario introducir un nombre de host o una dirección IP para ejecutar comandos de red como `ping`, `nslookup` y `traceroute`. El programa está diseñado para ser interactivo y multiplataforma, ajustando automáticamente los comandos para que funcionen tanto en sistemas operativos Windows como Linux.

## Cómo Funciona

El proyecto se divide en dos clases principales:

-   `Interfaz.java`: Es el punto de entrada de la aplicación. Inicia un bucle interactivo que solicita al usuario un sitio web o una IP. La aplicación continuará pidiendo nuevos sitios hasta que el usuario escriba `salir`.
-   `LanzadorProceso.java`: Contiene la lógica para construir y ejecutar los comandos del sistema.
    -   Detecta el sistema operativo (Windows o Linux) para adaptar los comandos (`ping`, `traceroute`/`tracert`) y sus argumentos correspondientes.
    -   Utiliza `ProcessBuilder` para lanzar el proceso externo de forma segura.
    -   Captura y muestra en tiempo real tanto la salida estándar como la salida de errores del comando (tambien se puede hacer en un archivo log que va acumulando la informacion generada por las ejecuciones del programa) ejecutado, añadiendo un prefijo `[OK]` o `[ERROR]` a cada línea para una fácil identificación.

## Cómo Ejecutar el Proyecto

1.  **Compilar el código:**
    Necesitarás un JDK (Java Development Kit) instalado. Navega hasta la carpeta `src` y compila los archivos Java.
    ```sh
    javac Interfaz.java LanzadorProceso.java
    ```

2.  **Ejecutar la aplicación:**
    Una vez compilado, ejecuta la clase `Interfaz` desde el directorio `src`.
    ```sh
    java Interfaz
    ```

3.  **Uso:**
    Cuando el programa se inicie, te pedirá que introduzcas un host o IP. Escribe el destino (por ejemplo, `google.com` o `8.8.8.8`) y presiona Enter. Para terminar, escribe `salir`.
