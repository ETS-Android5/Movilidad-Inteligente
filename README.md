# Movilidad Inteligente - Intelligent mobility
Diseño de un sistema para la obtención de información de cupos en parqueaderos y zonas de parqueo públicas.

Integrantes: HEMERSON LEANDRO ALVAREZ RODRIGUEZ -
YEIKOOL ANDRES BALLESTEROS PINEDA -
SANTIAGO BENJUMEA HURTADO -
JUAN JOSE BERMUDEZ LOPERA 

En colaboración con: JOHAN SEBASTIAN MOSQUERA CAICEDO -
			WILLIAM RICARDO RUBIO SANCHEZ

UNIVERSIDAD DEL QUINDÍO

Design of a system to obtain information on free places in parking lots and public parking areas.

Members: HEMERSON LEANDRO ALVAREZ RODRIGUEZ -
YEIKOOL ANDRES BALLESTEROS PINEDA -
SANTIAGO BENJUMEA HURTADO -
JUAN JOSE BERMUDEZ LOPERA 

In collaboration with: JOHAN SEBASTIAN MOSQUERA CAICEDO -
WILLIAM RICARDO RUBIO SANCHEZ

UNIVERSIDAD DEL QUINDÍO


## Descripcion
Este proyecto pretende ayudar al Quindío, y específicamente al municipio de Armenia a encaminarse a convertirse en una ciudad o territorio inteligente según lo estipulado en el Plan de Desarrollo Nacional 2018-2022 (Pacto por Colombia, Pacto por la Equidad), enfocándose en la subdimensión de movilidad inteligente, donde se pretende mejorar la movilidad vehicular en el centro de la ciudad, optimizando el uso de las zonas de parqueo públicas y de los principales parqueaderos, mediante un software o aplicación la cual al estar finalizado su desarrollo, enviará información en tiempo real de la disponibilidad de cupos tanto en zonas de parqueo públicas como en los parqueaderos del centro de la ciudad. Este proyecto se enfoca en el modelado de dicha aplicación para servir de base para su posterior realización. Para el proyecto se tuvo en cuenta la estrategia CDIO (concebir, diseñar, implementar y operar) el cual en este documento se profundizará en las etapas de implementar y operar, en el cual se verificará su correcto funcionamiento del software y del hardware implementándolo en la universidad del Quindio. Además se tuvo en cuenta el documento que se realizó en las etapas de concebir y diseñar en las que se realizaron diferentes etapas de investigación y análisis para determinar qué tan viable era el proyecto. Para el diseño de dicho modelo fue necesario realizar las diferentes etapas de diseño (analizar las alternativas de diseño, especificación de diseño técnico, diseño preliminar y diseño detallado).

## Description
This project aims to help Quindío, and specifically the municipality of Armenia to move towards becoming a smart city or territory as stipulated in the National Development Plan 2018-2022 (Pact for Colombia, Pact for Equity), focusing on the smart mobility sub-dimension, where it is intended to improve vehicular mobility in the downtown, optimizing the use of public parking areas and the main parking lots, through a software or application that once its development is finished, it will send real-time information about the availability of parking spaces both in public parking areas and in the parking lots of the downtown. For this project the strategy CDIO was taken into account (conceive, design, implement and operate), in this present document stages implement and operate will be profundized, in which the software and hardware´s correct performance will be verified implementing it in Universidad del Quindio. Besides, the document developed in the conceive and design stages was taken into account in which different stages of research and analysis were necessary to determine how viable the project was. For the design of this model it was necessary to carry out the different design stages (analyze the design alternatives, technical design specification, preliminary design and detailed design).


## Problematica
Se identificó que en la ciudad de Armenia se presentan varios problemas de movilidad, ya que muchos vehículos estacionan en zonas prohibidas, ocupando una parte de los carriles generando atascos; esto ocurre debido a que los diferentes conductores y/o propietarios de los vehículos no tienen conocimiento de los diferentes espacios disponibles para el aparcamiento de sus vehículos en la zona donde se encuentran en el momento.

