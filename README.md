# Rada's egen gartner

## Hensikt
Automatisk vanning av plantene gjennom rest-kall til en Arduino. 

## Funksjonalitet

### Endepunkter
`POST /vanning?mengde=X` - Vanner plante med x dl. 

## CI/CD
Push til main eller 'dev-*' trigger i gang main workflow. 
Denne kjører alle testene, lager JAR fil, bygger og pushe docker image
til Amazon Elastic Container Registry og videre kjører i gang en App Runner Service i AWS.