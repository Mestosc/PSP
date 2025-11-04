# Tarea25 - Escáner de Puertos

Este proyecto es una aplicación de consola en Java que funciona como un simple escáner de puertos.

## Funcionalidad

El programa le solicita al usuario que introduzca una dirección IP y un número de puerto.

1.  **Validación de IP**: Verifica que la dirección IP introducida tenga un formato válido.
2.  **Escaneo de puerto específico**: Si el usuario introduce un número de puerto, el programa intenta conectarse a ese puerto en la IP especificada para verificar si está abierto.
3.  **Escaneo de puertos populares**: Si el usuario introduce `0` como puerto, el programa escanea una lista predefinida de puertos comunes (21, 22, 80, 443) en la IP objetivo para ver cuáles están disponibles.
4.  **Bucle interactivo**: La aplicación se ejecuta en un bucle, permitiendo al usuario escanear múltiples IP y puertos hasta que escriba `salir` para terminar el programa.

El escaneo de cada puerto se realiza mediante un metodo en específico para comprobar el puerto y la validacion se hace con un metodo propio garantizando modularidad y que el codigo para verificar si el puerto está abierto pueda extrapolarse