Una de las mayores ventajas con la implementación de este sistema es la mejora en la movilidad vehicular, teniendo que el parqueo de vehículos será más ordenado, de modo que los conductores tendrán mayor facilidad en la búsqueda de zonas de parqueo público (zonas azules) y parqueaderos cercanos a su lugar de destino, siendo posible una descongestión vehicular ya sea en la búsqueda de un zona de parqueo o de vehículos que están mal parqueados; siendo uno de los primeros pasos para convertir a Armenia en una ciudad o territorio inteligente.

## TROUBLESOME
It was identified that in the city of Armenia there are several mobility problems, since many vehicles park in prohibited areas, occupying a part of the lanes generating traffic jams; This occurs because the different drivers and / or vehicle owners are not aware of the different spaces available for parking their vehicles in the area where they are located at the moment.

One of the greatest advantages with the implementation of this system is the improvement in vehicular mobility, since the parking of vehicles will be more orderly, so that drivers will have greater ease in finding public parking areas (“Zonas azules”) and parking spaces close to their destination, being possible a vehicular decongestion either in the search for a parking area or vehicles that are wrong parked; being one of the first steps to turn Armenia into a smart city or territory.


## Zonas azules
Para las zonas azules fue pensado el diseño del circuito que cuenta con un microcontrolador arduino nano, que va conectado a un shield del arduino nano, un módulo WiFi Esp8266-01s y los sensores infrarrojos E18-d80nk, los cuales permitirán conocer los cupos disponibles en determinadas zonas azules. Además, el circuito tiene como alimentación el uso de dos paneles solares, dos pilas de litio y un cargador de baterías Tp4056, teniendo una autonomía de todo el día con los paneles cargando las baterías constantemente y por la noche con las pilas siendo empleadas.

## Public parking zone
For the “zonas azules”, the design of a circuit that has an arduino nano microcontroller was thought, which is connected to an arduino nano shield, an Esp8266-01s WiFi module and the E18-d80nk infrared sensors, which will allow everyone to know the available spaces in certain public parking zones. In addition, the circuit is powered by the use of two solar panels, two lithium cells and a Tp4056 battery charger, having an autonomy of the whole day with the panels constantly charging the batteries and at night with the batteries being used.

<img src="https://user-images.githubusercontent.com/47339991/145722558-3766c400-09a9-4b80-94ac-2775a50307a9.jpeg" height="400"> <img src="https://user-images.githubusercontent.com/47339991/145722871-890b23e8-bd16-4cff-b7de-7066c674de95.png" height="400">

## Aplicacion para los administradores
Para los administradores de los parqueaderos se emplea una aplicación que permitirá indicar cuántos cupos disponibles hay en el parqueadero en el momento, la cual puede ser utilizada a través de un celular. La programación de esta aplicación se realizó a través de la herramienta Android Studio que tiene un lenguaje de programación java.

## Parking administrator app
For the parking lots administrators, a mobile application is used that will allow them to indicate how many available spaces there are in the parking lot at the moment, which can be used through a cell phone. The programming of this application was done through the Android Studio tool that has a Java programming language.

<img src="https://user-images.githubusercontent.com/47339991/145721947-7144ccbd-cffb-42f2-b5e5-53f44005af9e.jpeg" width="200" height="400">

## Aplicacion para los usuarios
Para la presentación de la información de los parqueaderos y zonas de parqueo se tiene el diseño de una aplicación móvil la cual puede ser usada por los usuarios a través de un celular, en donde se podrá observar la cantidad de cupos disponibles, así como la posibilidad de dirigirse a la aplicación google maps con el fin de entregarle indicación de como llegar al lugar que desea. La programación de esta aplicación se realizó a través de la herramienta android studio que tiene un lenguaje de programación java.

## Users app
For the presentation of the information of the parking lots and parking areas there is the design of a mobile application which can be used by users through a cell phone, where there could see the number of places available, as well as the possibility to get directed to the google maps application in order to give them indications of how to get to the place they want. The programming of this application was done through the android studio tool that has a Java programming language.

<img src="https://user-images.githubusercontent.com/47339991/145721895-da936898-36b2-4ce2-ae3e-f21e50ed26fb.jpeg" width="200" height="400">

## Video
[![Alt text](https://img.youtube.com/vi/zi-KjZmET5Y/0.jpg)](https://www.youtube.com/watch?v=zi-KjZmET5Y)
