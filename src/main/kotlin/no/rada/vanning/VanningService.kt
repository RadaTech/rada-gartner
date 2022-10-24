package no.rada.vanning

import org.slf4j.LoggerFactory

class VanningService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    internal fun vannPlante(mengdeVann: Number){
        logger.info("Vanner plante med $mengdeVann dl")
    }
}