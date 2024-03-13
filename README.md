# Hoja De Trabajo 6

Operaciones con mapas.

## Información

Universidad del Valle de Guatemala  
Facultad de Ingeniería  
Departamento de Ciencias de la Computación  
CC2016 - Algoritmos y Estructura de Datos  
Guatemala, 12 de marzo de 2024

## Colaboradores

- Cristian Túnchez (231359)
- Javier Linares (231135)

## Controlador de Versiones

[Repositorio Hoja-De-Trabajo-6-AED](https://github.com/Tunchxz/Hoja-De-Trabajo-6-AED "Enlace a GitHub")

## Respuestas del PDF

1. Use un profiler para evaluar el tiempo de ejecución de su programa para mostrar las cartas. Corra su programa con las tres implementaciones y muestre los tiempos de ejecución de cada una de ellas. Diga cuál es la más rápida con el profiler.
   Al analizar estos resultados con el profiler, se observa que la implementación HashMap fue la más rápida en términos de tiempo de ejecución para mostrar todas las cartas. Esto se debe probablemente a que HashMap utiliza una estructura de tabla hash para almacenar los elementos, lo que proporciona un acceso rápido y eficiente a los elementos. Por lo tanto, en base a estos resultados, se puede concluir que la implementación HashMap es la más eficiente en este contexto para mostrar todas las cartas en la colección.

2. Calcule la complejidad de tiempo para la implementación HashMap, para mostrar todas las cartas. Indique como llegó a ese resultado.
   En el caso de HashMap, la complejidad de tiempo para mostrar todos sus elementos es proporcional al número de elementos almacenados en la HashMap. Siendo n el número total de elementos, la complejidad sería O(n). Para el programa de cartas, sería O(8861).
