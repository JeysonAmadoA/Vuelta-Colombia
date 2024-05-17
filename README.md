# Vuelta-Colombia
Proyecto Vuelta a Colombia, permite registrar, leer, actualizar y eliminar información sobre participantes, equipos, etapas y más para el seguimiento y organización de este evento deportivo.

## Centralización de Logs
Se hizo uso del Stack ELK (Elasticsearch, Logstash y Kibana) para la centralización de los logs del aplicativo. Esto permite una mejor gestión y análisis de los logs, facilitando la detección de problemas y el monitoreo del rendimiento del sistema.

- **Elasticsearch**: Motor de búsqueda y análisis que permite almacenar y buscar grandes volúmenes de datos de manera rápida.
- **Logstash**: Pipeline de procesamiento de datos que ingesta logs desde diversas fuentes, los transforma y los envía Elasticsearch.
- **Kibana**: Herramienta de visualización que trabaja con Elasticsearch para ofrecer gráficos y dashboards en tiempo real.

