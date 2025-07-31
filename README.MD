**Necesito definir mejor los criteros para generar
el equipo que quiero.** 

Son seis pokemon por equipo, los criterios que recibiria 
esta api.

fechaNacimiento: dato base para que generacion tenia 10 años

paisQuieroVisitar: aspiracional region

ciudadNatal: nostalgia region cuando tenia 10 años

picanteOSalado: salado as true

bailarOGaming: gaming es true

tipoInicial: fuego, agua o planta

**Basado en esas caracteristicas, asi definiria cada pokemon(ordenadas en complejidad de la llamada)**

*Pokemon 1*: Dada el tipo inicial, elegir un pokemon que sea del mismo tipo o evoluciones de ese tipo

*Pokemon 2*: Dada la region que quiero visitar, elegir un pokemon de esa region, sumar los numeros
de la fecha de nacimiento y elegir el primero que quede en el rango de dicha region
(1-151 para Kanto, 152-251 para Johto, etc.)

*Pokemon 3*: Dada la preferencia de picante o salado, elegir un pokemon fuego o acero si elige picante,
si elige salado que sea tipo agua o tierra

*Pokemon 4*: Dada la preferencia de bailar o gaming, elegir un pokemon que sea tipo volador o electrico si elige bailar,
y tipo psiquico o roca si elige gaming 

*Pokemon 5*: Dada la fecha de nacimiento, elegir un pokemon de 
la region mas adhoc, elegir el tipo basado en su signo zodiacal

*Pokemon 6*: Dada la ciudad natal, elegir un pokemon de la region mas adhoc, elegir el tipo
basado en la contra de sus signo zodiacal



*Links interesantes*
Sobre como funciona webCLient u ekpres practicas
https://medium.com/@ayoubseddiki132/mastering-webclient-in-spring-boot-a-complete-guide-31482263bc92
Api de Pokemon
https://pokeapi.co
Docuemtnacion de Api Pokemon
https://pokeapi.co/docs/v2
