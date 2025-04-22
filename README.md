
# API Gateway

A lightweight, configurable API Gateway with dual configuration support.

## Features
- Dual routing configuration: Java DSL & YAML
- Path-based routing
- Header manipulation
- Service discovery integration
- Lightweight footprint

## Configuration Options

### 1. Fluid Java DSL and YML
Programmatic route definition:
```java
Gateway.routing()
   .route("demo-service")
      .path("/demo/**")
      .uri("lb://demo-service")
   .build();

```
YML configuration:
```yaml
routes:
  - id: dem-service
    uri: lb://demo-service
    predicates:
      - Path=/demo/**
    filters:
      - StripPrefix=1
```
